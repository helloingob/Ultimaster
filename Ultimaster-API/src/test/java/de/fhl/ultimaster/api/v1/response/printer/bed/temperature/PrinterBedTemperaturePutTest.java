package de.fhl.ultimaster.api.v1.response.printer.bed.temperature;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.temperature.PrinterBedTemperaturePutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterBedTemperaturePutTest {

    @Test
    public void testPrinterBedTemperaturePutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterBedTemperaturePutResponseParser.parse(mockedHttpResponse));
    }

}
