package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.acceleration;

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

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationPut {

    /** Sets jerk of feeder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder from which the feeder is fetched
     * @param acceleration Target acceleration speed
     * @return Success? */
    public static boolean put(Printer printer, long headId, long extruderId, double acceleration) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/feeder/acceleration");
        addParameter(request, acceleration);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, double acceleration) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(String.valueOf(acceleration)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
