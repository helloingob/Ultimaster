package de.fhl.ultimaster.api.v1.response.printer.bed.pre_heat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.pre_heat.PrinterBedPreHeatPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterBedPreHeatPutTest {

    @Test
    public void testPrinterBedPreHeatPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterBedPreHeatPutResponseParser.parse(mockedHttpResponse));
    }

}
