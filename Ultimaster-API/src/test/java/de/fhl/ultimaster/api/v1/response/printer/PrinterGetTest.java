package de.fhl.ultimaster.api.v1.response.printer;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Printer;
import de.fhl.ultimaster.api.v1.printer.PrinterGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterGetTest {

    @Test
    @Ignore
    //API differs from live printer!
    public void testPrinterGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/PrinterGet.json");
        Printer printer = PrinterGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(printer.getHeads().get(0).getPosition().getX() == 0);
        Assert.assertTrue(printer.getHeads().get(0).getMaxSpeed().getY() == 0);
        Assert.assertTrue(printer.getHeads().get(0).getJerk().getZ() == 0);

        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getHotend().getTemperature().getCurrent() == 0);
        Assert.assertEquals(printer.getHeads().get(0).getExtruders().get(0).getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getHotend().getStatistics().getMaterialExtruded() == 0);

        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getFeeder().getAcceleration() == 0);
        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getActiveMaterial().getLengthRemaining() == 0);

        //Assert.assertEquals(printer.getCamera().getFeed(), "string");

        Assert.assertTrue(printer.getBed().getTemperature().getTarget() == 0);

        Assert.assertEquals(printer.getNetwork(), "wifi");

        Assert.assertTrue(printer.getLed().getHue() == 0);

        Assert.assertEquals(printer.getStatus(), "booting");
    }

    @Test
    public void testPrinterGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/PrinterGetLive.json");
        Printer printer = PrinterGetResponseParser.parse(mockedHttpResponse);

        Assert.assertTrue(printer.getHeads().get(0).getPosition().getX() == 0);
        Assert.assertTrue(printer.getHeads().get(0).getMaxSpeed().getY() == 300.0);
        Assert.assertTrue(printer.getHeads().get(0).getJerk().getZ() == 0.4);

        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getHotend().getTemperature().getCurrent() == 26.2);
        Assert.assertEquals(printer.getHeads().get(0).getExtruders().get(0).getHotend().getOffset().getState(), "valid");
        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getHotend().getStatistics().getMaterialExtruded() == 3120);

        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getFeeder().getAcceleration() == 3000.0);
        Assert.assertTrue(printer.getHeads().get(0).getExtruders().get(0).getActiveMaterial().getLengthRemaining() == -1.0);

        Assert.assertTrue(printer.getBed().getTemperature().getTarget() == 0);

        Assert.assertFalse(printer.getNetwork().getEthernet().isConnected());
        Assert.assertTrue(printer.getNetwork().getWifi().isConnected());

        Assert.assertTrue(printer.getLed().getHue() == 0);

        Assert.assertEquals(printer.getNetwork().getWifiNetworks().get(0).getSsid(), "FHL-Wlan");

        Assert.assertEquals(printer.getStatus(), "maintenance");

        Assert.assertNull(printer.getValidateHeader().getData());
    }

}
