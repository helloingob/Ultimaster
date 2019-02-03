package de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow;

public class TemperatureFlowData {

    private String time;
    //Head0
    private Double temperature0;
    private Double target0;
    private Double heater0;
    private Double flowSensor0;
    private Double flowSteps0;
    //Head1    
    private Double temperature1;
    private Double target1;
    private Double heater1;
    private Double flowSensor1;
    private Double flowSteps1;
    //Bed
    private Double bedTemperature;
    private Double bedTarget;
    private Double bedHeater;
    private Double activeHotendOrState;
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemperature0() {
        return temperature0;
    }

    public void setTemperature0(Double temperature0) {
        this.temperature0 = temperature0;
    }

    public Double getTarget0() {
        return target0;
    }

    public void setTarget0(Double target0) {
        this.target0 = target0;
    }

    public Double getHeater0() {
        return heater0;
    }

    public void setHeater0(Double heater0) {
        this.heater0 = heater0;
    }

    public Double getFlowSensor0() {
        return flowSensor0;
    }

    public void setFlowSensor0(Double flowSensor0) {
        this.flowSensor0 = flowSensor0;
    }

    public Double getFlowSteps0() {
        return flowSteps0;
    }

    public void setFlowSteps0(Double flowSteps0) {
        this.flowSteps0 = flowSteps0;
    }

    public Double getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(Double temperature1) {
        this.temperature1 = temperature1;
    }

    public Double getTarget1() {
        return target1;
    }

    public void setTarget1(Double target1) {
        this.target1 = target1;
    }

    public Double getHeater1() {
        return heater1;
    }

    public void setHeater1(Double heater1) {
        this.heater1 = heater1;
    }

    public Double getFlowSensor1() {
        return flowSensor1;
    }

    public void setFlowSensor1(Double flowSensor1) {
        this.flowSensor1 = flowSensor1;
    }

    public Double getFlowSteps1() {
        return flowSteps1;
    }

    public void setFlowSteps1(Double flowSteps1) {
        this.flowSteps1 = flowSteps1;
    }

    public Double getBedTemperature() {
        return bedTemperature;
    }

    public void setBedTemperature(Double bedTemperature) {
        this.bedTemperature = bedTemperature;
    }

    public Double getBedTarget() {
        return bedTarget;
    }

    public void setBedTarget(Double bedTarget) {
        this.bedTarget = bedTarget;
    }

    public Double getBedHeater() {
        return bedHeater;
    }

    public void setBedHeater(Double bedHeater) {
        this.bedHeater = bedHeater;
    }

    public Double getActiveHotendOrState() {
        return activeHotendOrState;
    }

    public void setActiveHotendOrState(Double activeHotendOrState) {
        this.activeHotendOrState = activeHotendOrState;
    }

    @Override
    public String toString() {
        return "TemperatureFlowData [time=" + time + ", temperature0=" + temperature0 + ", target0=" + target0 + ", heater0=" + heater0 + ", flowSensor0=" + flowSensor0 + ", flowSteps0=" + flowSteps0 + ", temperature1=" + temperature1 + ", target1=" + target1 + ", heater1=" + heater1 + ", flowSensor1=" + flowSensor1 + ", flowSteps1=" + flowSteps1 + ", bedTemperature=" + bedTemperature + ", bedTarget=" + bedTarget + ", bedHeater=" + bedHeater + ", activeHotendOrState=" + activeHotendOrState + "]";
    }

}
