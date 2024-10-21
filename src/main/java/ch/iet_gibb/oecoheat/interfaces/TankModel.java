package ch.iet_gibb.oecoheat.interfaces;

import ch.iet_gibb.oecoheat.models.Property;

import java.util.List;

/**
 * Interface for TankModel
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 1.0
 */
public interface TankModel {
    // Method to retrieve the title of the tank, used in the view
    String getTitle();
    // Method to retrieve a list of properties (key-value pairs) describing the tank
    List<Property> getProperties();
}
