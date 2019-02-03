package de.fhl.ultimaster.api.v1.system.uptime;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemUptimeGet {

    /** Get the uptime of the system in seconds.
     * @param printer Connection information of the printer
     * @return Uptime of the system */
    public static Integer get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/uptime");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemUptimeGetResponseParser.parse(response);
    }

}
