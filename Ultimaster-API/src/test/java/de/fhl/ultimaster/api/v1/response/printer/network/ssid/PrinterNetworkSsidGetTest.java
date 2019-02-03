package de.fhl.ultimaster.api.v1.response.printer.network.ssid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.network.ssid.PrinterNetworkSsidGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterNetworkSsidGetTest {

    @Test
    public void testPrinterNetworkSsidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterNetworkSsidGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
