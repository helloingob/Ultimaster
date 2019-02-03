package de.fhl.ultimaster.api.v1.connection.printer;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.PrinterGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterGetTest {

    @Test
    public void testPrinterGetTest() {
        Assert.assertNotNull(PrinterGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
