package de.fhl.ultimaster.api.v1.objects.json;

public class Memory {

    private Integer total;
    private Integer used;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Memory [total=" + total + ", used=" + used + "]";
    }

}
