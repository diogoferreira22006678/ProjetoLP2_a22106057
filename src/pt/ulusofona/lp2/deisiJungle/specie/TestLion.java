package pt.ulusofona.lp2.deisiJungle.specie;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;

public class TestLion {

    @Test
    public void testGetRecoveryEnergy() {
        // Create a new Turtle object
        Lion lion = new Lion();

        // Call the getRecoveryEnergy() method and store the result
        int recoveryEnergy = lion.getRecoveryEnergy();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, recoveryEnergy);
    }

    @Test
    public void testGetEnergyPerCell() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Call the getEnergyPerCell() method and store the result
        int energyPerCell = lion.getEnergyPerCell();

        // Assert that the returned value is equal to the expected value
        assertEquals(2, energyPerCell);
    }

    @Test
    public void testGetTypeOfFood() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Call the getTypeOfFood() method and store the result
        int typeOfFood = lion.getTypeOfFood();

        // Assert that the returned value is equal to the expected value
        assertEquals(2, typeOfFood);
    }

    @Test
    public void testSetMaxSpeed() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Call the setMaxSpeed() method
        lion.setMaxSpeed(10);

        // Assert that the maxVelocity field has been set to the correct value
        assertEquals(10, lion.getMaxVelocity());
    }

    @Test
    public void testSetMinSpeed() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Call the setMinSpeed() method
        lion.setMinSpeed(5);

        // Assert that the minVelocity field has been set to the correct value
        assertEquals(5, lion.getMinVelocity());
    }

    @Test
    public void testGetMaxVelocity() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Set the maxVelocity field
        lion.setMaxSpeed(10);

        // Call the getMaxVelocity() method and store the result
        int maxVelocity = lion.getMaxVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, maxVelocity);
    }

    @Test
    public void testGetMinVelocity() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Set the minVelocity field
        lion.setMinSpeed(5);

        // Call the getMinVelocity() method and store the result
        int minVelocity = lion.getMinVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(5, minVelocity);
    }

    @Test
    public void testSleep() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Create a new Player object
        Player player = new Player();

        // Set the player's current energy to a non-zero value
        player.setCurrentEnergy(50);

        // Call the sleep() method and store the returned Player object
        Player updatedPlayer = lion.sleep(player);

        // Assert that the player's current energy has increased by the recoveryEnergy value
        assertEquals(60, updatedPlayer.getCurrentEnergy());
    }

    @Test
    public void testGetAteBanana() {
        // Create a new Lion object
        Lion lion = new Lion();

        // Set the ateBanana field to a non-zero value
        lion.setAteBanana(1);

        // Call the getAteBanana() method and store the result
        int ateBanana = lion.getAteBanana();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, ateBanana);
    }

}