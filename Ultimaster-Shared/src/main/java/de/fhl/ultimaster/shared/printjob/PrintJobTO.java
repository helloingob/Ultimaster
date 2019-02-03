package de.fhl.ultimaster.shared.printjob;

import java.util.Arrays;
import de.fhl.ultimaster.shared.user.UserTO;

public class PrintJobTO {

    private Integer id;
    private Integer order;
    private boolean active;
    private String name;
    private String filename;
    private byte[] bytes;
    private UserTO user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public UserTO getUser() {
        return user;
    }

    public void setUser(UserTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PrintJobTO [id=" + id + ", order=" + order + ", active=" + active + ", name=" + name + ", filename=" + filename + ", bytes=" + Arrays.toString(bytes) + ", user=" + user + "]";
    }

}
