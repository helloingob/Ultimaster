package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.position;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Position;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.position.PrinterHeadsHeadIdPositionGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdPositionGetTest {

    @Test
    public void testPrinterHeadsHeadIdPositionGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/position/PrinterHeadsHeadIdPositionGet.json");
        Position position = PrinterHeadsHeadIdPositionGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(position.getX() == 0);
        Assert.assertTrue(position.getY() == 0);
        Assert.assertTrue(position.getZ() == 0);
    }
}
