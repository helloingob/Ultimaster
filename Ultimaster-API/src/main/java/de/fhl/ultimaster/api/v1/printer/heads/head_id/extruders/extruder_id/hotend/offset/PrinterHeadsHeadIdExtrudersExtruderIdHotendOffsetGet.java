package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend.offset;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Offset;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGet {

    /** Returns {@link Offset} of hotend with respect to head.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder to fetch
     * @return {@link Offset} */
    public static Offset get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/hotend/offset");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetResponseParser.parse(response);
    }

}
