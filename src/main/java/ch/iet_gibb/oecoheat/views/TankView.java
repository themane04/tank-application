package ch.iet_gibb.oecoheat.views;

import ch.iet_gibb.oecoheat.interfaces.TankModel;
import ch.iet_gibb.oecoheat.models.CuboidTank;
import ch.iet_gibb.oecoheat.models.Property;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;


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
public class TankView extends Application {
    // The root layout for the view, which will contain all the UI components
    protected VBox rootLayout;

    // The model of the tank, which provides data for the view
    protected TankModel tankModel;

    // Constructor that initializes the view with a specific tank model
    public TankView(TankModel tank) {
        this.tankModel = tank;  // Set the tank model
        this.rootLayout = new VBox();  // Initialize the root layout (a vertical box)
        initializeView();  // Set up the user interface components
    }

    // Method that sets up the UI for displaying tank information
    private void initializeView() {
        // Create a title for the tank using the model's getTitle() method
        Text title = new Text(tankModel.getTitle());

        // Create a ListView to display key-value pairs of the tank's properties
        ListView<String> propertiesList = new ListView<>();

        // Iterate through the properties of the tank and add them to the ListView
        for (Property prop : tankModel.getProperties()) {
            propertiesList.getItems().add(prop.getKey() + ": " + prop.getValue());
        }

        // Add the title and property list to the root layout
        rootLayout.getChildren().addAll(title, propertiesList);
    }

    // Method to return the root layout (the container for all UI components)
    public VBox getView() {
        return rootLayout;
    }

    @Override
    public void start(Stage stage) {
        // Create a label for the tank's title with styling
        Label titleLabel = new Label(tankModel.getTitle());
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create a TableView to display the tank properties in a table format
        TableView<Property> propertyTable = new TableView<>();

        // Create a column for the property name (key) and set how data is retrieved
        TableColumn<Property, String> keyColumn = new TableColumn<>("Property");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("key"));

        // Create a column for the property value and set how data is retrieved
        TableColumn<Property, String> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        // Add the columns to the table
        propertyTable.getColumns().add(keyColumn);
        propertyTable.getColumns().add(valueColumn);

        // Add all properties of the tank model to the table
        List<Property> properties = tankModel.getProperties();
        propertyTable.getItems().addAll(properties);

        // Set up the layout for the scene with padding and spacing
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, propertyTable);

        // Create a scene with the layout and set it on the stage
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Tank Information");  // Set the window title
        stage.show();  // Display the window
    }

    // The main method for launching the application
    public static void main(String[] args) {
        // Create a sample tank model and launch the view to display it
        TankModel sampleTank = new CuboidTank("Sample Cuboid Tank", 25, 5, 2, 2, 2);
        new TankView(sampleTank).start(new Stage());  // Launch a new stage with the tank view
    }
}
