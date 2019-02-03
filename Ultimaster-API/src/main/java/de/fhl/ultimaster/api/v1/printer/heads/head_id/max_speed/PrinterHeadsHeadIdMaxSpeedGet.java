package de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.MaxSpeed;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdMaxSpeedGet {

    /** Returns max speed of head by ID.
     * @param printer Connection information of the printer
     * @param headId ID of head of which to get the max speed of
     * @return {@link MaxSpeed} */
    public static MaxSpeed get(Printer printer, long headId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/max_speed");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedGetResponseParser.parse(response);
    }

}
