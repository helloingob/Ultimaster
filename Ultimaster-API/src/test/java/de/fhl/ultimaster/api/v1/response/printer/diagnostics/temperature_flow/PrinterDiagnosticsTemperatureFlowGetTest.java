package de.fhl.ultimaster.api.v1.response.printer.diagnostics.temperature_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.PrinterDiagnosticsTemperatureFlowGetResponseParser;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowCsvParser;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowData;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;
import de.fhl.ultimaster.utils.Settings;

public class PrinterDiagnosticsTemperatureFlowGetTest {

    @Test
    public void testPrinterDiagnosticsTemperatureFlowGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/diagnostics/temperature_flow/TemperatureFlow.csv", Settings.Connection.CONTENT_TYPE_CSV, HttpStatus.SC_OK);
        String csv = PrinterDiagnosticsTemperatureFlowGetResponseParser.parse(mockedHttpResponse);
        List<String> lines = Arrays.asList(csv.split("\n"));
        List<TemperatureFlowData> temperatureFlowDataList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            temperatureFlowDataList.add(TemperatureFlowCsvParser.getTemperatureFlowDate(line));
        }
        Assert.assertTrue(temperatureFlowDataList.size() == 50);
    }

}
