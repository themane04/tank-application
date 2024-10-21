package ch.iet_gibb.oecoheat.models;

/**
 * The Property class represents a key-value pair.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class Property {
    // Fields for storing the key and value of the property
    protected String key;   // The label or description of the property (e.g., "Temperature", "Tank Name")
    protected String value; // The value associated with the key (e.g., "25°C", "Cuboid Tank")

    // Constructor to initialize the key-value pair
    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getter method to retrieve the key (property label)
    public String getKey() {
        return key;
    }

    // Getter method to retrieve the value associated with the key
    public String getValue() {
        return value;
    }
}
