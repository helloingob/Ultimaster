package de.fhl.ultimaster.api.v1.system.hardware.typeid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemHardwareTypeidGet {

    /** Gets the machine type as number identifier. This identifier IDs a specific form of hardware.
     * @param printer Connection information of the printer
     * @return Machine type */
    public static Integer get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/hardware/typeid");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemHardwareTypeidGetResponseParser.parse(response);
    }

}
