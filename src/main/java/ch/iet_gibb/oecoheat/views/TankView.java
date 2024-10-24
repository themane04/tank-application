package ch.iet_gibb.oecoheat.views;

import ch.iet_gibb.oecoheat.controllers.TankController;
import ch.iet_gibb.oecoheat.interfaces.ControllerViewInterface;
import ch.iet_gibb.oecoheat.interfaces.TankModel;
import ch.iet_gibb.oecoheat.models.Property;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The TankView class represents the view of a tank.
 * It displays the tank's title and properties.
 * The properties are displayed in a list.
 * The view is implemented as a JavaFX application.
 * The view can be started by calling the start method.
 * The view is initialized with a tank model.
 * The view is a subclass of the JavaFX Application class.
 * The view is a subclass of the Java
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class TankView implements ControllerViewInterface {
    protected Stage stage; // The window (stage)
    protected VBox layout; // Layout to hold all the elements
    protected VBox propertiesLayout; // Layout specifically for tank properties
    protected Button nextTankButton; // The button to go to the next tank
    protected Button alternativeViewButton; // The button to switch to the alternative view

    public TankView(Stage stage, TankController controller) {
        this.stage = stage;

        // Create the main layout (VBox)
        layout = new VBox(10);
        layout.setPadding(new Insets(15, 15, 15, 15));

        // Add a separate layout for the properties (this is key to maintaining structure)
        propertiesLayout = new VBox(10);
        layout.getChildren().add(propertiesLayout);  // Add it to the main layout

        // Apply background image using CSS
        layout.setStyle("-fx-background-image: url('" + Objects.requireNonNull(getClass().getResource("/images/background.jpg")).toExternalForm() + "');");

        // Create the button to go to the next tank and apply some color
        nextTankButton = new Button("Next Tank");
        nextTankButton.setOnAction(controller); // Delegate the event to the controller
        nextTankButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

        // Create the "Alternative View" button
        alternativeViewButton = new Button("Alternative View");
        alternativeViewButton.setOnAction(e -> controller.switchToAlternativeView()); // Delegate the event to the controller
        alternativeViewButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white; -fx-font-size: 14px;");

        // Create an HBox to hold both buttons side by side with a gap
        HBox buttonsBox = new HBox(10); // 10 is the spacing between the buttons

        // Add the "Next Tank" and "Alternative View" buttons to the HBox
        buttonsBox.getChildren().addAll(nextTankButton, alternativeViewButton);

        // Add the HBox (buttonsBox) to the layout
        layout.getChildren().add(buttonsBox); // Add the buttons layout at the bottom

        // Create the scene and set it on the stage
        Scene scene = new Scene(layout, 612, 395);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Tank Viewer");
    }

    /**
     * Updates the view with the given tank properties.
     *
     * @param properties The tank properties to display.
     */
    public void updateView(List<Property> properties) {
        // Clear the existing property fields (if any)
        propertiesLayout.getChildren().clear(); // Clear all elements from the propertiesLayout

        // Loop through properties and create label + text field pairs
        for (Property prop : properties) {
            HBox hbox = new HBox(10); // Horizontal box for label and text field
            Label label = new Label(prop.getKey() + ":");
            label.setStyle("-fx-font-weight: bold; -fx-text-fill: #3B3B3B;"); // Set label color to gray

            TextField textField = new TextField(prop.getValue());
            textField.setEditable(false); // Make the field non-editable
            textField.setStyle("-fx-control-inner-background: #D3D3D3; -fx-text-fill: #333333;"); // Set text field background and text color

            hbox.getChildren().addAll(label, textField); // Add label and text field to the HBox
            propertiesLayout.getChildren().add(hbox); // Add the HBox to the properties layout
        }

        // Show the updated stage
        stage.show();
    }

    @Override
    public void startView(TankModel data) {
        // Update the view with tank properties
        updateView(data.getProperties());
    }
}

