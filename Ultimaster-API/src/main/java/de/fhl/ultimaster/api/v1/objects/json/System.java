package de.fhl.ultimaster.api.v1.objects.json;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class System {

    private String name;
    private String platform;
    private String hostname;
    private Long uptime;
    private String type;
    private String variant;
    private Memory memory;
    private Hardware hardware;
    @SerializedName("log")
    private List<String> logLines;
    private String firmware;
    private String guid;
    private String country;
    private String language;
    private Time time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Long getUptime() {
        return uptime;
    }

    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public List<String> getLogLines() {
        return logLines;
    }

    public void setLogLines(List<String> logLines) {
        this.logLines = logLines;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "System [name=" + name + ", platform=" + platform + ", hostname=" + hostname + ", uptime=" + uptime + ", type=" + type + ", variant=" + variant + ", memory=" + memory + ", hardware=" + hardware + ", logLines=" + logLines + ", firmware=" + firmware + ", guid=" + guid + ", country=" + country + ", language=" + language + ", time=" + time + "]";
    }

}
