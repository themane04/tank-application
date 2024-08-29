package ch.iet_gibb.oecoheat.application;

import ch.iet_gibb.oecoheat.models.CuboidTank;
import ch.iet_gibb.oecoheat.models.CylinderTank;
import ch.iet_gibb.oecoheat.models.LiterTank;

import static ch.iet_gibb.oecoheat.utils.Color.*;

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

        System.out.println(tankSeparator);

        // Create a CuboidTank object and set its parameters
        CuboidTank cuboidTank = new CuboidTank("Cuboid Tank", 2.0, 3.0, 1.5, 25, 5);
        cuboidTank.setName("Solar Heated Cuboid Tank");
        cuboidTank.setWidth(2.5);
        cuboidTank.setHeight(3.5);
        cuboidTank.setDepth(2.0);
        cuboidTank.setTemperature(27);
        cuboidTank.setHeatedEnergyPerDay(6);

        System.out.println(ANSI_BLUE + "\nCuboidTank Parameters:" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "\nName: " + cuboidTank.getName() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Width: " + cuboidTank.getWidth() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Height: " + cuboidTank.getHeight() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Depth: " + cuboidTank.getDepth() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Temperature: " + cuboidTank.getTemperature() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Heated Energy Per Day: " + cuboidTank.getHeatedEnergyPerDay() + ANSI_RESET);

        System.out.println(ANSI_WHITE + "\nCuboidTank toString Output:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\n" + cuboidTank + ANSI_RESET);

        System.out.println(tankSeparator);

        // Create a CylinderTank object and set its parameters
        CylinderTank cylinderTank = new CylinderTank("Cylinder Tank", 1.5, 4.0, 28, 7);
        cylinderTank.setName("Underground Cylinder Tank");
        cylinderTank.setRadius(2.0);
        cylinderTank.setHeight(4.5);
        cylinderTank.setTemperature(29);
        cylinderTank.setHeatedEnergyPerDay(8);

        System.out.println(ANSI_BLUE + "\nCylinderTank Parameters:" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "\nName: " + cylinderTank.getName() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Radius: " + cylinderTank.getRadius() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Height: " + cylinderTank.getHeight() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Temperature: " + cylinderTank.getTemperature() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Heated Energy Per Day: " + cylinderTank.getHeatedEnergyPerDay() + ANSI_RESET);

        System.out.println(ANSI_WHITE + "\nCylinderTank toString Output:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\n" + cylinderTank + ANSI_RESET);

        System.out.println(tankSeparator);

        // Create a LiterTank object and set its parameters
        LiterTank literTank = new LiterTank("Liter Tank", 5000, 26, 4);
        literTank.setName("Backup Water Reservoir");
        literTank.setVolumeInLiters(5500);
        literTank.setTemperature(28);
        literTank.setHeatedEnergyPerDay(5);

        System.out.println(ANSI_BLUE + "\nLiterTank Parameters:" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "\nName: " + literTank.getName() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Volume in Liters: " + literTank.getVolumeInLiters() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Temperature: " + literTank.getTemperature() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Heated Energy Per Day: " + literTank.getHeatedEnergyPerDay() + ANSI_RESET);

        System.out.println(ANSI_WHITE + "\nLiterTank toString Output:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\n" + literTank + ANSI_RESET);

        System.out.println(tankSeparator);
    }
}
