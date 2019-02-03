package de.fhl.ultimaster.api.v1.objects.json;

/** Note that this speed also has a Z component. This api assumes that the head is the only part that moves.*/
public class Jerk {

    private Double x;
    private Double y;
    private Double z;

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

    @Override
    public String toString() {
        return "Jerk [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

}
