package ch.iet_gibb.oecoheat.controllers;

import ch.iet_gibb.oecoheat.interfaces.TankModel;
import ch.iet_gibb.oecoheat.models.CuboidTank;
import ch.iet_gibb.oecoheat.models.CylinderTank;
import ch.iet_gibb.oecoheat.views.TankView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

/**
 * The TankController class is the controller of the tank application.
 * It manages the tanks and the view.
 * The controller is implemented as a JavaFX application.
 * The controller can be started by calling the start method.
 * The controller is initialized with a list of tank models.
 * The controller is a subclass of the Java
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class TankController extends Application {
    // View that displays the current tank's information
    protected TankView view;
    // List of tanks to cycle through
    protected List<TankModel> tanks;
    // Index to keep track of the current tank being shown
    private int currentTankIndex = 0;
    // Root layout for the scene
    private VBox root;

    // Constructor to initialize the list of tanks and set up the initial view
    public TankController() {
        tanks = new ArrayList<>();

        // Adding two sample tanks: a CuboidTank and a CylinderTank
        tanks.add(new CuboidTank("Cuboid Tank", 25, 5, 2, 2, 2));
        tanks.add(new CylinderTank("Cylinder Tank", 22, 4, 3, 7));

        // Set up the view with the first tank in the list
        view = new TankView(tanks.get(currentTankIndex));
    }

    @Override
    public void start(Stage primaryStage) {
        // VBox layout with 10 units of spacing between components
        root = new VBox(10);

        // Create a button to switch to the next tank
        Button nextTankButton = new Button("Next Tank");

        // When the button is clicked, call the showNextTank method
        nextTankButton.setOnAction(_ -> showNextTank());

        // Add the current view and the button to the layout
        root.getChildren().addAll(view.getView(), nextTankButton);

        // Create the scene with the root layout and set its dimensions
        Scene scene = new Scene(root, 600, 400);

        // Set the scene and the title of the primary window (stage)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tank Viewer");

        // Display the primary stage
        primaryStage.show();
    }

    // Method to cycle through the tank list and update the view
    private void showNextTank() {
        // Increment the current index, and wrap around if it reaches the end of the list
        currentTankIndex = (currentTankIndex + 1) % tanks.size();

        // Replace the current view with the new tank's view
        root.getChildren().set(0, new TankView(tanks.get(currentTankIndex)).getView());
    }
}