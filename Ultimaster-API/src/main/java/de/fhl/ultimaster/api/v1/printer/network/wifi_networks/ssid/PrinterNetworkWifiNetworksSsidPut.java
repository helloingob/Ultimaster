package de.fhl.ultimaster.api.v1.printer.network.wifi_networks.ssid;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterNetworkWifiNetworksSsidPut {

    /** Connects to a SSID.
     * @param printer Connection information of the printer
     * @param ssid SSID of the network to connect with
     * @param ssid Phassphrase of network to connect with
     * @return Success? */
    public static boolean put(Printer printer, String ssid, String passphrase) {
        HttpPut request;
        try {
            request = new HttpPut(printer.getUrl() + "/printer/network/wifi_networks/" + URLEncoder.encode(ssid, StandardCharsets.UTF_8.toString()));
            addParameter(request, passphrase);
            HttpResponse response = RestConnection.execute(printer, request);
            return PrinterNetworkWifiNetworksSsidPutResponseParser.parse(response);
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
        return false;
    }

    private static void addParameter(HttpPut request, String passphrase) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("passphrase", passphrase);
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
