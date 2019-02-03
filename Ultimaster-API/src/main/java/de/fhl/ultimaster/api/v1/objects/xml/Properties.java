package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Properties {
    
    private Double diameter;
    private Double density;

    public Double getDiameter() {
        return diameter;
    }

    @XmlElement
    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getDensity() {
        return density;
    }

    @XmlElement
    public void setDensity(Double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "Properties [diameter=" + diameter + ", density=" + density + "]";
    }

}
