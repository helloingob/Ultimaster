package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.jerk;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.jerk.PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdFeederJerkGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithDoubleResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkGetResponseParser.parse(mockedHttpResponse) == 1.0);
    }
}
