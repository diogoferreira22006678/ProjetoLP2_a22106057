package pt.ulusofona.lp2.deisiJungle.specie;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;

public class TestTurtle {

    @Test
    public void testGetRecoveryEnergy() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Call the getRecoveryEnergy() method and store the result
        int recoveryEnergy = turtle.getRecoveryEnergy();

        // Assert that the returned value is equal to the expected value
        assertEquals(5, recoveryEnergy);
    }

    @Test
    public void testGetEnergyPerCell() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Call the getEnergyPerCell() method and store the result
        int energyPerCell = turtle.getEnergyPerCell();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, energyPerCell);
    }

    @Test
    public void testGetTypeOfFood() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Call the getTypeOfFood() method and store the result
        int typeOfFood = turtle.getTypeOfFood();

        // Assert that the returned value is equal to the expected value
        assertEquals(3, typeOfFood);
    }

    @Test
    public void testSetMaxSpeed() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Call the setMaxSpeed() method
        turtle.setMaxSpeed(10);

        // Assert that the maxVelocity field has been set to the correct value
        assertEquals(10, turtle.getMaxVelocity());
    }

    @Test
    public void testSetMinSpeed() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Call the setMinSpeed() method
        turtle.setMinSpeed(5);

        // Assert that the minVelocity field has been set to the correct value
        assertEquals(5, turtle.getMinVelocity());
    }

    @Test
    public void testGetMaxVelocity() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Set the maxVelocity field
        turtle.setMaxSpeed(10);

        // Call the getMaxVelocity() method and store the result
        int maxVelocity = turtle.getMaxVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(10, maxVelocity);
    }

    @Test
    public void testGetMinVelocity() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Set the minVelocity field
        turtle.setMinSpeed(5);

        // Call the getMinVelocity() method and store the result
        int minVelocity = turtle.getMinVelocity();

        // Assert that the returned value is equal to the expected value
        assertEquals(5, minVelocity);
    }

    @Test
    public void testSleep() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Create a new Player object
        Player player = new Player();

        // Set the player's current energy to a non-zero value
        player.setCurrentEnergy(50);

        // Call the sleep() method and store the returned Player object
        Player updatedPlayer = turtle.sleep(player);

        // Assert that the player's current energy has increased by the recoveryEnergy value
        assertEquals(55, updatedPlayer.getCurrentEnergy());
    }

    @Test
    public void testGetAteBanana() {
        // Create a new Turtle object
        Turtle turtle = new Turtle();

        // Set the ateBanana field to a non-zero value
        turtle.setAteBanana(1);

        // Call the getAteBanana() method and store the result
        int ateBanana = turtle.getAteBanana();

        // Assert that the returned value is equal to the expected value
        assertEquals(1, ateBanana);
    }

}