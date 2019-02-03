package de.fhl.ultimaster.api.v1.printer.heads.head_id.position;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.Position;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdPositionPut {

    /** Sets the {@link Position} of a head.
     * @param printer Connection information of the printer
     * @param headId ID of head of which the position is set
     * @param position Target position
     * @return Success? */
    public static boolean put(Printer printer, long headId, Position position) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/position");
        addParameter(request, position);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdPositionPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, Position position) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(position)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
