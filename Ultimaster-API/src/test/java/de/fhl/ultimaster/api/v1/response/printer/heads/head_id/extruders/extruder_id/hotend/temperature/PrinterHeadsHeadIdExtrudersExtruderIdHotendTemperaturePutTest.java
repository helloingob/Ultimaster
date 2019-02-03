package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.temperature;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend.temperature.PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePutTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePutResponseParser.parse(mockedHttpResponse));
    }
}
