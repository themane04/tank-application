package ch.iet_gibb.oecoheat.models;

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
        this.name = name;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Calculates the volume of the cuboid tank based on its dimensions, temperature,
     * and the specific heat capacity of water.
     *
     * @return The stored energy in the tank in kilojoules (kJ).
     */
    public double calculateVolume() {
        double volume = width * height * depth;
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
        return calculateVolume() / (heatedEnergyPerDay * 3600);
    }
}
