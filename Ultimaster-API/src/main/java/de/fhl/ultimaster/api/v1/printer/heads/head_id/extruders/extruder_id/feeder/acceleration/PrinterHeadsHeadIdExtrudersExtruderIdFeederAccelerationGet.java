package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.acceleration;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGet {

    /** Returns acceleration of feeder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder from which the feeder is fetched
     * @return Acceleration */
    public static Double get(Printer printer, long headId, long extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/feeder/acceleration");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetResponseParser.parse(response);
    }

}
