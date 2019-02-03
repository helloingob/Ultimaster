package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;

public class ValidateHeader {

    @SerializedName("fault_code")
    private String faultCode;
    @SerializedName("fault_level")
    private String faultLevel;
    private String message;
    private String data;

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultLevel() {
        return faultLevel;
    }

    public void setFaultLevel(String faultLevel) {
        this.faultLevel = faultLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ValidateHeader [faultCode=" + faultCode + ", faultLevel=" + faultLevel + ", message=" + message + ", data=" + data + "]";
    }

}
