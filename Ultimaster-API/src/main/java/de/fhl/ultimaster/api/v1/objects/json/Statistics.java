package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;

public class Statistics {

    @SerializedName("last_material_guid")
    private String lastMaterialGuid;
    @SerializedName("material_extruded")
    private Integer materialExtruded;
    @SerializedName("max_temperature_exposed")
    private Integer maxTemperatureExposed;
    @SerializedName("time_spent_hot")
    private Integer timeSpentHot;

    public String getLastMaterialGuid() {
        return lastMaterialGuid;
    }

    public void setLastMaterialGuid(String lastMaterialGuid) {
        this.lastMaterialGuid = lastMaterialGuid;
    }

    public Integer getMaterialExtruded() {
        return materialExtruded;
    }

    public void setMaterialExtruded(Integer materialExtruded) {
        this.materialExtruded = materialExtruded;
    }

    public Integer getMaxTemperatureExposed() {
        return maxTemperatureExposed;
    }

    public void setMaxTemperatureExposed(Integer maxTemperatureExposed) {
        this.maxTemperatureExposed = maxTemperatureExposed;
    }

    public Integer getTimeSpentHot() {
        return timeSpentHot;
    }

    public void setTimeSpentHot(Integer timeSpentHot) {
        this.timeSpentHot = timeSpentHot;
    }

    @Override
    public String toString() {
        return "Statistics [lastMaterialGuid=" + lastMaterialGuid + ", materialExtruded=" + materialExtruded + ", maxTemperatureExposed=" + maxTemperatureExposed + ", timeSpentHot=" + timeSpentHot + "]";
    }

}
