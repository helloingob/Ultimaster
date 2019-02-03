package de.fhl.ultimaster.api.v1.printer.bed.temperature;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.printer.bed.Temperature;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterBedTemperatureGet {

    /** Returns {@link Temperature} of bed.
     * @param printer Connection information of the printer
     * @return {@link Temperature} */
    public static Temperature get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/bed/temperature");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterBetTemperatureGetResponseParser.parse(response);
    }

}
