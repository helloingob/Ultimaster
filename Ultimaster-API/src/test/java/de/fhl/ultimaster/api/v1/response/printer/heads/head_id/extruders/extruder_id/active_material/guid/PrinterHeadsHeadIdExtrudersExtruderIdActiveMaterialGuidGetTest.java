package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.active_material.guid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.active_material.guid.PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
