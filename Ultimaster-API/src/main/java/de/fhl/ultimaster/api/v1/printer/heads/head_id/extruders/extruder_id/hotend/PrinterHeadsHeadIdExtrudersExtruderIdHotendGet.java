package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.Hotend;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendGet {

    /** Returns {@link Hotend} of extruder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the hotend is fetched
     * @param extruderId ID of extruder from which the hotend is fetched
     * @return {@link Hotend} */
    public static Hotend get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/hotend");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdHotendGetResponseParser.parse(response);
    }

}
