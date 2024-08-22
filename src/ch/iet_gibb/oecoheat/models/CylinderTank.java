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
        this.name = name;
        this.radius = radius;
        this.height = height;
        this.temperature = temperature;
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
