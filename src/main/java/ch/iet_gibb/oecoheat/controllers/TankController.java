package ch.iet_gibb.oecoheat.controllers;

import ch.iet_gibb.oecoheat.interfaces.ControllerViewInterface;
import ch.iet_gibb.oecoheat.interfaces.TankModel;
import ch.iet_gibb.oecoheat.views.AlternativeTankView;
import ch.iet_gibb.oecoheat.views.TankView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.List;

public class TankController implements EventHandler<ActionEvent> {
    protected List<TankModel> tanks;
    private int currentTankIndex = 0;
    protected ControllerViewInterface view;
    protected Stage stage;

    public TankController(List<TankModel> tanks, Stage stage) {
        this.tanks = tanks;
        this.stage = stage;
    }

    public void setView(ControllerViewInterface view) {
        this.view = view; // Now the controller works with any view implementing the interface
    }

    public void startView() {
        view.startView(tanks.get(currentTankIndex)); // Start the view with the first tank
    }

    @Override
    public void handle(ActionEvent event) {
        showNextTank();
    }

    private void showNextTank() {
        currentTankIndex = (currentTankIndex + 1) % tanks.size();
        view.startView(tanks.get(currentTankIndex)); // Show the next tank in the view
    }

    public void switchToAlternativeView() {
        AlternativeTankView alternativeView = new AlternativeTankView(stage, this);
        setView(alternativeView);
        startView(); // Show the alternative view with the current tank
    }

    public void switchToNormalView() {
        view = new TankView(stage, this);
        startView(); // Show the normal view with the current tank
    }
}

