package de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.MaxSpeed;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdMaxSpeedPut {

    /** Sets the {@link MaxSpeed} of a head.
     * @param printer Connection information of the printer
     * @param headId ID of head of which the max speed is set
     * @param maxSpeed Target max speed
     * @return Success? */
    public static boolean put(Printer printer, long headId, MaxSpeed maxSpeed) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/max_speed");
        addParameter(request, maxSpeed);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, MaxSpeed maxSpeed) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(maxSpeed)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
