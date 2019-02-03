package de.fhl.ultimaster.api.v1.printer;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterGet {

    /** Returns all printer state information.
     * @param printer Connection information of the printer
     * @return {@link Printer} */
    public static de.fhl.ultimaster.api.v1.objects.json.Printer get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterGetResponseParser.parse(response);
    }

}
