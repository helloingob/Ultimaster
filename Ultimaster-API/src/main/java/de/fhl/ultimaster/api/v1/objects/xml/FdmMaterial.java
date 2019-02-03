package de.fhl.ultimaster.api.v1.objects.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fdmmaterial")
public class FdmMaterial {
    
    private String version;
    private MetaData metaData;
    private Properties properties;
    private Settings settings;

    public String getVersion() {
        return version;
    }

    @XmlAttribute
    public void setVersion(String version) {
        this.version = version;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    @XmlElement(name = "metadata")
    public void setMetadData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Properties getProperties() {
        return properties;
    }

    @XmlElement
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Settings getSettings() {
        return settings;
    }

    @XmlElement
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "FdmMaterial [version=" + version + ", metaData=" + metaData + ", properties=" + properties + ", settings=" + settings + "]";
    }

}