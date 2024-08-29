package ch.iet_gibb.oecoheat.tests;

import ch.iet_gibb.oecoheat.models.CuboidTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the CuboidTank model class.
 * This class tests the methods of the CuboidTank class.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
class CuboidTankTest {

    private CuboidTank tank;

    @BeforeEach
    void setUp() {
        tank = new CuboidTank("TestCuboidTank", 2, 3, 4, 25, 5);
    }

    @Test
    void getName() {
        assertEquals("TestCuboidTank", tank.getName());
    }

    @Test
    void setName() {
        tank.setName("NewTestCuboidTank");
        assertEquals("NewTestCuboidTank", tank.getName());
    }

    @Test
    void getWidth() {
        assertEquals(2, tank.getWidth());
    }

    @Test
    void setWidth() {
        tank.setWidth(5);
        assertEquals(5, tank.getWidth());
        assertThrows(IllegalArgumentException.class, () -> tank.setWidth(0));
    }

    @Test
    void getHeight() {
        assertEquals(3, tank.getHeight());
    }

    @Test
    void setHeight() {
        tank.setHeight(6);
        assertEquals(6, tank.getHeight());
        assertThrows(IllegalArgumentException.class, () -> tank.setHeight(0));
    }

    @Test
    void getDepth() {
        assertEquals(4, tank.getDepth());
    }

    @Test
    void setDepth() {
        tank.setDepth(7);
        assertEquals(7, tank.getDepth());
        assertThrows(IllegalArgumentException.class, () -> tank.setDepth(0));
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
        assertEquals(5, tank.getHeatedEnergyPerDay());
    }

    @Test
    void setHeatedEnergyPerDay() {
        tank.setHeatedEnergyPerDay(8);
        assertEquals(8, tank.getHeatedEnergyPerDay());
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

    @Test
    void calculateVolume() {
        double expectedVolume = 2 * 3 * 4 * 1000;
        assertEquals(expectedVolume, tank.calculateVolume());
    }
}
