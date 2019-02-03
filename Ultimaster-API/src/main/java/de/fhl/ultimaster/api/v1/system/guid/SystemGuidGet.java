package de.fhl.ultimaster.api.v1.system.guid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemGuidGet {

    /** Get the GUID.<br>
     * Every machine as a unique identifier stored inside the board. This allows for unique identification of this machine. This identifier is a UUID4.
     * @param printer Connection information of the printer
     * @return GUID */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/guid");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemGuidGetResponseParser.parse(response);
    }

}
