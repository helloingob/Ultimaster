package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.active_material.length_remaining;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.active_material.length_remaining.PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithDoubleResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetResponseParser.parse(mockedHttpResponse) == 1.0);
    }
}
