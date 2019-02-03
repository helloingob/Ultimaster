package de.fhl.ultimaster.api.v1.connection.printer.bed.temperature;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.temperature.PrinterBedTemperatureGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterBedTemperatureGetTest {

    @Test
    public void testPrinterBedTemperatureGet() {
        Assert.assertNotNull(PrinterBedTemperatureGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
