package de.fhl.ultimaster.api.v1.system.variant;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemVariantGet {

    /** Gets the machines variant. Currently this can return "Ultimaker 3" or "Ultimaker 3 extended".
     * @param printer Connection information of the printer
     * @return Variant of the machine */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/variant");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemVariantGetResponseParser.parse(response);
    }

}
