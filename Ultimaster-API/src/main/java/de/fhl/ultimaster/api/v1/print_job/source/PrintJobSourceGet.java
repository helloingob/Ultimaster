package de.fhl.ultimaster.api.v1.print_job.source;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobSourceGet {

    /** Returns from what source was the print job started. 
     * @param printer Connection information of the printer
     * @return {@link PrintJobSource} */
    public static PrintJobSource get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/source");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobSourceGetResponseParser.parse(response);
    }

}
