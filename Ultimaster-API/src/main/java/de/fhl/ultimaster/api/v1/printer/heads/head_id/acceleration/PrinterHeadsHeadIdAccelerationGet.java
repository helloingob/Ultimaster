package de.fhl.ultimaster.api.v1.printer.heads.head_id.acceleration;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdAccelerationGet {

    /** Returns default acceleration of head by ID.
     * @param printer Connection information of the printer
     * @param headId ID of head of which to get the default acceleration of
     * @return Acceleration */
    public static Double get(Printer printer, long headId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId + "/acceleration");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdAccelerationGetResponseParser.parse(response);
    }

}
