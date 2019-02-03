package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;

public class PrintJobHistoric {

    @SerializedName("time_elapsed")
    private Integer timeElapsed;
    @SerializedName("datetime_started")
    private String datetimeStarted;
    @SerializedName("datetime_finished")
    private String datetimeFinished;
    @SerializedName("datetime_cleaned")
    private String datetimeCleaned;
    private String result;
    private String source;
    @SerializedName("reprint_original_uuid")
    private String reprintOriginalUuid;
    private String name;
    private String uuid;

    public Integer getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Integer timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public String getDatetimeStarted() {
        return datetimeStarted;
    }

    public void setDatetimeStarted(String datetimeStarted) {
        this.datetimeStarted = datetimeStarted;
    }

    public String getDatetimeFinished() {
        return datetimeFinished;
    }

    public void setDatetimeFinished(String datetimeFinished) {
        this.datetimeFinished = datetimeFinished;
    }

    public String getDatetimeCleaned() {
        return datetimeCleaned;
    }

    public void setDatetimeCleaned(String datetimeCleaned) {
        this.datetimeCleaned = datetimeCleaned;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReprintOriginalUuid() {
        return reprintOriginalUuid;
    }

    public void setReprintOriginalUuid(String reprintOriginalUuid) {
        this.reprintOriginalUuid = reprintOriginalUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "PrintJobHistoric [timeElapsed=" + timeElapsed + ", datetimeStarted=" + datetimeStarted + ", datetimeFinished=" + datetimeFinished + ", datetimeCleaned=" + datetimeCleaned + ", result=" + result + ", source=" + source + ", reprintOriginalUuid=" + reprintOriginalUuid + ", name=" + name + ", uuid=" + uuid + "]";
    }

}
