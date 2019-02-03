package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Extruder;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.PrinterHeadsHeadIdExtrudersGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/extruders/PrinterHeadsHeadIdExtrudersGet.json");
        List<Extruder> extruders = PrinterHeadsHeadIdExtrudersGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(extruders.get(0).getHotend().getTemperature().getCurrent() == 0);
        Assert.assertEquals(extruders.get(0).getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(extruders.get(0).getHotend().getStatistics().getMaterialExtruded() == 0);

        Assert.assertTrue(extruders.get(0).getFeeder().getAcceleration() == 0);
        Assert.assertTrue(extruders.get(0).getActiveMaterial().getLengthRemaining() == 0);
    }

}
