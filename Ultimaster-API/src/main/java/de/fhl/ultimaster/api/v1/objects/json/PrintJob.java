package de.fhl.ultimaster.api.v1.objects.json;

import com.google.gson.annotations.SerializedName;
import de.fhl.ultimaster.api.v1.print_job.PrintJobStatus;

public class PrintJob {

    @SerializedName("time_elapsed")
    private Integer timeElapsed;
    @SerializedName("time_total")
    private Integer timeTotal;
    @SerializedName("datetime_started")
    private String datetimeStarted;
    @SerializedName("datetime_finished")
    private String datetimeFinished;
    @SerializedName("datetime_cleaned")
    private String datetimeCleaned;
    private String source;
    @SerializedName("source_user")
    private String sourceUser;
    @SerializedName("source_application")
    private String sourceApplication;
    private String name;
    private String progress;
    private String uuid;
    @SerializedName("reprint_original_uuid")
    private String reprintOriginalUuid;
    private PrintJobStatus state;

    public Integer getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Integer timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public Integer getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(Integer timeTotal) {
        this.timeTotal = timeTotal;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
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

    public String getReprintOriginalUuid() {
        return reprintOriginalUuid;
    }

    public void setReprintOriginalUuid(String reprintOriginalUuid) {
        this.reprintOriginalUuid = reprintOriginalUuid;
    }

    public PrintJobStatus getState() {
        return state;
    }

    public void setState(PrintJobStatus state) {
        this.state = state;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "PrintJob [timeElapsed=" + timeElapsed + ", timeTotal=" + timeTotal + ", datetimeStarted=" + datetimeStarted + ", datetimeFinished=" + datetimeFinished + ", datetimeCleaned=" + datetimeCleaned + ", source=" + source + ", sourceUser=" + sourceUser + ", sourceApplication=" + sourceApplication + ", name=" + name + ", progress=" + progress + ", uuid=" + uuid + ", reprintOriginalUuid=" + reprintOriginalUuid + ", state=" + state + "]";
    }

}
