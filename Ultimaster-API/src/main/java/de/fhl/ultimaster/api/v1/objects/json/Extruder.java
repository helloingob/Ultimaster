package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;
import de.fhl.ultimaster.api.v1.objects.ActiveMaterial;
import de.fhl.ultimaster.api.v1.objects.Feeder;

public class Extruder {

    private Hotend hotend;
    private Feeder feeder;
    @SerializedName("active_material")
    private ActiveMaterial activeMaterial;

    public Hotend getHotend() {
        return hotend;
    }

    public void setHotend(Hotend hotend) {
        this.hotend = hotend;
    }

    public Feeder getFeeder() {
        return feeder;
    }

    public void setFeeder(Feeder feeder) {
        this.feeder = feeder;
    }

    public ActiveMaterial getActiveMaterial() {
        return activeMaterial;
    }

    public void setActiveMaterial(ActiveMaterial activeMaterial) {
        this.activeMaterial = activeMaterial;
    }

    @Override
    public String toString() {
        return "Extruder [hotend=" + hotend + ", feeder=" + feeder + ", activeMaterial=" + activeMaterial + "]";
    }

}
