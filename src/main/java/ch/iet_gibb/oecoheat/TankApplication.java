package ch.iet_gibb.oecoheat;

import ch.iet_gibb.oecoheat.controllers.TankController;
import ch.iet_gibb.oecoheat.interfaces.TankModel;
import ch.iet_gibb.oecoheat.models.CuboidTank;
import ch.iet_gibb.oecoheat.models.CylinderTank;
import ch.iet_gibb.oecoheat.models.Tank;
import ch.iet_gibb.oecoheat.views.AlternativeTankView;
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
        List<TankModel> tanks = createSampleTanks();

        // Create the controller, passing the stage for view switching
        TankController controller = new TankController(tanks, primaryStage);

        // Inject the normal TankView as the default
        TankView view = new TankView(primaryStage, controller);
        controller.setView(view);

        // Start the controller
        controller.startView();
    }

    private List<TankModel> createSampleTanks() {
        List<TankModel> tanks = new ArrayList<>();
        tanks.add(new CuboidTank("Cuboid Tank", 25, 5, 2, 2, 2));
        tanks.add(new CylinderTank("Cylinder Tank", 22, 4, 3, 7));
        return tanks;
    }

    public static void main(String[] args) {
        launch(args);
    }
}



