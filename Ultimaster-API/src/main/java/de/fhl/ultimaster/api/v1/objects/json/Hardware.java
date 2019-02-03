package de.fhl.ultimaster.api.v1.objects.json;

public class Hardware {

    private Integer typeid;
    private Integer revision;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @Override
    public String toString() {
        return "Hardware [typeid=" + typeid + ", revision=" + revision + "]";
    }

}
