package de.fhl.ultimaster.api.v1.response.printer.bed.pre_heat;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.PreHeat;
import de.fhl.ultimaster.api.v1.printer.bed.pre_heat.PrinterBedPreHeatGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterBedPreHeatGetTest {

    @Test
    public void testPrinterBedPreHeatGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/bed/pre_heat/PrinterBedPreHeatGet.json");
        PreHeat status = PrinterBedPreHeatGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(status.getActive());
        Assert.assertTrue(status.getRemaining() == 0);
    }

    @Test
    public void testPrinterBedPreHeatGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/bed/pre_heat/PrinterBedPreHeatGetLive.json");
        PreHeat status = PrinterBedPreHeatGetResponseParser.parse(mockedHttpResponse);
        Assert.assertFalse(status.getActive());
    }
}
