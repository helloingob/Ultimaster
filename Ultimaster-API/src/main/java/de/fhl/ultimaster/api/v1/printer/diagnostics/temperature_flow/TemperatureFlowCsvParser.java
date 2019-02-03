package de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow;

public class TemperatureFlowCsvParser {

    public static TemperatureFlowData getTemperatureFlowDate(String input) {
        TemperatureFlowData temperatureFlowData = new TemperatureFlowData();
        String[] elements = input.split(";");
        temperatureFlowData.setTime(elements[0]);
        temperatureFlowData.setTemperature0(Double.parseDouble(elements[1]));
        temperatureFlowData.setTarget0(Double.parseDouble(elements[2]));
        temperatureFlowData.setHeater0(Double.parseDouble(elements[3]));
        temperatureFlowData.setFlowSensor0(Double.parseDouble(elements[4]));
        temperatureFlowData.setFlowSteps0(Double.parseDouble(elements[5]));
        temperatureFlowData.setTemperature1(Double.parseDouble(elements[6]));
        temperatureFlowData.setTarget1(Double.parseDouble(elements[7]));
        temperatureFlowData.setHeater1(Double.parseDouble(elements[8]));
        temperatureFlowData.setFlowSensor1(Double.parseDouble(elements[9]));
        temperatureFlowData.setFlowSteps1(Double.parseDouble(elements[10]));
        temperatureFlowData.setBedTemperature(Double.parseDouble(elements[11]));
        temperatureFlowData.setBedTarget(Double.parseDouble(elements[12]));
        temperatureFlowData.setBedHeater(Double.parseDouble(elements[13]));
        temperatureFlowData.setActiveHotendOrState(Double.parseDouble(elements[14]));
        return temperatureFlowData;
    }

}
