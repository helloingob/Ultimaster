package de.fhl.ultimaster.api.v1.objects.json;

/** The frequency and count of the blink. */
public class Blink {

    private Integer frequency;
    private Integer count;

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Blink [frequency=" + frequency + ", count=" + count + "]";
    }

}
