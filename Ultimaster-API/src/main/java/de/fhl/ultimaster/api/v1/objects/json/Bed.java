package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;

import de.fhl.ultimaster.api.v1.printer.bed.Temperature;

public class Bed {

    @SerializedName("pre_heat")
    private PreHeat preHeat;
    private Temperature temperature;

    public PreHeat getPreHeat() {
        return preHeat;
    }

    public void setPreHeat(PreHeat preHeat) {
        this.preHeat = preHeat;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Bed [preHeat=" + preHeat + ", temperature=" + temperature + "]";
    }

}
