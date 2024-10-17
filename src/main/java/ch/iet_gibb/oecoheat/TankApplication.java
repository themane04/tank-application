package ch.iet_gibb.oecoheat;

import ch.iet_gibb.oecoheat.controllers.TankController;
import javafx.application.Application;
import javafx.stage.Stage;

public class TankApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create an instance of the TankController
        TankController tankController = new TankController();

        // Start the TankController, which handles the view and stage setup
        tankController.start(primaryStage);
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}