package de.fhl.ultimaster.api.v1.response.printer.led.blink;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.led.blink.PrinterLedBlinkPostResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterLedBlinkPostTest {

    @Test
    public void testAuthRequestResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterLedBlinkPostResponseParser.parse(mockedHttpResponse));
    }

}
