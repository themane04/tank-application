package ch.iet_gibb.oecoheat.tests;

import ch.iet_gibb.oecoheat.models.LiterTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the LiterTank model class.
 * This class tests the methods of the LiterTank class.
 *
 * @author Marjan Tomev
 * @version 1.0
 * @since 08.29.2024
 */
class LiterTankTest {

    private LiterTank tank;

    @BeforeEach
    void setUp() {
        tank = new LiterTank("TestLiterTank", 5000, 25, 8);
    }

    @Test
    void getName() {
        assertEquals("TestLiterTank", tank.getName());
    }

    @Test
    void setName() {
        tank.setName("NewTestLiterTank");
        assertEquals("NewTestLiterTank", tank.getName());
    }

    @Test
    void getVolumeInLiters() {
        assertEquals(5000, tank.getVolumeInLiters());
    }

    @Test
    void setVolumeInLiters() {
        tank.setVolumeInLiters(6000);
        assertEquals(6000, tank.getVolumeInLiters());
        assertThrows(IllegalArgumentException.class, () -> tank.setVolumeInLiters(0));
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
        double expectedEnergy = (tank.getVolumeInLiters() / 1000) * tank.getTemperature() * 4.18;
        assertEquals(expectedEnergy, tank.calculateStoredEnergy());
    }

    @Test
    void calculateHeatingDays() {
        // Expected calculation: storedEnergy / (heatedEnergyPerDay * 3600)
        double expectedHeatingDays = tank.calculateStoredEnergy() / (tank.getHeatedEnergyPerDay() * 3600);
        assertEquals(expectedHeatingDays, tank.calculateHeatingDays());
    }
}
