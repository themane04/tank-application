package ch.iet_gibb.oecoheat.application;

import ch.iet_gibb.oecoheat.models.CuboidTank;
import ch.iet_gibb.oecoheat.models.CylinderTank;
import ch.iet_gibb.oecoheat.models.LiterTank;

/**
 * The main class for the HeatCalculator application.
 * This class serves as the entry point for the application.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class HeatCalculatorApp {

    /**
     * The main method that starts the application.
     */
    public static void main(String[] args) {
        // Create a CuboidTank object and set its parameters
        CuboidTank cuboidTank = new CuboidTank("Cuboid Tank", 2.0, 3.0, 1.5, 25, 5);
        cuboidTank.setName("My new Cuboid Tank");
        cuboidTank.setWidth(2.5);
        cuboidTank.setHeight(3.5);
        cuboidTank.setDepth(2.0);
        cuboidTank.setTemperature(27);
        cuboidTank.setHeatedEnergyPerDay(6);

        System.out.println("\nCuboidTank Parameters:");
        System.out.println("\nName: " + cuboidTank.getName());
        System.out.println("Width: " + cuboidTank.getWidth());
        System.out.println("Height: " + cuboidTank.getHeight());
        System.out.println("Depth: " + cuboidTank.getDepth());
        System.out.println("Temperature: " + cuboidTank.getTemperature());
        System.out.println("Heated Energy Per Day: " + cuboidTank.getHeatedEnergyPerDay());

        System.out.println("\nCuboidTank toString Output:");
        System.out.println(cuboidTank);

        // Create a CylinderTank object and set its parameters
        CylinderTank cylinderTank = new CylinderTank("Cylinder Tank", 1.5, 4.0, 28, 7);
        cylinderTank.setName("My new Cylinder Tank");
        cylinderTank.setRadius(2.0);
        cylinderTank.setHeight(4.5);
        cylinderTank.setTemperature(29);
        cylinderTank.setHeatedEnergyPerDay(8);

        System.out.println("\nCylinderTank Parameters:");
        System.out.println("\nName: " + cylinderTank.getName());
        System.out.println("Radius: " + cylinderTank.getRadius());
        System.out.println("Height: " + cylinderTank.getHeight());
        System.out.println("Temperature: " + cylinderTank.getTemperature());
        System.out.println("Heated Energy Per Day: " + cylinderTank.getHeatedEnergyPerDay());

        System.out.println("\nCylinderTank toString Output:");
        System.out.println(cylinderTank);

        // Create a LiterTank object and set its parameters
        LiterTank literTank = new LiterTank("Liter Tank", 5000, 26, 4);
        literTank.setName("My new Liter Tank");
        literTank.setVolumeInLiters(5500);
        literTank.setTemperature(28);
        literTank.setHeatedEnergyPerDay(5);

        System.out.println("\nLiterTank Parameters:");
        System.out.println("\nName: " + literTank.getName());
        System.out.println("Volume in Liters: " + literTank.getVolumeInLiters());
        System.out.println("Temperature: " + literTank.getTemperature());
        System.out.println("Heated Energy Per Day: " + literTank.getHeatedEnergyPerDay());

        System.out.println("\nLiterTank toString Output:");
        System.out.println(literTank);
    }
}
