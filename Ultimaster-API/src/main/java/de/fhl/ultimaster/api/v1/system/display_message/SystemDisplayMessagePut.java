package de.fhl.ultimaster.api.v1.system.display_message;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.beep.BeepPutResponseParser;
import de.fhl.ultimaster.api.v1.objects.json.MessageData;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemDisplayMessagePut {

    /** Enable external services to display a message screen on the printer.
     * @param printer Connection information of the printer
     * @param messageData {@link MessageData} to display on the screen of the printer.
     * @return Success? */
    public static boolean put(Printer printer, MessageData messageData) {
        HttpPut request = new HttpPut(printer.getUrl() + "/system/display_message");
        addParameter(request, messageData);
        HttpResponse response = RestConnection.execute(printer, request);
        return BeepPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, MessageData messageData) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(messageData)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
