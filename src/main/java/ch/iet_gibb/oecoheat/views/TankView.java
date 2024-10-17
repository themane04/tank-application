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

public class TankView extends Application {
    protected VBox rootLayout;
    protected TankModel tankModel;

    public TankView(TankModel tank) {
        this.tankModel = tank;
        this.rootLayout = new VBox(); // Or any other layout type
        initializeView();
    }

    private void initializeView() {
        // Set up the UI components for displaying the tank properties
        Text title = new Text(tankModel.getTitle());
        ListView<String> propertiesList = new ListView<>();
        for (Property prop : tankModel.getProperties()) {
            propertiesList.getItems().add(prop.getKey() + ": " + prop.getValue());
        }
        rootLayout.getChildren().addAll(title, propertiesList);
    }

    public VBox getView() {
        return rootLayout;
    }

    @Override
    public void start(Stage stage) {
        // Set up the title label
        Label titleLabel = new Label(tankModel.getTitle());
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create TableView for properties
        TableView<Property> propertyTable = new TableView<>();

        // Set up columns for Property Key and Value
        TableColumn<Property, String> keyColumn = new TableColumn<>("Property");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("key"));

        TableColumn<Property, String> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        propertyTable.getColumns().add(keyColumn);
        propertyTable.getColumns().add(valueColumn);

        // Add tank properties to the table
        List<Property> properties = tankModel.getProperties();
        propertyTable.getItems().addAll(properties);

        // Set up layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, propertyTable);

        // Set up and show the scene
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Tank Information");
        stage.show();
    }

    public static void main(String[] args) {
        // For testing, create a sample tank and launch the view
        TankModel sampleTank = new CuboidTank("Sample Cuboid Tank", 25, 5, 2, 2, 2);
        new TankView(sampleTank).start(new Stage());
    }
}

