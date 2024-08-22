package ch.iet_gibb.oecoheat.models;

public class LiterTank {
    protected String name;
    protected double volumeInLiters;
    protected double temperature;
    protected double heatedEnergyPerDay;

    public LiterTank(String name, double volumeInLiters, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.volumeInLiters = volumeInLiters;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    public double calculateStoredEnergy() {
        double volume = volumeInLiters / 1000;
        double specificHeatCapacity = 4.18;
        return volumeInLiters * temperature * specificHeatCapacity;
    }

    public double calculateHeatingDays() {
        return calculateStoredEnergy() / (heatedEnergyPerDay * 3600);
    }
}
