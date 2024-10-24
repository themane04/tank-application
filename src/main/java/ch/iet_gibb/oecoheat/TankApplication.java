package ch.iet_gibb.oecoheat;

import ch.iet_gibb.oecoheat.controllers.TankController;
import ch.iet_gibb.oecoheat.models.CuboidTank;
import ch.iet_gibb.oecoheat.models.CylinderTank;
import ch.iet_gibb.oecoheat.models.Tank;
import ch.iet_gibb.oecoheat.views.TankView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * The TankApplication class is the main class of the tank application.
 * It starts the tank controller.
 * The application is implemented as a JavaFX application.
 * The application can be started by calling the start method.
 * The application is a subclass of the Java
 * Application class.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class TankApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create some sample tanks
        List<Tank> tanks = createSampleTanks();

        // Create the controller and link it to the tanks
        // Create the view, passing both the stage and the controller
        TankController controller = new TankController(tanks, null);

        // Now link the view to the controller
        controller.view = new TankView(primaryStage, controller);

        // Start the controller (which starts the first tank in the view)
        controller.start();
    }

    /**
     * Creates sample tank data to be used in the application.
     *
     * @return a list of tanks.
     */
    private List<Tank> createSampleTanks() {
        List<Tank> tanks = new ArrayList<>();
        tanks.add(new CuboidTank("Cuboid Tank", 25, 5, 2, 2, 2));
        tanks.add(new CylinderTank("Cylinder Tank", 22, 4, 3, 7));
        return tanks;
    }

    public static void main(String[] args) {
        launch(args); // Launches the JavaFX application
    }
}
