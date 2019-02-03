package de.fhl.ultimaster.api.v1.objects;

import com.google.gson.annotations.SerializedName;

public class ActiveMaterial {

    @SerializedName("length_remaining")
    private Double lengthRemaining;
    @SerializedName("GUID")
    private String Guid;

    public Double getLengthRemaining() {
        return lengthRemaining;
    }

    public void setLengthRemaining(Double lengthRemaining) {
        this.lengthRemaining = lengthRemaining;
    }

    public String getGuid() {
        return Guid;
    }

    public void setGuid(String guid) {
        Guid = guid;
    }

    @Override
    public String toString() {
        return "ActiveMaterial [lengthRemaining=" + lengthRemaining + ", Guid=" + Guid + "]";
    }

}
