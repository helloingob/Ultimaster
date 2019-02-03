package de.fhl.ultimaster.api.v1.printer.network.wifi_networks;

import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.WifiNetwork;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterNetworkWifiNetworksGet {

    /** Returns connection type of network.
     * @param printer Connection information of the printer
     * @return List of {@link WifiNetwork} */
    public static List<WifiNetwork> get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/network/wifi_networks");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterNetworkWifiNetworksGetResponseParser.parse(response);
    }

}
