package de.fhl.ultimaster.api.v1.response.printer.heads;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Head;
import de.fhl.ultimaster.api.v1.printer.heads.PrinterHeadsGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsGetTest {

    @Test
    public void testPrinterHeadsGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/PrinterHeadsGet.json");
        List<Head> heads = PrinterHeadsGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(heads.get(0).getPosition().getX() == 0);
        Assert.assertTrue(heads.get(0).getMaxSpeed().getY() == 0);
        Assert.assertTrue(heads.get(0).getJerk().getZ() == 0);

        Assert.assertTrue(heads.get(0).getExtruders().get(0).getHotend().getTemperature().getCurrent() == 0);
        Assert.assertEquals(heads.get(0).getExtruders().get(0).getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(heads.get(0).getExtruders().get(0).getHotend().getStatistics().getMaterialExtruded() == 0);

        Assert.assertTrue(heads.get(0).getExtruders().get(0).getFeeder().getAcceleration() == 0);
        Assert.assertTrue(heads.get(0).getExtruders().get(0).getActiveMaterial().getLengthRemaining() == 0);
    }

    @Test
    public void testPrinterHeadsGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/PrinterHeadsGetLive.json");
        List<Head> heads = PrinterHeadsGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(heads.get(0).getPosition().getX() == 0.0);
        Assert.assertTrue(heads.get(0).getMaxSpeed().getY() == 300.0);
        Assert.assertTrue(heads.get(0).getJerk().getZ() == 0.4);

        Assert.assertTrue(heads.get(0).getExtruders().get(0).getHotend().getTemperature().getCurrent() == 26.2);
        Assert.assertEquals(heads.get(0).getExtruders().get(0).getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(heads.get(0).getExtruders().get(0).getHotend().getStatistics().getMaterialExtruded() == 3120);

        Assert.assertTrue(heads.get(0).getExtruders().get(0).getFeeder().getAcceleration() == 3000.0);
        Assert.assertTrue(heads.get(0).getExtruders().get(1).getActiveMaterial().getLengthRemaining() == 43937.17796273972);
    }

}
