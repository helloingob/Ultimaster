package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;

public class WifiNetwork {

    @SerializedName("SSID")
    private String ssid;
    private Boolean connected;
    @SerializedName("security_required")
    private Boolean securityRequired;
    private Integer strength;

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Boolean getSecurityRequired() {
        return securityRequired;
    }

    public void setSecurityRequired(Boolean securityRequired) {
        this.securityRequired = securityRequired;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "WifiNetwork [ssid=" + ssid + ", connected=" + connected + ", securityRequired=" + securityRequired + ", strength=" + strength + "]";
    }

}
