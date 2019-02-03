package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend.temperature;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.printer.bed.Temperature;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGet {

    /** Returns {@link Temperature} of extruder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the hotend is fetched
     * @param extruderId ID of extruder from which the hotend is fetched
     * @return {@link Temperature} */
    public static Temperature get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/hotend/temperature");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetResponseParser.parse(response);
    }

}
