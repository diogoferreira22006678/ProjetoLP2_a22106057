package pt.ulusofona.lp2.deisiJungle.food;

import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import static org.junit.Assert.assertEquals;

public class TestWeed {

    @Test
    public void testEatFoodElephant() {
        // Create a Weed instance with fixed value
        Weed weed = new Weed("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Elephant());

        // Invoke the eatFood() method on the weed instance
        playerIncrease = weed.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 20
        assertEquals(120, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Elephant());

        // Invoke the eatFood() method on the water instance
        playerMax = weed.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Elephant());

        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(160, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodTurtle() {
        // Create a Weed instance with fixed value
        Weed weed = new Weed("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Turtle());

        // Invoke the eatFood() method on the weed instance
        playerIncrease = weed.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 20
        assertEquals(120, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Turtle());

        // Invoke the eatFood() method on the water instance
        playerMax = weed.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Turtle());

        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(160, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodTarzan() {
        // Create a Weed instance with fixed value
        Weed weed = new Weed("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the weed instance
        playerIncrease = weed.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 20
        assertEquals(120, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the water instance
        playerMax = weed.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Tarzan());

        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(160, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodLion() {
        // Create a Weed instance with fixed value
        Weed weed = new Weed("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Lion());

        // Invoke the eatFood() method on the weed instance
        playerDecrease = weed.eatFood(playerDecrease, 7, 0);

        // Assert that the player's energy has decreased by 20
        assertEquals(80, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 10
        Player playerZero = new Player(1, "Diogo","L", 10);
        playerZero.setSpecie(new Lion());

        // Invoke the eatFood() method on the water instance
        playerZero = weed.eatFood(playerZero, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(0, playerZero.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Lion());

        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(40, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodBird() {
        // Create a Weed instance with fixed value
        Weed weed = new Weed("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Bird());

        // Invoke the eatFood() method on the weed instance
        playerIncrease = weed.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 20
        assertEquals(120, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Bird());

        // Invoke the eatFood() method on the water instance
        playerMax = weed.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerRepeat = new Player(1, "Diogo","L", 100);
        playerRepeat.setSpecie(new Bird());

        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);
        // Invoke the eatFood() method again
        playerRepeat = weed.eatFood(playerRepeat, 1, 0);

        // Assert that the player's energy has changed
        assertEquals(160, playerRepeat.getCurrentEnergy(), 0.01);
    }
}
