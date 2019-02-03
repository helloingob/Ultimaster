package de.fhl.ultimaster.api.v1.connection.printer.bed.pre_heat;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.pre_heat.PrinterBedPreHeatGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterBedPreHeatGetTest {

    @Test
    public void testPrinterBedPreHeatGet() {
        Assert.assertNotNull(PrinterBedPreHeatGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
