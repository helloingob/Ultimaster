package de.fhl.ultimaster.api.v1.objects.json;

public class Ethernet {

    private Boolean connected;
    private Boolean enabled;

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

    @Override
    public String toString() {
        return "Ethernet [connected=" + connected + ", enabled=" + enabled + "]";
    }

}
