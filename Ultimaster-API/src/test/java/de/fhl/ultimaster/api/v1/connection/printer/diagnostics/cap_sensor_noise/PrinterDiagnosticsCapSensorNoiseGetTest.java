package de.fhl.ultimaster.api.v1.connection.printer.diagnostics.cap_sensor_noise;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.diagnostics.cap_sensor_noise.PrinterDiagnosticsCapSensorNoiseGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterDiagnosticsCapSensorNoiseGetTest {

    @Test
    public void testPrinterDiagnosticsCapSensorNoiseGetTest() {
        Assert.assertNotNull(PrinterDiagnosticsCapSensorNoiseGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
