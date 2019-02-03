package de.fhl.ultimaster.api.v1.system;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.System;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemGet {

    /** Get the entire {@link System} object.
     * @param printer Connection information of the printer
     * @return {@link System} */
    public static System get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemGetResponseParser.parse(response);
    }

}
