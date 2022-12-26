package pt.ulusofona.lp2.deisiJungle.specie;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;

public class TestBird {

    @Test
    public void testGetRecoveryEnergy() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Call the getRecoveryEnergy() method and store the result
        int recoveryEnergy = bird.getRecoveryEnergy();

        // Assert that the returned value is equal to the expected value
        assertEquals(50, recoveryEnergy);
    }

    @Test
    public void testGetEnergyPerCell() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Call the getEnergyPerCell() method and store the result
        int energyPerCell = bird.getEnergyPerCell();

        // Assert that the returned value is equal to the expected value
        assertEquals(4, energyPerCell);
    }

    @Test
    public void testGetTypeOfFood() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Call the getTypeOfFood() method and store the result
        int typeOfFood = bird.getTypeOfFood();

        // Assert that the returned value is equal to the expected value
        assertEquals(3, typeOfFood);
    }

    @Test
    public void testSetMaxSpeed() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Call the setMaxSpeed() method
        bird.setMaxSpeed(10);

        // Assert that the maxVelocity field has been set to the correct value
        assertEquals(10, bird.getMaxVelocity());
    }

    @Test
    public void testSetMinSpeed() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Call the setMinSpeed() method
        bird.setMinSpeed(5);

        // Assert that the minVelocity field has been set to the correct value
        assertEquals(5, bird.getMinVelocity());
    }

    @Test
    public void testGetMaxVelocity() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Set the maxVelocity field
        bird.setMaxSpeed(10);

        // Call the getMaxVelocity() method and store the result
        int maxVelocity = bird.getMaxVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, maxVelocity);
    }

    @Test
    public void testGetMinVelocity() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Set the minVelocity field
        bird.setMinSpeed(5);

        // Call the getMinVelocity() method and store the result
        int minVelocity = bird.getMinVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(5, minVelocity);
    }

    @Test
    public void testSleep() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Create a new Player object
        Player player = new Player();

        // Set the player's current energy to a non-zero value
        player.setCurrentEnergy(50);

        // Call the sleep() method and store the returned Player object
        Player updatedPlayer = bird.sleep(player);

        // Assert that the player's current energy has increased by the recoveryEnergy value
        assertEquals(100, updatedPlayer.getCurrentEnergy());
    }

    @Test
    public void testGetAteBanana() {
        // Create a new Bird object
        Bird bird = new Bird();

        // Set the ateBanana field to a non-zero value
        bird.setAteBanana(1);

        // Call the getAteBanana() method and store the result
        int ateBanana = bird.getAteBanana();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, ateBanana);
    }

}