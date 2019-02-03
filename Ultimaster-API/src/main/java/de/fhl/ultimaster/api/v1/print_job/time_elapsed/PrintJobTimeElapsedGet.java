package de.fhl.ultimaster.api.v1.print_job.time_elapsed;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.print_job.time_total.PrintJobTimeTotalGetResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobTimeElapsedGet {

    /** Get the time elapsed (in seconds) since starting this print, including pauses etc.
     * @param printer Connection information of the printer
     * @return Time elapsed */
    public static Integer get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/time_elapsed");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobTimeTotalGetResponseParser.parse(response);
    }

}
