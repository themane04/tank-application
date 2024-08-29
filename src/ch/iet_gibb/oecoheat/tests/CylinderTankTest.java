package ch.iet_gibb.oecoheat.tests;

import ch.iet_gibb.oecoheat.models.CylinderTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CylinderTankTest {

    private CylinderTank tank;

    @BeforeEach
    void setUp() {
        tank = new CylinderTank("TestCylinderTank", 2, 5, 25, 8);
    }

    @Test
    void getName() {
        assertEquals("TestCylinderTank", tank.getName());
    }

    @Test
    void setName() {
        tank.setName("NewTestCylinderTank");
        assertEquals("NewTestCylinderTank", tank.getName());
    }

    @Test
    void getRadius() {
        assertEquals(2, tank.getRadius());
    }

    @Test
    void setRadius() {
        tank.setRadius(3);
        assertEquals(3, tank.getRadius());
        assertThrows(IllegalArgumentException.class, () -> tank.setRadius(0));
    }

    @Test
    void getHeight() {
        assertEquals(5, tank.getHeight());
    }

    @Test
    void setHeight() {
        tank.setHeight(6);
        assertEquals(6, tank.getHeight());
        assertThrows(IllegalArgumentException.class, () -> tank.setHeight(0));
    }

    @Test
    void getTemperature() {
        assertEquals(25, tank.getTemperature());
    }

    @Test
    void setTemperature() {
        tank.setTemperature(28);
        assertEquals(28, tank.getTemperature());
        assertThrows(IllegalArgumentException.class, () -> tank.setTemperature(31));
    }

    @Test
    void getHeatedEnergyPerDay() {
        assertEquals(8, tank.getHeatedEnergyPerDay());
    }

    @Test
    void setHeatedEnergyPerDay() {
        tank.setHeatedEnergyPerDay(10);
        assertEquals(10, tank.getHeatedEnergyPerDay());
        assertThrows(IllegalArgumentException.class, () -> tank.setHeatedEnergyPerDay(0));
    }

    @Test
    void calculateStoredEnergy() {
        // Expected calculation: volume (in cubic meters) * temperature * specific heat capacity (4.18 kJ/kg·°C)
        double expectedEnergy = tank.calculateVolume() * tank.getTemperature() * 4.18;
        assertEquals(expectedEnergy, tank.calculateStoredEnergy());
    }

    @Test
    void calculateHeatingDays() {
        // Expected calculation: storedEnergy / (heatedEnergyPerDay * 3600)
        double expectedHeatingDays = tank.calculateStoredEnergy() / (tank.getHeatedEnergyPerDay() * 3600);
        assertEquals(expectedHeatingDays, tank.calculateHeatingDays());
    }
}
