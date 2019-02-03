package de.fhl.ultimaster.api.v1.objects.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Hotend {

    private String id;
    private List<HotendSetting> hotendSetting;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public List<HotendSetting> getHotendSetting() {
        return hotendSetting;
    }

    @XmlElement(name = "setting")
    public void setHotendSetting(List<HotendSetting> hotendSetting) {
        this.hotendSetting = hotendSetting;
    }

    @Override
    public String toString() {
        return "Hotend [id=" + id + ", hotendSetting=" + hotendSetting + "]";
    }

}
