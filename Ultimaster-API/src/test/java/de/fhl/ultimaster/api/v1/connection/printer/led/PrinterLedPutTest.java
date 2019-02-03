package de.fhl.ultimaster.api.v1.connection.printer.led;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.Led;
import de.fhl.ultimaster.api.v1.printer.led.PrinterLedPut;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterLedPutTest {

    @Test
    public void testPrinterLedPutGreen() {
        Led led = new Led();
        led.setHue(120.0);
        led.setSaturation(100.0);
        led.setBrightness(50.0);
        Assert.assertTrue(PrinterLedPut.put(TestPrinter.getInstance().getPrinter(), led));
    }

    @Test
    @Ignore
    public void testPrinterLedPutRed() {
        Led color = new Led();
        color.setHue(1.0);
        color.setSaturation(100.0);
        color.setBrightness(50.0);
        Assert.assertTrue(PrinterLedPut.put(TestPrinter.getInstance().getPrinter(), color));
    }

}
