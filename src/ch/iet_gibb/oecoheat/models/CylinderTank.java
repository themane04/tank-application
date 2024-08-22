package ch.iet_gibb.oecoheat.models;

/**
 * The CylinderTank class represents a cylindrical water storage tank.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 */
public class CylinderTank {
    protected String name;
    protected double radius;
    protected double height;
    protected double temperature;
    protected double heatedEnergyPerDay;

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
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be greater than zero.");
        }
        if (temperature <= 0 || temperature > 30) {
            throw new IllegalArgumentException("Temperature must be between 1 and 30 degrees Celsius.");
        }
        if (heatedEnergyPerDay <= 0) {
            throw new IllegalArgumentException("Heated energy per day must be greater than zero.");
        }
        this.name = name;
        this.radius = radius;
        this.height = height;
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
     * Getter for the radius of the tank.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for the radius of the tank.
     */
    public void setRadius(double radius) {
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
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Getter for the temperature of the tank.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature of the tank.
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
     * Calculates the stored energy in the cylindrical tank based on its volume, temperature,
     * and the specific heat capacity of water.
     *
     * @return The stored energy in the tank in kilojoules (kJ).
     */
    public double calculateStoredEnergy() {
        double volume = Math.PI * Math.pow(radius, 2) * height;
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
}
