package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.active_material;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.ActiveMaterial;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.active_material.PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/extruders/extruder_id/active_material/PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGet.json");
        ActiveMaterial activeMaterial = PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(activeMaterial.getLengthRemaining() == 0);
        Assert.assertTrue(activeMaterial.getGuid().equals("string"));
    }

}
