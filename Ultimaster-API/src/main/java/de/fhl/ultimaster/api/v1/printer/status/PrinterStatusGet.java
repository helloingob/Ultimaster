package de.fhl.ultimaster.api.v1.printer.status;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterStatusGet {

    /** Get the status of the printer.
     * @param printer Connection information of the printer
     * @return {@link PrinterStatus} */
    public static PrinterStatus get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/status");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterStatusGetResponseParser.parse(response);
    }

}
