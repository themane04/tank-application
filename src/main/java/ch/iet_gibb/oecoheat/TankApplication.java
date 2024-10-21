package ch.iet_gibb.oecoheat;

import ch.iet_gibb.oecoheat.controllers.TankController;
import javafx.application.Application;
import javafx.stage.Stage;

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
        // Create an instance of the TankController which manages the tanks and the view
        TankController tankController = new TankController();

        // Start the TankController, which will handle setting up the view and displaying it on the stage
        tankController.start(primaryStage);
    }

    /**
     * The main method for launching the JavaFX application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}