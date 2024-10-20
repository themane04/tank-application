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
    String getTitle();
    List<Property> getProperties();
}
