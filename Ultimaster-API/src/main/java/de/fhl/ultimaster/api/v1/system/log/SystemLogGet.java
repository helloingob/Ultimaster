package de.fhl.ultimaster.api.v1.system.log;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemLogGet {

    /** Get the logs of the system from the current boot.
     * @param printer Connection information of the printer
     * @param lines *OPTIONAL* Allow a lines parameter to specify the number of lines to get from the log (Defaults to 50)
     * @return Log data */
    public static List<String> getFromCurrentBootSession(Printer printer, Double lines) {
        return get(printer, 0, lines);
    }

    /** Get the logs of the system from the previous boot.
     * @param printer Connection information of the printer
     * @param lines *OPTIONAL* Allow a lines parameter to specify the number of lines to get from the log (Defaults to 50)
     * @return Log data */
    public static List<String> getFromPreviousBootSession(Printer printer, Double lines) {
        return get(printer, -1, lines);
    }

    private static List<String> get(Printer printer, Integer boot, Double lines) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/log" + getParameter(boot, lines));
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemLogGetResponseParser.parse(response);
    }

    private static String getParameter(Integer boot, Double lines) {
        List<NameValuePair> nameValuePairs = new LinkedList<>();
        nameValuePairs.add(new BasicNameValuePair("boot", String.valueOf(boot)));
        if (lines != null) {
            nameValuePairs.add(new BasicNameValuePair("lines", String.valueOf(lines)));
        }
        return "?" + URLEncodedUtils.format(nameValuePairs, StandardCharsets.UTF_8);
    }

}
