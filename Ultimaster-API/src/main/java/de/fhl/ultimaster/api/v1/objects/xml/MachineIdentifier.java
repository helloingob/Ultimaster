package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlAttribute;

public class MachineIdentifier {
    
    private String manufacturer;
    private String product;

    public String getManufacturer() {
        return manufacturer;
    }

    @XmlAttribute
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduct() {
        return product;
    }

    @XmlAttribute
    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "MachineIdentifier [manufacturer=" + manufacturer + ", product=" + product + "]";
    }

}
