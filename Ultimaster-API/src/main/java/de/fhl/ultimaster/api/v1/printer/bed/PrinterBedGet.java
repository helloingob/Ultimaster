package de.fhl.ultimaster.api.v1.printer.bed;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Bed;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterBedGet {

    /** Returns {@link Bed} object.
     * @param printer Connection information of the printer
     * @return {@link Bed} */
    public static Bed get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/bed");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterBetGetResponseParser.parse(response);
    }

}
