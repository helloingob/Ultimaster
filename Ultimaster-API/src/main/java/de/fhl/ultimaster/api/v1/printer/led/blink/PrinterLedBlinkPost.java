package de.fhl.ultimaster.api.v1.printer.led.blink;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.Blink;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterLedBlinkPost {

    /** Sets {@link Blink}.
     * @param printer Connection information of the printer
     * @param blink Blink parameter
     * @return Success? */
    public static boolean post(Printer printer, Blink blink) {
        HttpPost request = new HttpPost(printer.getUrl() + "/printer/led");
        addParameter(request, blink);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterLedBlinkPostResponseParser.parse(response);
    }

    private static void addParameter(HttpPost request, Blink blink) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(blink)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
