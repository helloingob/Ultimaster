package de.fhl.ultimaster.api.v1.printer.heads.head_id.acceleration;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedPutResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdAccelerationPut {

    /** Sets the  default acceleration of a head.
     * @param printer Connection information of the printer
     * @param headId ID of head of which the acceleration is set
     * @param acceleration Target default acceleration
     * @return Success? */
    public static boolean put(Printer printer, long headId, double acceleration) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/acceleration");
        addParameter(request, acceleration);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, double acceleration) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(acceleration)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
