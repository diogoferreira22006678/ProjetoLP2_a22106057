package pt.ulusofona.lp2.deisiJungle.specie;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;

public class TestTarzan {

    @Test
    public void testGetRecoveryEnergy() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Call the getRecoveryEnergy() method and store the result
        int recoveryEnergy = tarzan.getRecoveryEnergy();

        // Assert that the returned value is equal to the expected value
        assertEquals(20, recoveryEnergy);
    }

    @Test
    public void testGetEnergyPerCell() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Call the getEnergyPerCell() method and store the result
        int energyPerCell = tarzan.getEnergyPerCell();

        // Assert that the returned value is equal to the expected value
        assertEquals(2, energyPerCell);
    }

    @Test
    public void testGetTypeOfFood() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Call the getTypeOfFood() method and store the result
        int typeOfFood = tarzan.getTypeOfFood();

        // Assert that the returned value is equal to the expected value
        assertEquals(3, typeOfFood);
    }

    @Test
    public void testSetMaxSpeed() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Call the setMaxSpeed() method
        tarzan.setMaxSpeed(10);

        // Assert that the maxVelocity field has been set to the correct value
        assertEquals(10, tarzan.getMaxVelocity());
    }

    @Test
    public void testSetMinSpeed() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Call the setMinSpeed() method
        tarzan.setMinSpeed(5);

        // Assert that the minVelocity field has been set to the correct value
        assertEquals(5, tarzan.getMinVelocity());
    }

    @Test
    public void testGetMaxVelocity() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Set the maxVelocity field
        tarzan.setMaxSpeed(10);

        // Call the getMaxVelocity() method and store the result
        int maxVelocity = tarzan.getMaxVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, maxVelocity);
    }

    @Test
    public void testGetMinVelocity() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Set the minVelocity field
        tarzan.setMinSpeed(5);

        // Call the getMinVelocity() method and store the result
        int minVelocity = tarzan.getMinVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(5, minVelocity);
    }

    @Test
    public void testSleep() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Create a new Player object
        Player player = new Player();

        // Set the player's current energy to a non-zero value
        player.setCurrentEnergy(50);

        // Call the sleep() method and store the returned Player object
        Player updatedPlayer = tarzan.sleep(player);

        // Assert that the player's current energy has increased by the recoveryEnergy value
        assertEquals(70, updatedPlayer.getCurrentEnergy());
    }

    @Test
    public void testGetAteBanana() {
        // Create a new Tarzan object
        Tarzan tarzan = new Tarzan();

        // Set the ateBanana field to a non-zero value
        tarzan.setAteBanana(1);

        // Call the getAteBanana() method and store the result
        int ateBanana = tarzan.getAteBanana();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, ateBanana);
    }

}