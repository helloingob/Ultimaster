package de.fhl.ultimaster.api.v1.printer.led;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Led;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterLedGet {

    /** Returns hue, saturation, and value (HSV) of the case lighting.
     * @param printer Connection information of the printer
     * @return {@link Led} */
    public static Led get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/led");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterLedGetResponseParser.parse(response);
    }

}
