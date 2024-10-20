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
    protected TankView view;
    protected List<TankModel> tanks;
    private int currentTankIndex = 0;
    private VBox root;

    public TankController() {
        tanks = new ArrayList<>();
        tanks.add(new CuboidTank("Cuboid Tank", 25, 5, 2, 2, 2));
        tanks.add(new CylinderTank("Cylinder Tank", 22, 4, 3, 7));

        view = new TankView(tanks.get(currentTankIndex));
    }

    @Override
    public void start(Stage primaryStage) {
        root = new VBox(10);

        Button nextTankButton = new Button("Next Tank");
        nextTankButton.setOnAction(_ -> showNextTank());

        view.start(primaryStage);

        root.getChildren().addAll(view.getView(), nextTankButton);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tank Viewer");
        primaryStage.show();
    }

    private void showNextTank() {
        currentTankIndex = (currentTankIndex + 1) % tanks.size();
        root.getChildren().set(0, new TankView(tanks.get(currentTankIndex)).getView());
    }
}

