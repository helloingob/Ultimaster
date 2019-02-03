package de.fhl.ultimaster.api.v1.print_job.time_total;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobTimeTotalGet {

    /** Get the (estimated) total time in seconds for this print, excluding pauses etc.
     * @param printer Connection information of the printer
     * @return Estimated total time */
    public static Integer get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/time_total");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobTimeTotalGetResponseParser.parse(response);
    }

}
