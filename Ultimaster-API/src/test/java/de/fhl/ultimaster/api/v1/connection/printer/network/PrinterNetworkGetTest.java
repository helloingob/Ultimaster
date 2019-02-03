package de.fhl.ultimaster.api.v1.connection.printer.network;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.network.PrinterNetworkGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterNetworkGetTest {

    @Test
    public void testPrinterNetworkGet() {
        Assert.assertNotNull(PrinterNetworkGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
