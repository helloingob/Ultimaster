package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.active_material.guid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGet {

    /** Returns the GUID of the active material.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the hotend is fetched
     * @param extruderId ID of extruder from which the hotend is fetched
     * @return GUID */
    public static String get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/active_material/guid");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetResponseParser.parse(response);
    }

}
