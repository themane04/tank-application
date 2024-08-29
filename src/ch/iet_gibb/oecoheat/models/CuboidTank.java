package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.utils.ErrorMessage;

/**
 * The CuboidTank class represents a cuboid-shaped water storage tank.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 */
public class CuboidTank {
    protected String name;
    protected double width;
    protected double height;
    protected double depth;
    protected double temperature;
    protected double heatedEnergyPerDay;

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
    public CuboidTank(String name, double width, double height, double depth, double temperature, double heatedEnergyPerDay) {
        if (width <= 0 || height <= 0 || depth <= 0) {
            throw new IllegalArgumentException(ErrorMessage.dimensionsRange);
        }
        if (temperature <= 0 || temperature > 30) {
            throw new IllegalArgumentException(ErrorMessage.temperatureRange);
        }
        if (heatedEnergyPerDay <= 0) {
            throw new IllegalArgumentException(ErrorMessage.heatedEnergyPerDayRange);
        }

        this.name = name;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Getter for the name of the tank.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the tank.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the width of the cuboid tank.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter for the width of the cuboid tank.
     */
    public void setWidth(double width) {
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
     */
    public void setHeight(double height) {
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
     */
    public void setDepth(double depth) {
        this.depth = depth;
    }

    /**
     * Getter for the temperature of the water in the tank.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature of the water in the tank.
     */
    public void setTemperature(double temperature) {
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
     */
    public void setHeatedEnergyPerDay(double heatedEnergyPerDay) {
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Calculates the volume of the cuboid tank based on its dimensions, temperature,
     * and the specific heat capacity of water.
     *
     * @return The stored energy in the tank in kilojoules (kJ).
     */
    public double calculateStoredEnergy() {
        double volume = calculateVolume();
        double specificHeatCapacity = 4.18;
        return volume * temperature * specificHeatCapacity;
    }

    /**
     * Calculates the number of days the tank can provide heating based on the stored energy
     * and the daily energy requirement.
     *
     * @return The number of days the tank can provide heating.
     */
    public double calculateHeatingDays() {
        return calculateStoredEnergy() / (heatedEnergyPerDay * 3600);
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
     * Returns a string representation of the CuboidTank object.
     */
    @Override
    public String toString() {
        return "Tank Name: " + name + "\n" +
                "Fassungsvermögen: " + calculateVolume() + " Liter\n" +
                "Gespeicherte Energie: " + calculateStoredEnergy() / 3600 + " kWh\n" + // kWh conversion
                "Anzahl Heiztage: " + calculateHeatingDays() + " Tage\n";
    }
}
