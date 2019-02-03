package de.fhl.ultimaster.api.v1.print_job.name;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobNameGet {

    /** Returns the name of the current print job.
     * @param printer Connection information of the printer
     * @return Print job name */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/name");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobNameGetResponseParser.parse(response);
    }

}
