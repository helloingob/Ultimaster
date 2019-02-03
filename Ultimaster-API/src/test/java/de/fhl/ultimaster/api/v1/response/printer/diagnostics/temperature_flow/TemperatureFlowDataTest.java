package de.fhl.ultimaster.api.v1.response.printer.diagnostics.temperature_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowCsvParser;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowData;
import de.fhl.ultimaster.api.v1.utils.FileLibrary;

public class TemperatureFlowDataTest {

    @Test
    public void testTemperatureFlowDataColumns() {
        String csv = FileLibrary.getFileContent("de/fhl/ultimaster/api/v1/response/printer/diagnostics/temperature_flow/TemperatureFlow.csv");
        Assert.assertEquals(csv.substring(0, csv.indexOf("\n") - 1), "# Time;temperature0;target0;heater0;flow_sensor0;flow_steps0;temperature1;target1;heater1;flow_sensor1;flow_steps1;bed_temperature;bed_target;bed_heater;active_hotend_or_state");
    }

    @Test
    public void testTemperatureFlowDataCsvMapping() {
        String csv = FileLibrary.getFileContent("de/fhl/ultimaster/api/v1/response/printer/diagnostics/temperature_flow/TemperatureFlow.csv");
        List<String> lines = Arrays.asList(csv.split("\n"));
        List<TemperatureFlowData> temperatureFlowDataList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            temperatureFlowDataList.add(TemperatureFlowCsvParser.getTemperatureFlowDate(line));
        }
        Assert.assertTrue(temperatureFlowDataList.size() == 50);
    }

}
