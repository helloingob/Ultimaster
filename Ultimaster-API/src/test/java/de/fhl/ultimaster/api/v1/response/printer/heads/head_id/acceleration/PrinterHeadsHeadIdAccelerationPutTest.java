package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.acceleration;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.acceleration.PrinterHeadsHeadIdAccelerationPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdAccelerationPutTest {

    @Test
    public void testPrinterHeadsHeadIdAccelerationPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterHeadsHeadIdAccelerationPutResponseParser.parse(mockedHttpResponse));
    }
}
