package de.fhl.ultimaster.api.v1.response.printer.led;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Led;
import de.fhl.ultimaster.api.v1.printer.led.PrinterLedGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterLedGetTest {

    @Test
    @Ignore
    //API differs from live printer!
    public void testPrinterLedGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/led/PrinterLedGet.json");
        Led led = PrinterLedGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(led.getHue() == 0);
        Assert.assertTrue(led.getSaturation() == 0);
        //Assert.assertTrue(led.getValue() == 0);
    }

    @Test
    public void testPrinterLedGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/led/PrinterLedGetLive.json");
        Led led = PrinterLedGetResponseParser.parse(mockedHttpResponse);
        Assert.assertNotNull(led.getBlink());
        Assert.assertTrue(led.getHue() == 0);
        Assert.assertTrue(led.getSaturation() == 0);
        Assert.assertTrue(led.getBrightness() == 100.0);
    }

}
