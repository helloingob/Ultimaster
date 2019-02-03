package de.fhl.ultimaster.api.v1.connection.printer.diagnostics.temperature_flow;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.PrinterDiagnosticsTemperatureFlowGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrinterDiagnosticsTemperatureFlowGetTest {

    @Test
    public void testPrinterDiagnosticsTemperatureFlowGet() {
        Assert.assertNotNull(PrinterDiagnosticsTemperatureFlowGet.get(TestPrinter.getInstance().getPrinter(), 50));
    }

    @Test
    public void testPrinterDiagnosticsTemperatureFlowGetCsv() {
        Assert.assertNotNull(PrinterDiagnosticsTemperatureFlowGet.getCSV(TestPrinter.getInstance().getPrinter(), 50));
    }

}
