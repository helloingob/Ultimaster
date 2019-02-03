package de.fhl.ultimaster.api.v1.system.type;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemTypeGet {

    /** Get the type of machine that we are talking with. Always returns "3D printer".
     * @param printer Connection information of the printer
     * @return Always returns "3D printer" */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/type");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemTypeGetResponseParser.parse(response);
    }

}
