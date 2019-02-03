package de.fhl.ultimaster.api.v1.response.printer.led;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.led.PrinterLedPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterLedPutTest {

    @Test
    public void testPrinterLedPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterLedPutResponseParser.parse(mockedHttpResponse));
    }

}
