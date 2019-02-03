package de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.offset;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Offset;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend.offset.PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetTest {

    @Test
    public void testPrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/heads/head_id/extruders/extruder_id/hotend/offset/PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGet.json");
        Offset offset = PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(offset.getX() == 0);
        Assert.assertTrue(offset.getY() == 0);
        Assert.assertTrue(offset.getZ() == 0);
        Assert.assertTrue(offset.getState().equals("valid"));
    }

}
