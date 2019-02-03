package de.fhl.ultimaster.api.v1.response.printer.heads.head_id;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Head;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.PrinterHeadsHeadIdGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdGetTest {

    @Test
    public void testPrinterHeadsHeadIdGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/PrinterHeadsHeadIdGet.json");
        Head head = PrinterHeadsHeadIdGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(head.getPosition().getX() == 0);
        Assert.assertTrue(head.getMaxSpeed().getY() == 0);
        Assert.assertTrue(head.getJerk().getZ() == 0);

        Assert.assertTrue(head.getExtruders().get(0).getHotend().getTemperature().getCurrent() == 0);
        Assert.assertEquals(head.getExtruders().get(0).getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(head.getExtruders().get(0).getHotend().getStatistics().getMaterialExtruded() == 0);

        Assert.assertTrue(head.getExtruders().get(0).getFeeder().getAcceleration() == 0);
        Assert.assertTrue(head.getExtruders().get(0).getActiveMaterial().getLengthRemaining() == 0);
    }

}
