package de.fhl.ultimaster.api.v1.system.hardware.revision;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemHardwareRevisionGet {

    /** Get the hardware revision. The same machine could have different hardware revisions. When hardware is updated and software needs to know that hardware has changed, this revision number is changed. Currently only revision 0 is known.
     * @param printer Connection information of the printer
     * @return Hardware revision */
    public static Integer get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/hardware/revision");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemHardwareRevisionGetResponseParser.parse(response);
    }

}
