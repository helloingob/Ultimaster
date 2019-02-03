package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.temperature;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.Temperature;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend.temperature.PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/extruders/extruder_id/hotend/temperature/PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGet.json");
        Temperature temperature = PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(temperature.getTarget() == 0);
        Assert.assertTrue(temperature.getCurrent() == 0);
    }

}
