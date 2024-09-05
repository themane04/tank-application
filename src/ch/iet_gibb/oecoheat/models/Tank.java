package ch.iet_gibb.oecoheat.models;

import ch.iet_gibb.oecoheat.utils.ErrorMessage;

public abstract class Tank {
    protected String name;
    protected double temperature;
    protected double heatedEnergyPerDay;

    public Tank(String name, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature < 1 || temperature > 30) {
            throw new IllegalArgumentException(ErrorMessage.temperatureRange);
        }
        this.temperature = temperature;
    }

    public double getHeatedEnergyPerDay() {
        return heatedEnergyPerDay;
    }

    public void setHeatedEnergyPerDay(double heatedEnergyPerDay) {
        if (heatedEnergyPerDay <= 0) {
            throw new IllegalArgumentException("Heated energy per day must be greater than 0.");
        }
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    public abstract double calculateStoredEnergy();

    public double calculateHeatingDays() {
        return calculateStoredEnergy() / (heatedEnergyPerDay * 3600);
    }

    @Override
    public String toString() {
        return "Tank Name: " + name + "\n" +
                "Temperature: " + temperature + " °C\n" +
                "Heated Energy Per Day: " + heatedEnergyPerDay + " kWh\n";
    }
}

