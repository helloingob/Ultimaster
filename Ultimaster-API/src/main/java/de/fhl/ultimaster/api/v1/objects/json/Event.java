package de.fhl.ultimaster.api.v1.objects.json;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Event {

    private String time;
    @SerializedName("type_id")
    private Integer typeId;
    private String message;
    private List<String> parameters;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Event [time=" + time + ", typeId=" + typeId + ", message=" + message + ", parameters=" + parameters + ", getTime()=" + getTime() + ", getTypeId()=" + getTypeId() + ", getMessage()=" + getMessage() + ", getParameters()=" + getParameters() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
