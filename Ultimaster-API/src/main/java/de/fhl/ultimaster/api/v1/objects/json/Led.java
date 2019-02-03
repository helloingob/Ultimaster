package de.fhl.ultimaster.api.v1.objects.json;

/** HSV the case lighting. */
public class Led {

    private Blink blink;
    private Double hue;
    private Double saturation;
    private Double brightness;

    public Blink getBlink() {
        return blink;
    }

    public void setBlink(Blink blink) {
        this.blink = blink;
    }

    public Double getHue() {
        return hue;
    }

    public void setHue(Double hue) {
        this.hue = hue;
    }

    public Double getSaturation() {
        return saturation;
    }

    public void setSaturation(Double saturation) {
        this.saturation = saturation;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "Led [blink=" + blink + ", hue=" + hue + ", saturation=" + saturation + ", brightness=" + brightness + "]";
    }

}
