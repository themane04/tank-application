package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.utils.ErrorMessage;

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
        if (volumeInLiters <= 0) {
            throw new IllegalArgumentException(ErrorMessage.volumeInLitersRange);
        }
        if (temperature <= 0 || temperature > 30) {
            throw new IllegalArgumentException(ErrorMessage.temperatureRange);
        }
        if (heatedEnergyPerDay <= 0) {
            throw new IllegalArgumentException(ErrorMessage.heatedEnergyPerDayRange);
        }
        this.name = name;
        this.volumeInLiters = volumeInLiters;
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
     * Getter for the volume of the tank in liters.
     */
    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    /**
     * Setter for the volume of the tank in liters.
     */
    public void setVolumeInLiters(double volumeInLiters) {
        this.volumeInLiters = volumeInLiters;
    }

    /**
     * Getter for the temperature the water can reach in Celsius.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature the water can reach in Celsius.
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Getter for the energy required per day in kWh.
     */
    public double getHeatedEnergyPerDay() {
        return heatedEnergyPerDay;
    }

    /**
     * Setter for the energy required per day in kWh.
     */
    public void setHeatedEnergyPerDay(double heatedEnergyPerDay) {
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