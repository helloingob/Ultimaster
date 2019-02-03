package de.fhl.ultimaster.api.v1.connection.printer.status;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.status.PrinterStatusGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterStatusGetTest {

    @Test
    public void testPrinterStatusGet() {
        Assert.assertNotNull(PrinterStatusGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
