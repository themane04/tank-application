package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.utils.ErrorMessage;

/**
 * The Tank class represents a water storage tank.
 * It provides methods to calculate the stored energy and the number of days the tank can provide heating.
 * The class is abstract
 *
 * @since 08.29.2024
 * @version 1.0
 * @author Marjan Tomev
 */
public abstract class Tank {
    protected String name;
    protected double temperature;
    protected double heatedEnergyPerDay;

    /**
     * Constructor to initialize a Tank object with the given parameters.
     * @param name The name of the tank.
     * @param temperature The temperature the water can reach in Celsius.
     * @param heatedEnergyPerDay The energy required per day in kWh.
     * */
    public Tank(String name, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Getter for the name of the tank.
     * */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the tank.
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the temperature of the tank.
     * */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Setter for the temperature of the tank.
     * @param temperature The temperature the water can reach in Celsius.
     * */
    public void setTemperature(double temperature) {
        if (temperature < 1 || temperature > 30) {
            throw new IllegalArgumentException(ErrorMessage.temperatureRange);
        }
        this.temperature = temperature;
    }

    /**
     * Getter for the heated energy per day of the tank.
     * */
    public double getHeatedEnergyPerDay() {
        return heatedEnergyPerDay;
    }

    /**
     * Setter for the heated energy per day of the tank.
     * @param heatedEnergyPerDay The energy required per day in kWh.
     * */
    public void setHeatedEnergyPerDay(double heatedEnergyPerDay) {
        if (heatedEnergyPerDay <= 0) {
            throw new IllegalArgumentException("Heated energy per day must be greater than 0.");
        }
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    /**
     * Abstract method to calculate the stored energy in the tank.
     * */
    public abstract double calculateStoredEnergy();

    /**
     * Method to calculate the number of days the tank can provide heating.
     * */
    public abstract double calculateHeatingDays();

    /**
     * Abstract method to get the etiquette of the tank.
     * */
    public abstract String getLabel();

    /**
     * Returns a string representation of the Tank object, including its name, temperature, and heated energy per day.
     * */
    @Override
    public String toString() {
        return "Tank Name: " + name + "\n" +
                "Temperature: " + temperature + " °C\n" +
                "Heated Energy Per Day: " + heatedEnergyPerDay + " kWh\n";
    }
}

