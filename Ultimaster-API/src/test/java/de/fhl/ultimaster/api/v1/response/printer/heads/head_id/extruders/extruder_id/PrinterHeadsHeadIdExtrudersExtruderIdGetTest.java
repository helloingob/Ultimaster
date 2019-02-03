package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Extruder;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.PrinterHeadsHeadIdExtrudersExtruderIdGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/extruders/extruder_id/PrinterHeadsHeadIdExtrudersGet.json");
        Extruder extruder = PrinterHeadsHeadIdExtrudersExtruderIdGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(extruder.getHotend().getTemperature().getCurrent() == 0);
        Assert.assertEquals(extruder.getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(extruder.getHotend().getStatistics().getMaterialExtruded() == 0);

        Assert.assertTrue(extruder.getFeeder().getAcceleration() == 0);
        Assert.assertTrue(extruder.getActiveMaterial().getLengthRemaining() == 0);
    }

}
