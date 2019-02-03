package de.fhl.ultimaster.api.v1.printer.network;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Network;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterNetworkGet {

    /** Returns connection type of network.
     * @param printer Connection information of the printer
     * @return {@link Network} */
    public static Network get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/network");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterNetworkGetResponseParser.parse(response);
    }

}
