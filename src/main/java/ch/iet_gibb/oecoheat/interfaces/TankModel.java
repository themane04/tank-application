package ch.iet_gibb.oecoheat.interfaces;

import ch.iet_gibb.oecoheat.models.Property;

import java.util.List;

public interface TankModel {
    String getTitle();
    List<Property> getProperties();
}
