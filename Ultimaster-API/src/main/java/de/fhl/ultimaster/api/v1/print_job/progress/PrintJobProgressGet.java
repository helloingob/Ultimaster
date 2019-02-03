package de.fhl.ultimaster.api.v1.print_job.progress;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobProgressGet {

    /** Get the (estimated) progress for the current print job, a value between 0 and 1.
     * @param printer Connection information of the printer
     * @return Estimated progress */
    public static Double get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/progress");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobProgressGetResponseParser.parse(response);
    }

}
