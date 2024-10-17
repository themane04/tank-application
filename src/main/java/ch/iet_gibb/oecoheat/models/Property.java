package ch.iet_gibb.oecoheat.models;

public class Property {
    protected String key;
    protected String value;

    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
