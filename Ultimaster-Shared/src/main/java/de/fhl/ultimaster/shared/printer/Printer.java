package de.fhl.ultimaster.shared.printer;

public class Printer {

    private Integer id;
    private String host;
    private String printerId;
    private String printerKey;
    private boolean queueActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPrinterId() {
        return printerId;
    }

    public void setPrinterId(String printerId) {
        this.printerId = printerId;
    }

    public String getPrinterKey() {
        return printerKey;
    }

    public void setPrinterKey(String printerKey) {
        this.printerKey = printerKey;
    }

    public String getUrl() {
        return "http://" + host + "/api/v1";
    }

    public boolean isQueueActive() {
        return queueActive;
    }

    public void setQueueActive(boolean queueActive) {
        this.queueActive = queueActive;
    }

    @Override
    public String toString() {
        return "Printer [id=" + id + ", host=" + host + ", printerId=" + printerId + ", printerKey=" + printerKey + ", queueActive=" + queueActive + "]";
    }

}
