package de.fhl.ultimaster.api.v1.objects.json;

public class Offset {

    private Double x;
    private Double y;
    private Double z;
    private String state;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Offset [x=" + x + ", y=" + y + ", z=" + z + ", state=" + state + "]";
    }

}
