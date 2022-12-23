package pt.ulusofona.lp2.deisiJungle.food;

import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import static org.junit.Assert.assertEquals;

public class TestWater {

    @Test
    public void testEatFoodTarzan() {
        // Create a Water instance with fixed value
        Water water = new Water("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the water instance
        playerIncrease = water.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 20%
        assertEquals(120, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the water instance
        playerMax = water.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Tarzan());

        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(172, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodLion() {
        // Create a Water instance with fixed value
        Water water = new Water("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Lion());

        // Invoke the eatFood() method on the water instance
        playerIncrease = water.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 15
        assertEquals(115, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Lion());

        // Invoke the eatFood() method on the water instance
        playerMax = water.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Lion());

        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(145, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodBird() {
        // Create a Water instance with fixed value
        Water water = new Water("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Bird());

        // Invoke the eatFood() method on the water instance
        playerIncrease = water.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 15
        assertEquals(115, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Bird());

        // Invoke the eatFood() method on the water instance
        playerMax = water.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Bird());

        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(145, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodElephant() {
        // Create a Water instance with fixed value
        Water water = new Water("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Elephant());

        // Invoke the eatFood() method on the water instance
        playerIncrease = water.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 15
        assertEquals(115, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Elephant());

        // Invoke the eatFood() method on the water instance
        playerMax = water.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Elephant());

        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(145, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodTurtle() {
        // Create a Water instance with fixed value
        Water water = new Water("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Turtle());

        // Invoke the eatFood() method on the water instance
        playerIncrease = water.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 20%
        assertEquals(120, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Turtle());

        // Invoke the eatFood() method on the water instance
        playerMax = water.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Turtle());

        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = water.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(172, playerRepeat.getCurrentEnergy(), 0.01);
    }


}
