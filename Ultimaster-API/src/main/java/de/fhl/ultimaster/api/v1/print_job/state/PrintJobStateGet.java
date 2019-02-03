package de.fhl.ultimaster.api.v1.print_job.state;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobStateGet {

    /** Get the {@link PrinterState} of the current print job.
     * @param printer Connection information of the printer
     * @return {@link PrinterState} */
    public static PrinterState get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/state");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobStateGetResponseParser.parse(response);
    }

}
