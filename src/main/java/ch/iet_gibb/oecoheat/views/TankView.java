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
    protected VBox rootLayout;
    protected TankModel tankModel;

    public TankView(TankModel tank) {
        this.tankModel = tank;
        this.rootLayout = new VBox();
        initializeView();
    }

    private void initializeView() {
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
        Label titleLabel = new Label(tankModel.getTitle());
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TableView<Property> propertyTable = new TableView<>();

        TableColumn<Property, String> keyColumn = new TableColumn<>("Property");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("key"));

        TableColumn<Property, String> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        propertyTable.getColumns().add(keyColumn);
        propertyTable.getColumns().add(valueColumn);

        List<Property> properties = tankModel.getProperties();
        propertyTable.getItems().addAll(properties);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, propertyTable);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Tank Information");
        stage.show();
    }

    public static void main(String[] args) {
        TankModel sampleTank = new CuboidTank("Sample Cuboid Tank", 25, 5, 2, 2, 2);
        new TankView(sampleTank).start(new Stage());
    }
}

