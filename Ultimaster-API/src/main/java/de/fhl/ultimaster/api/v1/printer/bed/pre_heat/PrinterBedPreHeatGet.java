package de.fhl.ultimaster.api.v1.printer.bed.pre_heat;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.PreHeat;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterBedPreHeatGet {

    /** Returns {@link PreHeat} of pre-heating the heated bed.
     * @param printer Connection information of the printer
     * @return {@link PreHeat} */
    public static PreHeat get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/bed/pre_heat");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterBedPreHeatGetResponseParser.parse(response);
    }

}
