package de.fhl.ultimaster.api.v1.printer.heads;

import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Head;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsGet {

    /** Returns all heads of the printer.
     * @param printer Connection information of the printer
     * @return List of {@link Head} */
    public static List<Head> get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/heads");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsGetResponseParser.parse(response);
    }

}
