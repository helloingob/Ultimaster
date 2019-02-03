package de.fhl.ultimaster.api.v1.connection.printer.network.wifi_networks;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.network.wifi_networks.PrinterNetworkWifiNetworksGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterNetworkWifiNetworksGetTest {

    @Test
    public void testPrinterNetworkWifiNetworksGet() {
        Assert.assertNotNull(PrinterNetworkWifiNetworksGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
