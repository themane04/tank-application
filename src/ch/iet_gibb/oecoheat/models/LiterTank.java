package ch.iet_gibb.oecoheat.models;

/**
 * The LiterTank class represents a water storage tank with a known volume in liters.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 */
public class LiterTank {
    protected String name;
    protected double volumeInLiters;
    protected double temperature;
    protected double heatedEnergyPerDay;


    /**
     * Constructor to initialize a LiterTank object with the given parameters.
     *
     * @param name               The name of the tank.
     * @param volumeInLiters     The volume of the tank in liters.
     * @param temperature        The temperature the water can reach in Celsius.
     * @param heatedEnergyPerDay The energy required per day in kWh.
     */
    public LiterTank(String name, double volumeInLiters, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.volumeInLiters = volumeInLiters;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Calculates the stored energy in the tank based on the volume, temperature, and specific heat capacity of water.
     *
     * @return The stored energy in the tank in kilojoules (kJ).
     */
    public double calculateStoredEnergy() {
        double volume = volumeInLiters / 1000;
        double specificHeatCapacity = 4.18;
        return volumeInLiters * temperature * specificHeatCapacity;
    }

    /**
     * Calculates the number of days the tank can provide heating based on the stored energy and daily energy requirement.
     *
     * @return The number of days the tank can provide heating.
     */
    public double calculateHeatingDays() {
        return calculateStoredEnergy() / (heatedEnergyPerDay * 3600);
    }
}
