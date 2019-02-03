package de.fhl.ultimaster.api.v1.response.printer.network;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Network;
import de.fhl.ultimaster.api.v1.printer.network.PrinterNetworkGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterNetworkGetTest {

    @Test
    @Ignore
    //API differs from live printer!
    public void testPrinterNetworkGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithCustomStringResponse("wifi", HttpStatus.SC_OK);
        Assert.assertTrue(PrinterNetworkGetResponseParser.parse(mockedHttpResponse).equals("wifi"));
    }

    @Test
    public void testPrinterNetworkGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/network/PrinterNetworkGetLive.json");
        Network connection = PrinterNetworkGetResponseParser.parse(mockedHttpResponse);
        Assert.assertFalse(connection.getEthernet().isEnabled());
        Assert.assertTrue(connection.getWifi().isEnabled());
        Assert.assertEquals(connection.getWifiNetworks().get(0).getSsid(), "FHL-Wlan");
    }

}
