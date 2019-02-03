package de.fhl.ultimaster.api.v1.printer.bed;

/** Temperature of the bed. */
public class Temperature {

    private Double target;
    private Double current;

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Temperature [target=" + target + ", current=" + current + "]";
    }

}
