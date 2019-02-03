package de.fhl.ultimaster.api.v1.printer.network.ssid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterNetworkSsidGet {

    /** Returns the SSID of the network (if any).
     * @param printer Connection information of the printer
     * @return SSID */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/network/SSID");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterNetworkSsidGetResponseParser.parse(response);
    }

}
