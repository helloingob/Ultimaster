package de.fhl.ultimaster.api.v1.connection.printer.led;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.led.PrinterLedGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterLedGetTest {

    @Test
    public void testPrinterLedGet() {
        Assert.assertNotNull(PrinterLedGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
