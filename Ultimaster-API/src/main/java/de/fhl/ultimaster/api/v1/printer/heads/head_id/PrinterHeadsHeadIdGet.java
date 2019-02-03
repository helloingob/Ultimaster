package de.fhl.ultimaster.api.v1.printer.heads.head_id;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Head;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdGet {

    /** Returns head by ID.
     * @param printer Connection information of the printer
     * @param headId ID of head to fetch
     * @return {@link Head} */
    public static Head get(Printer printer, long headId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads/" + headId);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdGetResponseParser.parse(response);
    }

}
