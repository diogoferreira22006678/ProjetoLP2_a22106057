package pt.ulusofona.lp2.deisiJungle.specie;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;

public class TestElephant {

    @Test
    public void testGetRecoveryEnergy() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Call the getRecoveryEnergy() method and store the result
        int recoveryEnergy = elephant.getRecoveryEnergy();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, recoveryEnergy);
    }

    @Test
    public void testGetEnergyPerCell() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Call the getEnergyPerCell() method and store the result
        int energyPerCell = elephant.getEnergyPerCell();

        // Assert that the returned value is equal to the expected value
        assertEquals(4, energyPerCell);
    }

    @Test
    public void testGetTypeOfFood() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Call the getTypeOfFood() method and store the result
        int typeOfFood = elephant.getTypeOfFood();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, typeOfFood);
    }

    @Test
    public void testSetMaxSpeed() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Call the setMaxSpeed() method
        elephant.setMaxSpeed(10);

        // Assert that the maxVelocity field has been set to the correct value
        assertEquals(10, elephant.getMaxVelocity());
    }

    @Test
    public void testSetMinSpeed() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Call the setMinSpeed() method
        elephant.setMinSpeed(5);

        // Assert that the minVelocity field has been set to the correct value
        assertEquals(5, elephant.getMinVelocity());
    }

    @Test
    public void testGetMaxVelocity() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Set the maxVelocity field
        elephant.setMaxSpeed(10);

        // Call the getMaxVelocity() method and store the result
        int maxVelocity = elephant.getMaxVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, maxVelocity);
    }

    @Test
    public void testGetMinVelocity() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Set the minVelocity field
        elephant.setMinSpeed(5);

        // Call the getMinVelocity() method and store the result
        int minVelocity = elephant.getMinVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(5, minVelocity);
    }

    @Test
    public void testSleep() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Create a new Player object
        Player player = new Player();

        // Set the player's current energy to a non-zero value
        player.setCurrentEnergy(50);

        // Call the sleep() method and store the returned Player object
        Player updatedPlayer = elephant.sleep(player);

        // Assert that the player's current energy has increased by the recoveryEnergy value
        assertEquals(60, updatedPlayer.getCurrentEnergy());
    }

    @Test
    public void testGetAteBanana() {
        // Create a new Elephant object
        Elephant elephant = new Elephant();

        // Set the ateBanana field to a non-zero value
        elephant.setAteBanana(1);

        // Call the getAteBanana() method and store the result
        int ateBanana = elephant.getAteBanana();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, ateBanana);
    }

}