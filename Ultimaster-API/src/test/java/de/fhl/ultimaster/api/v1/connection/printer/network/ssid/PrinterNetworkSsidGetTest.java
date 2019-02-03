package de.fhl.ultimaster.api.v1.connection.printer.network.ssid;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.network.ssid.PrinterNetworkSsidGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterNetworkSsidGetTest {

    @Test
    public void testPrinterNetworkSsidGet() {
        Assert.assertNotNull(PrinterNetworkSsidGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
