package de.fhl.ultimaster.api.v1.objects.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Printer {

    private List<Head> heads;
    private Bed bed;
    private Network network;
    private Led led;
    private String status;
    @SerializedName("validate_header")
    private ValidateHeader validateHeader;

    public List<Head> getHeads() {
        return heads;
    }

    public void setHeads(List<Head> heads) {
        this.heads = heads;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Led getLed() {
        return led;
    }

    public void setLed(Led led) {
        this.led = led;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ValidateHeader getValidateHeader() {
        return validateHeader;
    }

    public void setValidateHeader(ValidateHeader validateHeader) {
        this.validateHeader = validateHeader;
    }

    @Override
    public String toString() {
        return "Printer [heads=" + heads + ", bed=" + bed + ", network=" + network + ", led=" + led + ", status=" + status + ", validateHeader=" + validateHeader + "]";
    }

}
