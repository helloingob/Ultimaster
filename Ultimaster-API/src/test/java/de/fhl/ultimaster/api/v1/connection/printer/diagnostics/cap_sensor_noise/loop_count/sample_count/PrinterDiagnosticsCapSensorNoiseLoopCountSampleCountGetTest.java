package de.fhl.ultimaster.api.v1.connection.printer.diagnostics.cap_sensor_noise.loop_count.sample_count;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.diagnostics.cap_sensor_noise.loop_count.sample_count.PrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGetTest {

    @Test
    public void testPrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGet() {
        Assert.assertNotNull(PrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGet.get(TestPrinter.getInstance().getPrinter(), 100, 50));
    }

}
