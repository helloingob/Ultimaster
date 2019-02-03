package de.fhl.ultimaster.api.v1.printer.heads.head_id.position;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Position;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdPositionGet {

    /** Returns position of head by ID.
     * @param printer Connection information of the printer
     * @param headId ID of head of which to get position
     * @return {@link Position} */
    public static Position get(Printer printer, long headId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/position");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdPositionGetResponseParser.parse(response);
    }

}
