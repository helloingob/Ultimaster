package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.max_speed;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdMaxSpeedPutTest {

    @Test
    public void testPrinterHeadsHeadIdMaxSpeedPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(mockedHttpResponse));
    }
}
