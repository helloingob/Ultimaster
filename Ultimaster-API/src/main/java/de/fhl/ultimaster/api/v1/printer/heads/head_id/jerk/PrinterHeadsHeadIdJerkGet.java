package de.fhl.ultimaster.api.v1.printer.heads.head_id.jerk;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Jerk;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdJerkGet {

    /** Returns jerk of head by ID.
     * @param printer Connection information of the printer
     * @param headId ID of head of which to get the jerk of
     * @return {@link Jerk} */
    public static Jerk get(Printer printer, long headId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/jerk");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdJerkGetResponseParser.parse(response);
    }

}
