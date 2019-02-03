package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.max_speed;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.max_speed.PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedGetTestResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithDoubleResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedGetResponseParser.parse(mockedHttpResponse) == 1.0);
    }
}
