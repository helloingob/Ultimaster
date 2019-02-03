package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.active_material.length_remaining;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGet {

    /** Returns length of material remaining on spool in mm. Or -1 if no value is known.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the hotend is fetched
     * @param extruderId ID of extruder from which the hotend is fetched
     * @return Length of material remaining */
    public static Double get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/active_material/length_remaining");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetResponseParser.parse(response);
    }

}
