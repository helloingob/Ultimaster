package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Setting {

    private String key;
    private Integer value;

    public String getKey() {
        return key;
    }

    @XmlAttribute
    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    @XmlValue
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Setting [key=" + key + ", value=" + value + "]";
    }

}
