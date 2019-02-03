package de.fhl.ultimaster.api.v1.connection.printer.diagnostics.cap_sensor_noise.loop_count;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.diagnostics.cap_sensor_noise.loop_count.PrinterDiagnosticsCapSensorNoiseLoopCountGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterDiagnosticsCapSensorNoiseLoopCountGetTest {

    @Test
    public void testPrinterDiagnosticsCapSensorNoiseLoopCountGet() {
        Assert.assertNotNull(PrinterDiagnosticsCapSensorNoiseLoopCountGet.get(TestPrinter.getInstance().getPrinter(), 100));
    }

}
