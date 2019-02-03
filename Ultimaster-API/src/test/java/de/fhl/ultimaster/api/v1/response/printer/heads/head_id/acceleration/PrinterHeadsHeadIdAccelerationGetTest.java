package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.acceleration;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.acceleration.PrinterHeadsHeadIdAccelerationGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdAccelerationGetTest {

    @Test
    public void testPrinterHeadsHeadIdAccelerationGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithDoubleResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterHeadsHeadIdAccelerationGetResponseParser.parse(mockedHttpResponse) == 1.0);
    }
}
