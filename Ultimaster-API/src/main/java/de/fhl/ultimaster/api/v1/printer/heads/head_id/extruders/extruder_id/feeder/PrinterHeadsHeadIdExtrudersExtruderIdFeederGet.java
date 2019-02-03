package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.Feeder;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederGet {

    /** Returns {@link Feeder} of selected extruder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the extruder is fetched
     * @param extruderId ID of extruder from which the feeder is fetched
     * @return {@link Feeder} */
    public static Feeder get(Printer printer, int headId, int extruderId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/feeder");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdExtrudersExtruderIdFeederGetResponseParser.parse(response);
    }

}
