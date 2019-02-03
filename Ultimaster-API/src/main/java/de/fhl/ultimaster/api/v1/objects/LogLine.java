package de.fhl.ultimaster.api.v1.objects;

import java.time.LocalDateTime;

public class LogLine {

    private LocalDateTime date;
    private String process;
    private Integer pid;
    private String line;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "LogLine [date=" + date + ", process=" + process + ", pid=" + pid + ", line=" + line + "]";
    }

}
