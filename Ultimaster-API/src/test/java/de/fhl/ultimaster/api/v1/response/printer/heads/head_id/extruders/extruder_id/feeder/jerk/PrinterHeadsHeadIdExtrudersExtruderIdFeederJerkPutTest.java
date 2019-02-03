package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.jerk;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.feeder.jerk.PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkPutTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdFeederJerkPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkPutResponseParser.parse(mockedHttpResponse));
    }
}
