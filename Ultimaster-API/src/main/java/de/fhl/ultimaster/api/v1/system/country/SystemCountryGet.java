package de.fhl.ultimaster.api.v1.system.country;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemCountryGet {

    /** Get the country of the system.
     * @param printer Connection information of the printer
     * @return Country of the system */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/country");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemCountryGetResponseParser.parse(response);
    }

}
