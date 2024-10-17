package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.utils.ErrorMessage;
import ch.iet_gibb.oecoheat.models.Property;

import java.util.List;

/**
 * The CuboidTank class represents a cuboid-shaped water storage tank.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class CuboidTank extends Tank {
    protected double width;
    protected double height;
    protected double depth;

    /**
     * Constructor to initialize a CuboidTank object with the given parameters.
     *
     * @param name               The name of the tank.
     * @param width              The width of the cuboid tank in meters.
     * @param height             The height of the cuboid tank in meters.
     * @param depth              The depth of the cuboid tank in meters.
     * @param temperature        The temperature the water can reach in Celsius.
     * @param heatedEnergyPerDay The energy required per day in kWh.
     */
    public CuboidTank(
            String name,
            double temperature,
            double heatedEnergyPerDay,
            double width,
            double height,
            double depth) {
        super(name, temperature, heatedEnergyPerDay);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String getTitle() {
        return "Cuboid Tank";
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        properties.add(new Property("Width", Double.toString(width)));
        properties.add(new Property("Height", Double.toString(height)));
        properties.add(new Property("Depth", Double.toString(depth)));
        return properties;
    }

    /**
     * Getter for the width of the cuboid tank.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter for the width of the cuboid tank.
     *
     * @param width The width of the tank in meters.
     */
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException(ErrorMessage.widthRange);
        }
        this.width = width;
    }

    /**
     * Getter for the height of the cuboid tank.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter for the height of the cuboid tank.
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
     * Getter for the depth of the cuboid tank.
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Setter for the depth of the cuboid tank.
     *
     * @param depth The depth of the tank in meters.
     */
    public void setDepth(double depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException(ErrorMessage.depthRange);
        }
        this.depth = depth;
    }

    /**
     * Calculates the volume of the cuboid tank in liters.
     *
     * @return The volume of the tank in liters.
     */
    public double calculateVolume() {
        return width * height * depth * 1000; // Liter conversion
    }

    /**
     * Calculates the volume of the cuboid tank based on its dimensions, temperature,
     * and the specific heat capacity of water.
     *
     * @return The stored energy in the tank in kilojoules (kJ).
     */
    @Override
    public double calculateStoredEnergy() {
        return calculateVolume() * temperature * 4.18;
    }

    /**
     * Getter for the temperature of the water in the tank.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature of the water in the tank.
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

    /**
     * Returns a string representation of the CuboidTank object, including its name, volume, and temperature.
     *
     * @return The string representation of the CuboidTank object.
     */
    @Override
    public String getLabel() {
        return "Name: " + name + "\n" +
                "Volume: " + calculateVolume() + " L\n" +
                "Temperature: " + temperature + " °C\n";
    }

    /**
     * Returns a string representation of the CuboidTank object, including its name, volume,
     * stored energy, and heating days.
     *
     * @return The string representation of the CuboidTank object.
     */
    @Override
    public String toString() {
        return "Tank Name: " + name + "\n" +
                "Capacity: " + calculateVolume() + " L\n" +
                "Stored Energy: " + calculateStoredEnergy() / 3600 + " kWh\n" + // kWh conversion
                "Number of Heating Days: " + calculateHeatingDays() + " days\n";
    }
}
