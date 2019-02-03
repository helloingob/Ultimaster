package de.fhl.ultimaster.api.v1.connection.printer.bed;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.bed.PrinterBedGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterBedGetTest {

    @Test
    public void testPrinterBedGet() {
        Assert.assertNotNull(PrinterBedGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
