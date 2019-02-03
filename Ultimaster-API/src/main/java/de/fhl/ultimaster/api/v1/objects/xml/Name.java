package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Name {
    
    private String color;
    private String brand;
    private String material;

    public String getColor() {
        return color;
    }

    @XmlElement
    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    @XmlElement
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    @XmlElement
    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Name [color=" + color + ", brand=" + brand + ", material=" + material + "]";
    }

}
