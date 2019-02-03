package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Extruder;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdGet {

    /** Returns extruder by ID.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder to fetch
     * @return {@link Extruder} */
    public static Extruder get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdGetResponseParser.parse(response);
    }

}
