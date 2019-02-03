package de.fhl.ultimaster.api.v1.print_job.source_application;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.print_job.source_user.PrintJobSourceUserGetResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobSourceApplicationGet {

    /** If the origin equals to WEB_API, then this will return the application that sent the job.
     * @param printer Connection information of the printer
     * @return Applicationname */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/source_application");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobSourceUserGetResponseParser.parse(response);
    }

}
