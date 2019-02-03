package de.fhl.ultimaster.api.v1.printer.led;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.Led;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterLedPut {

    /**
     * Set the {@link Led} of the case lighting.
     * @param printer Connection information of the printer
     * @param color The colors of the case lighting
     * @return Success?
     */
    public static boolean put(Printer printer, Led led) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/led");
        addParameter(request, led);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterLedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, Led led) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(led)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
