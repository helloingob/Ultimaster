package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.acceleration;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.acceleration.PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithDoubleResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetResponseParser.parse(mockedHttpResponse) == 1.0);
    }
}
