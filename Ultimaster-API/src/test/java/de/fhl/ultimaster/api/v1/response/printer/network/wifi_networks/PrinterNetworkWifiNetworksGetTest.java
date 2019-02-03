package de.fhl.ultimaster.api.v1.response.printer.network.wifi_networks;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.WifiNetwork;
import de.fhl.ultimaster.api.v1.printer.network.wifi_networks.PrinterNetworkWifiNetworksGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterNetworkWifiNetworksGetTest {

    @Test
    @Ignore
    //API differs from live printer!
    public void testPrinterNetworkWifiNetworksGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/network/wifi_networks/PrinterNetworkWifiNetworksGet.json");
        List<WifiNetwork> wifiNetworks = PrinterNetworkWifiNetworksGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(wifiNetworks.size() > 0);
        WifiNetwork wifiNetwork = wifiNetworks.get(0);
        Assert.assertTrue(wifiNetwork.getSsid().equals("string"));
        Assert.assertTrue(wifiNetwork.getSecurityRequired());
        Assert.assertTrue(wifiNetwork.getStrength() == 0);
    }

    @Test
    public void testPrinterNetworkWifiNetworksGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/network/wifi_networks/PrinterNetworkWifiNetworksGetLive.json");
        List<WifiNetwork> wifiNetworks = PrinterNetworkWifiNetworksGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(wifiNetworks.size() > 0);
        WifiNetwork wifiNetwork = wifiNetworks.get(0);
        Assert.assertTrue(wifiNetwork.getSsid().equals("FHL-Wlan"));
        Assert.assertTrue(wifiNetwork.getSecurityRequired());
        Assert.assertTrue(wifiNetwork.getStrength() == 48);
    }

}
