package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders;

import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Extruder;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersGet {

    /** Returns all extruders of a head.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruders are fetched
     * @return List of {@link Extruder} */
    public static List<Extruder> get(Printer printer, long headId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersGetResponseParser.parse(response);
    }

}
