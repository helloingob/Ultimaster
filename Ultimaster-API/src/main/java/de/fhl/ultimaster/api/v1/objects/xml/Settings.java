package de.fhl.ultimaster.api.v1.objects.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Settings {
    
    private List<Setting> settings;
    private List<Machine> machines;

    public List<Setting> getSettings() {
        return settings;
    }

    @XmlElement(name = "setting")
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    @XmlElement(name = "machine")
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    @Override
    public String toString() {
        return "Settings [settings=" + settings + ", machines=" + machines + "]";
    }

}
