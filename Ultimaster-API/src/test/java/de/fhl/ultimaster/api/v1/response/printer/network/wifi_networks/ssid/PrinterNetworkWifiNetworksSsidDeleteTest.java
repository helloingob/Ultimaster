package de.fhl.ultimaster.api.v1.response.printer.network.wifi_networks.ssid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.network.wifi_networks.ssid.PrinterNetworkWifiNetworksSsidDeleteResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterNetworkWifiNetworksSsidDeleteTest {

    @Test
    public void testPrinterNetworkWifiNetworksSsidDeleteResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterNetworkWifiNetworksSsidDeleteResponseParser.parse(mockedHttpResponse));
    }

}
