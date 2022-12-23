package pt.ulusofona.lp2.deisiJungle.food;

import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import static org.junit.Assert.assertEquals;

public class TestMeat {
    @Test
    public void testEatFoodElephant() {
        // Create a Meat instance
        Meat meat = new Meat("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Elephant());

        // Invoke the eatFood() method on the meat instance
        playerIncrease = meat.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 0%
        assertEquals(100, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Elephant());

        // Invoke the eatFood() method again, this time on expired terms
        playerDecrease = meat.eatFood(playerDecrease, 16, 0);

        // Assert that the player's energy has decreased by 0%
        assertEquals(100, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Elephant());

        // Invoke the eatFood() method on the meat instance
        playerMax = meat.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has not changed
        assertEquals(199, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Elephant());

        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 16, 0);
        // Invoke the eatFood() method again, this time on an valid turn
        playerRepeat = meat.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 13, 0);

        // Assert that the player's energy has not changed
        assertEquals(200, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodBird() {
        // Create a Meat instance
        Meat meat = new Meat("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Bird());

        // Invoke the eatFood() method on the meat instance
        playerIncrease = meat.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 50%
        assertEquals(150, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Bird());

        // Invoke the eatFood() method again, this time on expired terms
        playerDecrease = meat.eatFood(playerDecrease, 16, 0);

        // Assert that the player's energy has decreased by 50%
        assertEquals(50, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Bird());

        // Invoke the eatFood() method on the meat instance
        playerMax = meat.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Bird());

        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 16, 0);
        // Invoke the eatFood() method again, this time on an valid turn
        playerRepeat = meat.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 13, 0);

        // Assert that the player's energy has changed
        assertEquals(75, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodTurtle() {
        // Create a Meat instance
        Meat meat = new Meat("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Turtle());

        // Invoke the eatFood() method on the meat instance
        playerIncrease = meat.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 50
        assertEquals(150, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Turtle());

        // Invoke the eatFood() method again, this time on expired terms
        playerDecrease = meat.eatFood(playerDecrease, 13, 0);

        // Assert that the player's energy has decreased by 50%
        assertEquals(50, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Turtle());

        // Invoke the eatFood() method on the meat instance
        playerMax = meat.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Turtle());

        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 16, 0);
        // Invoke the eatFood() method again, this time on an valid turn
        playerRepeat = meat.eatFood(playerRepeat, 12, 0);
        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 13, 0);

        // Assert that the player's energy has changed
        assertEquals(75, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodLion() {
        // Create a Meat instance
        Meat meat = new Meat("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Lion());

        // Invoke the eatFood() method on the meat instance
        playerIncrease = meat.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 50
        assertEquals(150, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Lion());

        // Invoke the eatFood() method again, this time on expired terms
        playerDecrease = meat.eatFood(playerDecrease, 13, 0);

        // Assert that the player's energy has decreased by 50%
        assertEquals(50, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Lion());

        // Invoke the eatFood() method on the meat instance
        playerMax = meat.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Lion());

        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 16, 0);
        // Invoke the eatFood() method again, this time on an valid turn
        playerRepeat = meat.eatFood(playerRepeat, 12, 0);
        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 13, 0);

        // Assert that the player's energy has changed
        assertEquals(75, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodTarzan() {
        // Create a Meat instance
        Meat meat = new Meat("id", 0, "imageName",  "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the meat instance
        playerIncrease = meat.eatFood(playerIncrease, 7, 0);

        // Assert that the player's energy has increased by 50
        assertEquals(150, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method again, this time on expired terms
        playerDecrease = meat.eatFood(playerDecrease, 13, 0);

        // Assert that the player's energy has decreased by 50%
        assertEquals(50, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the meat instance
        playerMax = meat.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Tarzan());

        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 16, 0);
        // Invoke the eatFood() method again, this time on an valid turn
        playerRepeat = meat.eatFood(playerRepeat, 12, 0);
        // Invoke the eatFood() method again, this time on an expired turn
        playerRepeat = meat.eatFood(playerRepeat, 13, 0);

        // Assert that the player's energy has changed
        assertEquals(75, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testGetToolTip() {
        // Create a Meat instance
        Food meat = new Meat("id", 1, "imageName",  "name");

        // Invoke the getToolTip() method on the meat instance
        String toolTip = meat.getToolTip(3);

        // Assert that the returned tool tip is as expected
        assertEquals("Carne : + 50 energia : 3 jogadas", toolTip);

        // Invoke the getToolTip() method on the meat instance
        toolTip = meat.getToolTip(7);

        // Assert that the returned tool tip is as expected
        assertEquals("Carne : + 50 energia : 7 jogadas", toolTip);

        // Invoke the getToolTip() method on the meat instance
        toolTip = meat.getToolTip(10);

        // Assert that the returned tool tip is as expected
        assertEquals("Carne : + 50 energia : 10 jogadas", toolTip);

        // Invoke the getToolTip() method on the meat instance
        toolTip = meat.getToolTip(12);

        // Assert that the returned tool tip is as expected
        assertEquals("Carne : + 50 energia : 12 jogadas", toolTip);

        // Invoke the getToolTip() method on the meat instance
        toolTip = meat.getToolTip(13);

        // Assert that the returned tool tip is as expected
        assertEquals("Carne toxica", toolTip);

        // Invoke the getToolTip() method on the meat instance
        toolTip = meat.getToolTip(23);

        // Assert that the returned tool tip is as expected
        assertEquals("Carne toxica", toolTip);
    }

}
