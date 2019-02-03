package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.max_speed;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedPutResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedPut {

    /** Sets maximum Speed of feeder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder from which the feeder is fetched
     * @param maxSpeed Target max speed
     * @return Success? */
    public static boolean put(Printer printer, long headId, long extruderId, double maxSpeed) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/feeder/max_speed");
        addParameter(request, maxSpeed);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, double maxSpeed) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(String.valueOf(maxSpeed)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
