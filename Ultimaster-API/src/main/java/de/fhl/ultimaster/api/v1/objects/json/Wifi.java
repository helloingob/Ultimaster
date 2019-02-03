package de.fhl.ultimaster.api.v1.objects.json;

public class Wifi {

    private boolean connected;
    private boolean enabled;
    private String mode;
    private String ssid;

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    @Override
    public String toString() {
        return "Wifi [connected=" + connected + ", enabled=" + enabled + ", mode=" + mode + ", ssid=" + ssid + "]";
    }

}
