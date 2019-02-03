package de.fhl.ultimaster.api.v1.objects.json;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Head {

    private Position position;
    @SerializedName("max_speed")
    private MaxSpeed maxSpeed;
    private Double acceleration;
    private Jerk jerk;
    private List<Extruder> extruders;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public MaxSpeed getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(MaxSpeed maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public Jerk getJerk() {
        return jerk;
    }

    public void setJerk(Jerk jerk) {
        this.jerk = jerk;
    }

    public List<Extruder> getExtruders() {
        return extruders;
    }

    public void setExtruders(List<Extruder> extruders) {
        this.extruders = extruders;
    }

    @Override
    public String toString() {
        return "Head [position=" + position + ", maxSpeed=" + maxSpeed + ", acceleration=" + acceleration + ", jerk=" + jerk + ", extruders=" + extruders + "]";
    }

}
