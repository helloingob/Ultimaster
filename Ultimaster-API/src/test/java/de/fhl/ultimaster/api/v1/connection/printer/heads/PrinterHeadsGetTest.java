package de.fhl.ultimaster.api.v1.connection.printer.heads;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.heads.PrinterHeadsGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterHeadsGetTest {

    @Test
    public void testPrinterHeadsGet() {
        Assert.assertNotNull(PrinterHeadsGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
