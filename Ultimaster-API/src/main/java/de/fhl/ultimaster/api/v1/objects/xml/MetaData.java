package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadata")
public class MetaData {
    
    private String adhesionInfo;
    private String guid;
    private String description;
    private Name name;
    private String colorCode;
    private String version;

    public String getAdhesionInfo() {
        return adhesionInfo;
    }

    @XmlElement(name = "adhesion_info")
    public void setAdhesionInfo(String adhesionInfo) {
        this.adhesionInfo = adhesionInfo;
    }

    public String getGuid() {
        return guid;
    }

    @XmlElement(name = "GUID")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public Name getName() {
        return name;
    }

    @XmlElement
    public void setName(Name name) {
        this.name = name;
    }

    public String getColorCode() {
        return colorCode;
    }

    @XmlElement(name = "color_code")
    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getVersion() {
        return version;
    }

    @XmlElement
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Metadata [adhesionInfo=" + adhesionInfo + ", guid=" + guid + ", description=" + description + ", name=" + name + ", colorCode=" + colorCode + ", version=" + version + "]";
    }

}