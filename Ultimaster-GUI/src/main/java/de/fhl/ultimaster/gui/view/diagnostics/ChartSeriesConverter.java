package de.fhl.ultimaster.gui.view.diagnostics;

import java.util.List;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowData;
import de.fhl.ultimaster.gui.utils.TimeHelper;

public class ChartSeriesConverter {

    public static String generateSeries(List<TemperatureFlowData> temperatureFlowDataList, double bootTimestamp) {
        String seriesTemperature0 = "{ name: 'Head1', data: [";
        String seriesTarget0 = "{ name: 'Head1 - Target', data: [";
        String seriesHeater0 = "{ name: 'Head1 - Heater', data: [";
        String seriesFlowSensor0 = "{ name: 'Head1 - FlowSensor', data: [";
        String seriesFlowSteps0 = "{ name: 'Head1 - FlowSteps', data: [";

        String seriesTemperature1 = "{ name: 'Head2', data: [";
        String seriesTarget1 = "{ name: 'Head2 - Target', data: [";
        String seriesHeater1 = "{ name: 'Head2 - Heater', data: [";
        String seriesFlowSensor1 = "{ name: 'Head2 - FlowSensor', data: [";
        String seriesFlowSteps1 = "{ name: 'Head2 - FlowSteps', data: [";

        String seriesBedTemperature = "{ name: 'Bed', data: [";
        String seriesBedTarget = "{ name: 'Bed - Target', data: [";
        String seriesBedHeater = "{ name: 'Bed - Heater', data: [";
        String seriesActiveHotendOrState = "{ name: 'Active Hotend', data: [";

        for (TemperatureFlowData temperatureFlowData : temperatureFlowDataList) {
            String timestampStr = TimeHelper.get(bootTimestamp, temperatureFlowData.getTime());
            seriesTemperature0 += "[" + timestampStr + ", " + temperatureFlowData.getTemperature0() + "], ";
            seriesTarget0 += "[" + timestampStr + ", " + temperatureFlowData.getTarget0() + "], ";
            seriesHeater0 += "[" + timestampStr + ", " + temperatureFlowData.getHeater0() + "], ";
            seriesFlowSensor0 += "[" + timestampStr + ", " + temperatureFlowData.getFlowSensor0() + "], ";
            seriesFlowSteps0 += "[" + timestampStr + ", " + temperatureFlowData.getFlowSteps0() + "], ";

            seriesTemperature1 += "[" + timestampStr + ", " + temperatureFlowData.getTemperature1() + "], ";
            seriesTarget1 += "[" + timestampStr + ", " + temperatureFlowData.getTarget1() + "], ";
            seriesHeater1 += "[" + timestampStr + ", " + temperatureFlowData.getHeater1() + "], ";
            seriesFlowSensor1 += "[" + timestampStr + ", " + temperatureFlowData.getFlowSensor1() + "], ";
            seriesFlowSteps1 += "[" + timestampStr + ", " + temperatureFlowData.getFlowSteps1() + "], ";

            seriesBedTemperature += "[" + timestampStr + ", " + temperatureFlowData.getBedTemperature() + "], ";
            seriesBedTarget += "[" + timestampStr + ", " + temperatureFlowData.getBedTarget() + "], ";
            seriesBedHeater += "[" + timestampStr + ", " + temperatureFlowData.getBedHeater() + "], ";
            seriesActiveHotendOrState += "[" + timestampStr + ", " + temperatureFlowData.getActiveHotendOrState() + "], ";
        }
        seriesTemperature0 = finishSeries(seriesTemperature0);
        seriesTarget0 = finishSeries(seriesTarget0);
        seriesHeater0 = finishSeries(seriesHeater0);
        seriesFlowSensor0 = finishSeries(seriesFlowSensor0);
        seriesFlowSteps0 = finishSeries(seriesFlowSteps0);

        seriesTemperature1 = finishSeries(seriesTemperature1);
        seriesTarget1 = finishSeries(seriesTarget1);
        seriesHeater1 = finishSeries(seriesHeater1);
        seriesFlowSensor1 = finishSeries(seriesFlowSensor1);
        seriesFlowSteps1 = finishSeries(seriesFlowSteps1);

        seriesBedTemperature = finishSeries(seriesBedTemperature);
        seriesBedTarget = finishSeries(seriesBedTarget);
        seriesBedHeater = finishSeries(seriesBedHeater);
        seriesActiveHotendOrState = finishSeries(seriesActiveHotendOrState);

        // @formatter:off
        return seriesTemperature0 + ", " +
//               seriesTarget0 + ", " +
//               seriesHeater0 + ", " +
//               seriesFlowSensor0 + ", " +
//               seriesFlowSteps0 + ", " +
               
               seriesTemperature1 + ", " +
//               seriesTarget1 + ", " +
//               seriesHeater1 + ", " +
//               seriesFlowSensor1 + ", " +
//               seriesFlowSteps1 + ", " +
               
               seriesBedTemperature;
//               seriesBedTarget + ", " +
//               seriesBedHeater + ", " +
//               seriesActiveHotendOrState;
        // @formatter:on
    }

    private static String finishSeries(String input) {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 2) + "] }";
        }
        return input;
    }

}
