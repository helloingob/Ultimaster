package de.fhl.ultimaster.api.v1.system.country;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.api.v1.beep.BeepPutResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemCountryPut {

    /** Sets the country of the system.
     * @param printer Connection information of the printer
     * @param country Target country of system
     * @return Success? */
    public static boolean put(Printer printer, String country) {
        HttpPut request = new HttpPut(printer.getUrl() + "/system/country");
        addParameter(request, country);
        HttpResponse response = RestConnection.execute(printer, request);
        return BeepPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, String country) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity("\"" + country + "\""));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
