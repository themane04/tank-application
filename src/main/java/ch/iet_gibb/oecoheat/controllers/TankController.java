package ch.iet_gibb.oecoheat.controllers;

import ch.iet_gibb.oecoheat.models.Tank;
import ch.iet_gibb.oecoheat.views.TankView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class TankController implements EventHandler<ActionEvent> {
    protected List<Tank> tanks; // List of tanks (models)
    private int currentTankIndex = 0; // Index of the currently displayed tank
    public TankView view; // The view to display the tanks

    public TankController(List<Tank> tanks, TankView view) {
        this.tanks = tanks;
        this.view = view;
    }

    /**
     * Starts the view by displaying the first tank.
     */
    public void start() {
        // Pass the list of properties to the view
        view.updateView(tanks.get(currentTankIndex).getProperties());
    }

    /**
     * Handles the event for showing the next tank.
     * This method is called when the user clicks the "Next Tank" button.
     */
    @Override
    public void handle(ActionEvent event) {
        showNextTank();
    }

    /**
     * Cycles through the list of tanks and updates the view with the next tank.
     */
    private void showNextTank() {
        currentTankIndex = (currentTankIndex + 1) % tanks.size();
        view.updateView(tanks.get(currentTankIndex).getProperties());
    }
}
