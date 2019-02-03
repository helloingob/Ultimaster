package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;

public class MessageData {

    private String message;
    @SerializedName("button_caption")
    private String buttonCaption;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getButtonCaption() {
        return buttonCaption;
    }

    public void setButtonCaption(String buttonCaption) {
        this.buttonCaption = buttonCaption;
    }

    @Override
    public String toString() {
        return "MessageData [message=" + message + ", buttonCaption=" + buttonCaption + ", getMessage()=" + getMessage() + ", getButtonCaption()=" + getButtonCaption() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
