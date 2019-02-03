package de.fhl.ultimaster.api.v1.response.printer.bed;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Bed;
import de.fhl.ultimaster.api.v1.printer.bed.PrinterBetGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterBedGetTest {

    @Test
    public void testPrinterBedGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/bed/PrinterBedGet.json");
        Bed bed = PrinterBetGetResponseParser.parse(mockedHttpResponse);
        Assert.assertNotNull(bed.getTemperature());
        Assert.assertTrue(bed.getTemperature().getTarget() == 0);
        Assert.assertTrue(bed.getTemperature().getCurrent() == 0);
    }

    @Test
    public void testPrinterBedGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/bed/PrinterBedGetLive.json");
        Bed bed = PrinterBetGetResponseParser.parse(mockedHttpResponse);
        Assert.assertNotNull(bed.getTemperature());
        Assert.assertNotNull(bed.getPreHeat());
        Assert.assertFalse(bed.getPreHeat().getActive());
        Assert.assertTrue(bed.getTemperature().getTarget() == 0.0);
        Assert.assertTrue(bed.getTemperature().getCurrent() == 20.9);
    }
}
