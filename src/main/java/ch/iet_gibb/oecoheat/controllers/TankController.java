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

public class TankController extends Application {
    protected TankView view;
    protected List<TankModel> tanks;
    private int currentTankIndex = 0;
    private VBox root;

    public TankController() {
        // Initialize your tank models
        tanks = new ArrayList<>();
        tanks.add(new CuboidTank("Cuboid Tank", 25, 5, 2, 2, 2));
        tanks.add(new CylinderTank("Cylinder Tank", 22, 4, 3, 7));

        // Set the initial tank view with the first tank in the list
        view = new TankView(tanks.get(currentTankIndex));
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the main layout
        root = new VBox(10); // Use the instance variable directly

        // Set up the button and its action
        Button nextTankButton = new Button("Next Tank");
        nextTankButton.setOnAction(e -> showNextTank());

        // Initialize the view for the first tank
        view.start(primaryStage);

        // Add view layout and buttons to the main layout
        root.getChildren().addAll(view.getView(), nextTankButton);

        // Set up the scene and show the stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tank Viewer");
        primaryStage.show();
    }

    private void showNextTank() {
        // Cycle through the tank list and update the view
        currentTankIndex = (currentTankIndex + 1) % tanks.size();
        root.getChildren().set(0, new TankView(tanks.get(currentTankIndex)).getView());
    }
}

