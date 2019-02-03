package de.fhl.ultimaster.api.v1.objects;

public class Feeder {

    private Integer position;
    private Integer max_speed;
    private Integer jerk;
    private Integer acceleration;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(Integer max_speed) {
        this.max_speed = max_speed;
    }

    public Integer getJerk() {
        return jerk;
    }

    public void setJerk(Integer jerk) {
        this.jerk = jerk;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public String toString() {
        return "Feeder [position=" + position + ", max_speed=" + max_speed + ", jerk=" + jerk + ", acceleration=" + acceleration + "]";
    }

}
