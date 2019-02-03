package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.active_material;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.ActiveMaterial;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGet {

    /** Get the {@link ActiveMaterial} of the extruder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder 
     * @return {@link ActiveMaterial} */
    public static ActiveMaterial get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/active_material");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetResponseParser.parse(response);
    }

}
