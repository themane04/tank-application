package ch.iet_gibb.oecoheat.models;

public class CylinderTank {
    protected String name;
    protected double radius;
    protected double height;
    protected double temperature;
    protected double heatedEnergyPerDay;

    public CylinderTank(String name, double radius, double height, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.radius = radius;
        this.height = height;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    public double calculateStoredEnergy() {
        double volume = Math.PI * Math.pow(radius, 2) * height;
        double specificHeatCapacity = 4.18;
        return volume * temperature * specificHeatCapacity;
    }

    public double calculateHeatingDays() {
        return calculateStoredEnergy() / (heatedEnergyPerDay * 3600);
    }
}
