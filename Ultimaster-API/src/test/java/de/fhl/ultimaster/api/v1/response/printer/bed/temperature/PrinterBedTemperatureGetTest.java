package de.fhl.ultimaster.api.v1.response.printer.bed.temperature;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.Temperature;
import de.fhl.ultimaster.api.v1.printer.bed.temperature.PrinterBetTemperatureGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterBedTemperatureGetTest {

    @Test
    public void testPrinterBedTemperatureGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/bed/temperature/PrinterBedTemperatureGet.json");
        Temperature temperature = PrinterBetTemperatureGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(temperature.getTarget() == 0);
        Assert.assertTrue(temperature.getCurrent() == 0);
    }
}
