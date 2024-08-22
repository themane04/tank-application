package ch.iet_gibb.oecoheat.models;

public class CuboidTank {
    protected String name;
    protected double width;
    protected double height;
    protected double depth;
    protected double temperature;
    protected double heatedEnergyPerDay;

    public CuboidTank(String name, double width, double height, double depth, double temperature, double heatedEnergyPerDay) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.temperature = temperature;
        this.heatedEnergyPerDay = heatedEnergyPerDay;
    }

    public double calculateVolume() {
        double volume = width * height * depth;
        double specificHeatCapacity = 4.18;
        return volume * temperature * specificHeatCapacity;
    }

    public double calculateHeatingDays() {
        return calculateVolume() / (heatedEnergyPerDay * 3600);
    }
}
