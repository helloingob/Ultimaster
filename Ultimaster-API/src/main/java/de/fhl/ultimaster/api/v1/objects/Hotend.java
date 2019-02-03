package de.fhl.ultimaster.api.v1.objects;

import de.fhl.ultimaster.api.v1.objects.json.Offset;
import de.fhl.ultimaster.api.v1.printer.bed.Temperature;

public class Hotend {

    private String id;
    private String serial;
    private Temperature temperature;
    private Offset offset;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "Hotend [id=" + id + ", serial=" + serial + ", temperature=" + temperature + ", offset=" + offset + "]";
    }

}
