package ch.iet_gibb.oecoheat.models;

/**
 * The Property class represents a key-value pair.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 * */
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
