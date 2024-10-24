package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.utils.ErrorMessage;

import java.util.List;

/**
 * The CylinderTank class represents a cylindrical water storage tank.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class CylinderTank extends Tank {
    protected double radius;
    protected double height;

    /**
     * Constructor to initialize a CylinderTank object with the given parameters.
     *
     * @param name               The name of the tank.
     * @param radius             The radius of the tank in meters.
     * @param height             The height of the tank in meters.
     * @param temperature        The temperature the water can reach in Celsius.
     * @param heatedEnergyPerDay The energy required per day in kWh.
     */
    public CylinderTank(String name, double radius, double height, double temperature, double heatedEnergyPerDay) {
        super(name, temperature, heatedEnergyPerDay);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        properties.add(new Property("Radius", Double.toString(radius)));
        properties.add(new Property("Height", Double.toString(height)));
        return properties;
    }

    /**
     * Getter for the radius of the tank.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for the radius of the tank.
     *
     * @param radius The radius of the tank in meters.
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(ErrorMessage.radiusRange);
        }
        this.radius = radius;
    }

    /**
     * Getter for the height of the tank.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter for the height of the tank.
     *
     * @param height The height of the tank in meters.
     */
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(ErrorMessage.heightRange);
        }
        this.height = height;
    }

    /**
     * Calculates the volume of the tank in liters.
     *
     * @return The volume of the tank in liters.
     */
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height * 1000; // Liters conversion
    }

    /**
     * Calculates the stored energy in the cylindrical tank based on its volume, temperature,
     * and the specific heat capacity of water.
     *
     * @return The stored energy in the tank in kilojoules (kJ).
     */
    @Override
    public double calculateStoredEnergy() {
        return calculateVolume() * temperature * 4.18;
    }

    /**
     * Getter for the temperature of the tank.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature of the tank.
     *
     * @param temperature The temperature the water can reach in Celsius.
     */
    public void setTemperature(double temperature) {
        if (temperature <= 0 || temperature > 30) {
            throw new IllegalArgumentException(ErrorMessage.temperatureRange);
        }
        this.temperature = temperature;
    }

    /**
     * Getter for the heated energy per day.
     */
    public double getHeatedEnergyPerDay() {
        return heatedEnergyPerDay;
    }

    /**
     * Setter for the heated energy per day.
     *
     * @param heatedEnergyPerDay The energy required per day in kWh.
     */
    public void setHeatedEnergyPerDay(double heatedEnergyPerDay) {
        if (heatedEnergyPerDay <= 0) {
            throw new IllegalArgumentException(ErrorMessage.heatedEnergyPerDayRange);
        }
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Calculates the number of days the tank can provide heating based on the stored energy
     * and the daily energy requirement.
     *
     * @return The number of days the tank can provide heating.
     */
    @Override
    public double calculateHeatingDays() {
        return calculateStoredEnergy() / (heatedEnergyPerDay * 3600);
    }

    @Override
    public String getLabel() {
        return "Name: " + name + "\n" + "Volume: " + calculateVolume() + " L\n" + "Temperature: " + temperature + "°C\n";
    }

    /**
     * Returns a string representation of the CylinderTank object, including its name, volume,
     * stored energy, and heating days.
     *
     * @return The string representation of the CylinderTank object.
     */
    @Override
    public String toString() {
        return "Tank Name: " + name +
                "\n" + "Capacity: " + calculateVolume() +
                " L\n" + "Stored Energy: " + calculateStoredEnergy() / 3600 + " kWh\n" + // kWh conversion
                "Number of Heating Days: " + calculateHeatingDays() + " days\n";
    }
}

