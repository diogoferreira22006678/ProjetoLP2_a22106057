package pt.ulusofona.lp2.deisiJungle.food;

import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import static org.junit.Assert.assertEquals;

public class TestBananas {
    @Test
    public void testEatFoodTarzan() {

        // Create Bananas instances with a fixed value
        Bananas bananasZeroQuantity = new Bananas("id", 0, "imageName", 0, "name");
        Bananas bananasIncrease = new Bananas("id", 0, "imageName", 3, "name");
        Bananas bananasDecrease = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasZero = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasMax = new Bananas("id", 1, "imageName", 3, "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the bananas instance
        playerIncrease = bananasIncrease.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 40
        assertEquals(140, playerIncrease.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasIncrease.quantity);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Tarzan());

        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);
        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);

        // Assert that the player's energy has stayed at 100
        assertEquals(100, playerDecrease.getCurrentEnergy(), 0.01);
        assertEquals(1, bananasDecrease.quantity);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the banana instance
        playerMax = bananasMax.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasMax.quantity);

        // Create a player instance with an initial energy of 0
        Player playerZero = new Player(1, "Diogo","L", 0);
        playerZero.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the banana instance
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(0, playerZero.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZero.quantity);

        // Create a player instance with an initial energy of 100
        Player playerZeroQuantity = new Player(1, "Diogo","L", 100);
        playerZeroQuantity.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the banana instance
        playerZeroQuantity = bananasZeroQuantity.eatFood(playerZeroQuantity, 0, 0);

        // Assert that the player's energy has not changed
        assertEquals(100, playerZeroQuantity.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZeroQuantity.quantity);
    }

    @Test
    public void testEatFoodBird() {
        // Create Bananas instances with a fixed value
        Bananas bananasZeroQuantity = new Bananas("id", 0, "imageName", 0, "name");
        Bananas bananasIncrease = new Bananas("id", 0, "imageName", 3, "name");
        Bananas bananasDecrease = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasZero = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasMax = new Bananas("id", 1, "imageName", 3, "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Bird());

        // Invoke the eatFood() method on the bananas instance
        playerIncrease = bananasIncrease.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 40
        assertEquals(140, playerIncrease.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasIncrease.quantity);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Bird());

        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);
        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);

        // Assert that the player's energy has stayed at 100
        assertEquals(100, playerDecrease.getCurrentEnergy(), 0.01);
        assertEquals(1, bananasDecrease.quantity);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Bird());

        // Invoke the eatFood() method on the banana instance
        playerMax = bananasMax.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasMax.quantity);

        // Create a player instance with an initial energy of 0
        Player playerZero = new Player(1, "Diogo","L", 0);
        playerZero.setSpecie(new Bird());

        // Invoke the eatFood() method on the banana instance
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(0, playerZero.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZero.quantity);

        // Create a player instance with an initial energy of 100
        Player playerZeroQuantity = new Player(1, "Diogo","L", 100);
        playerZeroQuantity.setSpecie(new Bird());

        // Invoke the eatFood() method on the banana instance
        playerZeroQuantity = bananasZeroQuantity.eatFood(playerZeroQuantity, 0, 0);

        // Assert that the player's energy has not changed
        assertEquals(100, playerZeroQuantity.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZeroQuantity.quantity);
    }

    @Test
    public void testEatFoodLion() {
        // Create Bananas instances with a fixed value
        Bananas bananasZeroQuantity = new Bananas("id", 0, "imageName", 0, "name");
        Bananas bananasIncrease = new Bananas("id", 0, "imageName", 3, "name");
        Bananas bananasDecrease = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasZero = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasMax = new Bananas("id", 1, "imageName", 3, "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Lion());

        // Invoke the eatFood() method on the bananas instance
        playerIncrease = bananasIncrease.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 40
        assertEquals(140, playerIncrease.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasIncrease.quantity);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Lion());

        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);
        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);

        // Assert that the player's energy has stayed at 100
        assertEquals(180, playerDecrease.getCurrentEnergy(), 0.01);
        assertEquals(1, bananasDecrease.quantity);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Lion());

        // Invoke the eatFood() method on the banana instance
        playerMax = bananasMax.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasMax.quantity);

        // Create a player instance with an initial energy of 0
        Player playerZero = new Player(1, "Diogo","L", 0);
        playerZero.setSpecie(new Lion());

        // Invoke the eatFood() method on the banana instance
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(120, playerZero.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZero.quantity);

        // Create a player instance with an initial energy of 100
        Player playerZeroQuantity = new Player(1, "Diogo","L", 100);
        playerZeroQuantity.setSpecie(new Lion());

        // Invoke the eatFood() method on the banana instance
        playerZeroQuantity = bananasZeroQuantity.eatFood(playerZeroQuantity, 0, 0);

        // Assert that the player's energy has not changed
        assertEquals(100, playerZeroQuantity.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZeroQuantity.quantity);
    }

    @Test
    public void testEatFoodElephant() {
        // Create Bananas instances with a fixed value
        Bananas bananasZeroQuantity = new Bananas("id", 0, "imageName", 0, "name");
        Bananas bananasIncrease = new Bananas("id", 0, "imageName", 3, "name");
        Bananas bananasDecrease = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasZero = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasMax = new Bananas("id", 1, "imageName", 3, "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Elephant());

        // Invoke the eatFood() method on the bananas instance
        playerIncrease = bananasIncrease.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 40
        assertEquals(140, playerIncrease.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasIncrease.quantity);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Elephant());

        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);
        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);

        // Assert that the player's energy has stayed at 100
        assertEquals(100, playerDecrease.getCurrentEnergy(), 0.01);
        assertEquals(1, bananasDecrease.quantity);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Elephant());

        // Invoke the eatFood() method on the banana instance
        playerMax = bananasMax.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasMax.quantity);

        // Create a player instance with an initial energy of 0
        Player playerZero = new Player(1, "Diogo","L", 0);
        playerZero.setSpecie(new Elephant());

        // Invoke the eatFood() method on the banana instance
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(0, playerZero.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZero.quantity);

        // Create a player instance with an initial energy of 100
        Player playerZeroQuantity = new Player(1, "Diogo","L", 100);
        playerZeroQuantity.setSpecie(new Elephant());

        // Invoke the eatFood() method on the banana instance
        playerZeroQuantity = bananasZeroQuantity.eatFood(playerZeroQuantity, 0, 0);

        // Assert that the player's energy has not changed
        assertEquals(100, playerZeroQuantity.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZeroQuantity.quantity);
    }

    @Test
    public void testEatFoodTurtle() {
        // Create Bananas instances with a fixed value
        Bananas bananasZeroQuantity = new Bananas("id", 0, "imageName", 0, "name");
        Bananas bananasIncrease = new Bananas("id", 0, "imageName", 3, "name");
        Bananas bananasDecrease = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasZero = new Bananas("id", 1, "imageName", 3, "name");
        Bananas bananasMax = new Bananas("id", 1, "imageName", 3, "name");

        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Turtle());

        // Invoke the eatFood() method on the bananas instance
        playerIncrease = bananasIncrease.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 40
        assertEquals(140, playerIncrease.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasIncrease.quantity);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 100);
        playerDecrease.setSpecie(new Turtle());

        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);
        playerDecrease = bananasDecrease.eatFood(playerDecrease, 3, 1);

        // Assert that the player's energy has stayed at 100
        assertEquals(100, playerDecrease.getCurrentEnergy(), 0.01);
        assertEquals(1, bananasDecrease.quantity);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Turtle());

        // Invoke the eatFood() method on the banana instance
        playerMax = bananasMax.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);
        assertEquals(2, bananasMax.quantity);

        // Create a player instance with an initial energy of 0
        Player playerZero = new Player(1, "Diogo","L", 0);
        playerZero.setSpecie(new Turtle());

        // Invoke the eatFood() method on the banana instance
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);
        playerZero = bananasZero.eatFood(playerZero, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(0, playerZero.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZero.quantity);

        // Create a player instance with an initial energy of 100
        Player playerZeroQuantity = new Player(1, "Diogo","L", 100);
        playerZeroQuantity.setSpecie(new Turtle());

        // Invoke the eatFood() method on the banana instance
        playerZeroQuantity = bananasZeroQuantity.eatFood(playerZeroQuantity, 0, 0);

        // Assert that the player's energy has not changed
        assertEquals(100, playerZeroQuantity.getCurrentEnergy(), 0.01);
        assertEquals(0, bananasZeroQuantity.quantity);
    }

    @Test
    public void testRandomGetToolTip() {
        // Create Bananas instances with a fixed value
        Food bananas = new Bananas("id", 1, "imageName", 3, "name");
        Player player = new Player(1, "Diogo","L", 100);
        player.setSpecie(new Lion());
        String toolTip = bananas.getToolTip(1);

        // Assert that the returned tool tip is as expected
        assertEquals("Bananas : 3 : + 40 energia", toolTip);

        // Assert that the returned tool tip is as expected in quantity defice
        bananas.eatFood(player,1,0);
        // Assert that the returned tool tip is as expected
        toolTip = bananas.getToolTip(1);
        assertEquals("Bananas : 2 : + 40 energia", toolTip);
        bananas.eatFood(player,1,0);
        // Assert that the returned tool tip is as expected
        toolTip = bananas.getToolTip(1);
        assertEquals("Bananas : 1 : + 40 energia", toolTip);
        bananas.eatFood(player,1,0);
        // Assert that the returned tool tip is as expected
        toolTip = bananas.getToolTip(1);
        assertEquals("Bananas : 0 : + 40 energia", toolTip);
        bananas.eatFood(player,0,0);
        // Assert that the returned tool tip is as expected
        toolTip = bananas.getToolTip(1);
        assertEquals("Bananas : 0 : + 40 energia", toolTip);


    }
}
