package de.fhl.ultimaster.api.v1.objects.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Machine {
    
    private List<MachineIdentifier> machineIdentifiers;
    private Setting setting;
    private List<Hotend> hotends;

    public List<MachineIdentifier> getMachineIdentifiers() {
        return machineIdentifiers;
    }

    @XmlElement(name = "machine_identifier")
    public void setMachineIdentifiers(List<MachineIdentifier> machineIdentifiers) {
        this.machineIdentifiers = machineIdentifiers;
    }

    public Setting getSetting() {
        return setting;
    }

    @XmlElement
    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public List<Hotend> getHotends() {
        return hotends;
    }

    @XmlElement(name = "hotend")
    public void setHotends(List<Hotend> hotends) {
        this.hotends = hotends;
    }

    @Override
    public String toString() {
        return "Machine [machineIdentifiers=" + machineIdentifiers + ", setting=" + setting + ", hotends=" + hotends + "]";
    }

}
