package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.Feeder;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.PrinterHeadsHeadIdExtrudersExtruderIdFeederGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdFeederGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/extruders/extruder_id/feeder/PrinterHeadsHeadIdExtrudersExtruderIdFeederGet.json");
        Feeder feeder = PrinterHeadsHeadIdExtrudersExtruderIdFeederGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(feeder.getPosition() == 0);
        Assert.assertTrue(feeder.getMax_speed() == 0);
        Assert.assertTrue(feeder.getJerk() == 0);
        Assert.assertTrue(feeder.getAcceleration() == 0);
    }

}
