package de.fhl.ultimaster.api.v1.objects.json;

public class PrintJobAccepted {

    private String message;
    private String uuid;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "PrintJob [message=" + message + ", uuid=" + uuid + "]";
    }

}
