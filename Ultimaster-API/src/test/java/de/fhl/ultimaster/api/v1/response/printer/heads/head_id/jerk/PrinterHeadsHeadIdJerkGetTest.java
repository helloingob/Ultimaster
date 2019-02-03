package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.jerk;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Jerk;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.jerk.PrinterHeadsHeadIdJerkGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdJerkGetTest {

    @Test
    public void testPrinterHeadsHeadIdJerkGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/jerk/PrinterHeadsHeadIdJerkGet.json");
        Jerk jerk = PrinterHeadsHeadIdJerkGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(jerk.getX() == 0);
        Assert.assertTrue(jerk.getY() == 0);
        Assert.assertTrue(jerk.getZ() == 0);
    }
}
