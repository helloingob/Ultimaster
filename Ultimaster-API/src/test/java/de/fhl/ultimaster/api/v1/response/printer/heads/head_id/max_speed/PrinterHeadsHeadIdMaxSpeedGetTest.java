package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.max_speed;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.MaxSpeed;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdMaxSpeedGetTest {

    @Test
    public void testPrinterHeadsHeadIdMaxSpeedGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/max_speed/PrinterHeadsHeadIdMaxSpeedGet.json");
        MaxSpeed maxSpeed = PrinterHeadsHeadIdMaxSpeedGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(maxSpeed.getX() == 0);
        Assert.assertTrue(maxSpeed.getY() == 0);
        Assert.assertTrue(maxSpeed.getZ() == 0);
    }
}
