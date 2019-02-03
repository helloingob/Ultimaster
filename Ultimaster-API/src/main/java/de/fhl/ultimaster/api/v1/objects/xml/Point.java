package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlAttribute;

public class Point {

    private Integer flow;
    private Integer temperature;

    public Integer getFlow() {
        return flow;
    }

    @XmlAttribute
    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    public Integer getTemperature() {
        return temperature;
    }

    @XmlAttribute
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Point [flow=" + flow + ", temperature=" + temperature + "]";
    }

}
