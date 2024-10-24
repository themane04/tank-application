package ch.iet_gibb.oecoheat.views;

import ch.iet_gibb.oecoheat.controllers.TankController;
import ch.iet_gibb.oecoheat.interfaces.ControllerViewInterface;
import ch.iet_gibb.oecoheat.interfaces.TankModel;
import ch.iet_gibb.oecoheat.models.Property;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

import java.util.List;
import java.util.Objects;


/**
 * The AlternativeTankView class represents the alternative view of a tank.
 * It displays the tank's properties in a different way.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
public class AlternativeTankView implements ControllerViewInterface {
    protected Stage stage;
    protected VBox layout;
    protected VBox propertiesLayout; // Layout specifically for tank properties
    protected Button nextTankButton;
    protected Button backToNormalViewButton; // Button to switch back to normal view

    public AlternativeTankView(Stage stage, TankController controller) {
        this.stage = stage;

        // Create the main layout (VBox)
        layout = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // Apply background image using CSS
        layout.setStyle("-fx-background-image: url('" + Objects.requireNonNull(getClass().getResource("/images/background.jpg")).toExternalForm() + "');");

        // Add a separate layout for the properties (this is key to maintaining structure)
        propertiesLayout = new VBox(15); // More spacing between properties
        layout.getChildren().add(propertiesLayout); // Add it to the main layout

        // Create the button to go to the next tank
        nextTankButton = new Button("Next Tank (Alternative)");
        nextTankButton.setOnAction(controller); // Delegate the event to the controller
        nextTankButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white; -fx-font-size: 16px;");

        // Create the "Back to Normal View" button
        backToNormalViewButton = new Button("Back to Normal View");
        backToNormalViewButton.setOnAction(e -> controller.switchToNormalView());
        backToNormalViewButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");

        // Create an HBox to hold both buttons side by side with a gap
        HBox buttonsBox = new HBox(15); // 15 is the spacing between the buttons
        buttonsBox.getChildren().addAll(nextTankButton, backToNormalViewButton);
        layout.getChildren().add(buttonsBox); // Add the buttons layout at the bottom

        // Create the scene and set it on the stage
        Scene scene = new Scene(layout, 612, 395);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Alternative Tank Viewer");
    }

    /**
     * Updates the view with the given tank properties.
     *
     * @param properties The tank properties to display.
     */
    public void updateView(List<Property> properties) {
        // Clear the existing property fields (if any)
        propertiesLayout.getChildren().clear(); // Clear all elements from the propertiesLayout

        // Loop through properties and create label + text field pairs with dividers
        for (Property prop : properties) {
            VBox vbox = new VBox(5); // Vertical box for property and divider
            Label label = new Label(prop.getKey() + ": " + prop.getValue());
            label.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
            label.setStyle("-fx-text-fill: #3B3B3B;"); // Dark gray text color

            // Add a separator (divider)
            Separator separator = new Separator();
            separator.setStyle("-fx-background-color: #CCCCCC;"); // Light gray separator

            // Add the label and separator to the VBox
            vbox.getChildren().addAll(label, separator);
            propertiesLayout.getChildren().add(vbox); // Add the VBox to the properties layout
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



