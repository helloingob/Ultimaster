package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.position;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.position.PrinterHeadsHeadIdPositionPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdPositionPutTest {

    @Test
    public void testPrinterHeadsHeadIdPositionPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterHeadsHeadIdPositionPutResponseParser.parse(mockedHttpResponse));
    }
}
