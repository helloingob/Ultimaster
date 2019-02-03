package de.fhl.ultimaster.api.v1.printer.heads.head_id.jerk;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.Jerk;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedPutResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdJerkPut {

    /** Sets the {@link Jerk} of a head.
     * @param printer Connection information of the printer
     * @param headId ID of head of which the jerk is set
     * @param jerk Target jerk
     * @return Success? */
    public static boolean put(Printer printer, long headId, Jerk jerk) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/jerk");
        addParameter(request, jerk);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, Jerk jerk) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity(new Gson().toJson(jerk)));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
