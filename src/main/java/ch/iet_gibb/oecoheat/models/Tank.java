package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.interfaces.TankModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The Tank class represents a water storage tank.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 * The class is abstract
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public abstract class Tank implements TankModel {
    protected String name;
    protected double temperature;
    protected double heatedEnergyPerDay;

    /**
     * Constructor to initialize a Tank object with the given parameters.
     *
     * @param name               The name of the tank.
     * @param temperature        The temperature the water can reach in Celsius.
     * @param heatedEnergyPerDay The energy required per day in kWh.
     */
    public Tank(String name, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Method to get the properties of the tank.
     */
    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("Name", name));
        properties.add(new Property("Temperature", Double.toString(temperature)));
        properties.add(new Property("Heated Energy Per Day", Double.toString(heatedEnergyPerDay)));
        return properties;
    }

    /**
     * Abstract method to calculate the stored energy in the tank.
     */
    public abstract double calculateStoredEnergy();

    /**
     * Method to calculate the number of days the tank can provide heating.
     */
    public abstract double calculateHeatingDays();

    /**
     * Abstract method to calculate the volume of the tank.
     */
    public abstract double calculateVolume();

    /**
     * Abstract method to get the etiquette of the tank.
     */
    public abstract String getLabel();

    /**
     * Returns a string representation of the Tank object, including its name, temperature, and heated energy per day.
     */
    @Override
    public String toString() {
        return "Tank Name: " + name + "\n" +
                "Temperature: " + temperature + " °C\n" +
                "Heated Energy Per Day: " + heatedEnergyPerDay + " kWh\n";
    }
}

