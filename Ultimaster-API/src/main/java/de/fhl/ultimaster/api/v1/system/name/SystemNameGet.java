package de.fhl.ultimaster.api.v1.system.name;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemNameGet {

    /** Get the name of the system.
     * @param printer Connection information of the printer
     * @return Name of the system */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/name");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemNameGetResponseParser.parse(response);
    }

}
