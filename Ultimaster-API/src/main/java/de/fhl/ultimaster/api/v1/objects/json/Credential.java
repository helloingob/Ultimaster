package de.fhl.ultimaster.api.v1.objects.json;

/** Provides id/key combination for a printer. */
public class Credential {

    private String id;
    private String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Combination [id=" + id + ", key=" + key + "]";
    }

}
