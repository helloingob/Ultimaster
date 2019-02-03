package de.fhl.ultimaster.api.v1.printer.network.wifi_networks.ssid;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.api.v1.materials.material_guid.MaterialsMaterialGuidDeleteResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterNetworkWifiNetworksSsidDelete {

    /** Forgets a SSID of a network.
     * @param printer Connection information of the printer
     * @param ssid SSID of the network to forget 
     * @return Success? */
    public static boolean delete(Printer printer, String ssid) {
        HttpDelete request;
        try {
            request = new HttpDelete(printer.getUrl() + "/printer/network/wifi_networks/" + URLEncoder.encode(ssid, StandardCharsets.UTF_8.toString()));
            HttpResponse response = RestConnection.execute(printer, request);
            return MaterialsMaterialGuidDeleteResponseParser.parse(response);
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
        return false;
    }

}
