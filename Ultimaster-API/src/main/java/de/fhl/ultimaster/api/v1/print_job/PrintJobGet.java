package de.fhl.ultimaster.api.v1.print_job;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.PrintJob;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobGet {

    /** Returns currently running print.
     * @param printer Connection information of the printer
     * @return {@link PrintJob} */
    public static PrintJob get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobGetResponseParser.parse(response);
    }

}
