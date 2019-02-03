package de.fhl.ultimaster.api.v1.objects.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Network {

    private Ethernet ethernet;
    private Wifi wifi;
    @SerializedName("wifi_networks")
    private List<WifiNetwork> wifiNetworks;

    public Ethernet getEthernet() {
        return ethernet;
    }

    public void setEthernet(Ethernet ethernet) {
        this.ethernet = ethernet;
    }

    public Wifi getWifi() {
        return wifi;
    }

    public void setWifi(Wifi wifi) {
        this.wifi = wifi;
    }

    public List<WifiNetwork> getWifiNetworks() {
        return wifiNetworks;
    }

    public void setWifiNetworks(List<WifiNetwork> wifiNetworks) {
        this.wifiNetworks = wifiNetworks;
    }

    @Override
    public String toString() {
        return "Network [ethernet=" + ethernet + ", wifi=" + wifi + ", wifiNetworks=" + wifiNetworks + "]";
    }

}
