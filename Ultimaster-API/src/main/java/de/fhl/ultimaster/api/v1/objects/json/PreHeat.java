package de.fhl.ultimaster.api.v1.objects.json;

/** Status of pre-heating the heated bed. */
public class PreHeat {

    private Boolean active;
    private Integer remaining;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "Status [active=" + active + ", remaining=" + remaining + "]";
    }

}
