package de.fhl.ultimaster.api.v1.history.print_jobs;

import de.fhl.ultimaster.api.v1.objects.json.PrintJobHistoric;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class HistoryPrintJobsGet {

    /** Get all past PrintJobs on this printer.
     * @param printer Connection information of the printer
     * @param offset *Optional* Allow a offset parameter to specify the start in the history to get jobs from. Defaults to 0 
     * @param count *Optional* Allow a count parameter to specify the number of jobs to get from the log. Defaults to 50
     * @return List of {@link PrintJobHistoric} */
    public static List<PrintJobHistoric> get(Printer printer, Double offset, Double count) {
        HttpGet request = new HttpGet(printer.getUrl() + "/history/print_jobs" + getParameter(offset, count));
        HttpResponse response = RestConnection.execute(printer, request);
        return HistoryPrintJobsGetResponseParser.parse(response);
    }

    private static String getParameter(Double offset, Double count) {
        List<NameValuePair> nameValuePairs = new LinkedList<>();
        if (offset != null) {
            nameValuePairs.add(new BasicNameValuePair("offset", String.valueOf(offset)));
        }
        if (count != null) {
            nameValuePairs.add(new BasicNameValuePair("count", String.valueOf(count)));
        }
        return "?" + URLEncodedUtils.format(nameValuePairs, StandardCharsets.UTF_8);
    }

}
