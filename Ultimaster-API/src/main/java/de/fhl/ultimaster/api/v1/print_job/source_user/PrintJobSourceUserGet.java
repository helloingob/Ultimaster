package de.fhl.ultimaster.api.v1.print_job.source_user;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobSourceUserGet {

    /** If the origin equals to WEB_API, then this will return the user who initiated the job.
     * @param printer Connection information of the printer
     * @return Username who initiated the job */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/source_user");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobSourceUserGetResponseParser.parse(response);
    }

}
