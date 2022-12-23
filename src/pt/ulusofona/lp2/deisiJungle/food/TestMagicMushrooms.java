package pt.ulusofona.lp2.deisiJungle.food;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Player;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestMagicMushrooms {

    @Test
    public void testEatFoodTarzan() {
        // Create a MagicMushrooms instance with a fixed random value
        MagicMushrooms mushrooms = new MagicMushrooms("id", 0, "imageName", "name");
        mushrooms.nRandom = 25;
        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the mushrooms instance
        playerIncrease = mushrooms.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 25%
        assertEquals(125, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 66);
        playerDecrease.setSpecie(new Tarzan());

        // Invoke the eatFood() method again, this time on an odd turn
        playerDecrease = mushrooms.eatFood(playerDecrease, 3, 0);

        // Assert that the player's energy has decreased by 25%
        assertEquals(49, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Tarzan());

        // Invoke the eatFood() method on the mushrooms instance
        playerMax = mushrooms.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Tarzan());

        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);

        // Assert that the player's energy has decreased
        assertEquals(84, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodBird() {
        // Create a MagicMushrooms instance with a fixed random value
        MagicMushrooms mushrooms = new MagicMushrooms("id", 0, "imageName", "name");
        mushrooms.nRandom = 25;
        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Bird());

        // Invoke the eatFood() method on the mushrooms instance
        playerIncrease = mushrooms.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 25%
        assertEquals(125, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 66);
        playerDecrease.setSpecie(new Bird());

        // Invoke the eatFood() method again, this time on an odd turn
        playerDecrease = mushrooms.eatFood(playerDecrease, 3, 0);

        // Assert that the player's energy has decreased by 25%
        assertEquals(49, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Bird());

        // Invoke the eatFood() method on the mushrooms instance
        playerMax = mushrooms.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Bird());

        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);

        // Assert that the player's energy has decreased
        assertEquals(84, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodLion() {
        // Create a MagicMushrooms instance with a fixed random value
        MagicMushrooms mushrooms = new MagicMushrooms("id", 0, "imageName", "name");
        mushrooms.nRandom = 25;
        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Lion());

        // Invoke the eatFood() method on the mushrooms instance
        playerIncrease = mushrooms.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 25%
        assertEquals(125, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 66
        Player playerDecrease = new Player(1, "Diogo","L", 66);
        playerDecrease.setSpecie(new Lion());

        // Invoke the eatFood() method again, this time on an odd turn
        playerDecrease = mushrooms.eatFood(playerDecrease, 3, 0);

        // Assert that the player's energy has decreased by 25%
        assertEquals(49, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Lion());

        // Invoke the eatFood() method on the mushrooms instance
        playerMax = mushrooms.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Lion());

        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);

        // Assert that the player's energy has decreased
        assertEquals(84, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodElephant() {
        // Create a MagicMushrooms instance with a fixed random value
        MagicMushrooms mushrooms = new MagicMushrooms("id", 0, "imageName", "name");
        mushrooms.nRandom = 25;
        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Elephant());

        // Invoke the eatFood() method on the mushrooms instance
        playerIncrease = mushrooms.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 25%
        assertEquals(125, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 66);
        playerDecrease.setSpecie(new Elephant());

        // Invoke the eatFood() method again, this time on an odd turn
        playerDecrease = mushrooms.eatFood(playerDecrease, 3, 0);

        // Assert that the player's energy has decreased by 25%
        assertEquals(49, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Elephant());

        // Invoke the eatFood() method on the mushrooms instance
        playerMax = mushrooms.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Elephant());

        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);

        // Assert that the player's energy has decreased
        assertEquals(84, playerRepeat.getCurrentEnergy(), 0.01);
    }

    @Test
    public void testEatFoodTurtle() {
        // Create a MagicMushrooms instance with a fixed random value
        MagicMushrooms mushrooms = new MagicMushrooms("id", 0, "imageName", "name");
        mushrooms.nRandom = 25;
        // Create a player instance with an initial energy of 100
        Player playerIncrease = new Player(1, "Diogo","L", 100);
        playerIncrease.setSpecie(new Turtle());

        // Invoke the eatFood() method on the mushrooms instance
        playerIncrease = mushrooms.eatFood(playerIncrease, 0, 0);

        // Assert that the player's energy has increased by 25%
        assertEquals(125, playerIncrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 100
        Player playerDecrease = new Player(1, "Diogo","L", 66);
        playerDecrease.setSpecie(new Turtle());

        // Invoke the eatFood() method again, this time on an odd turn
        playerDecrease = mushrooms.eatFood(playerDecrease, 3, 0);

        // Assert that the player's energy has decreased by 25%
        assertEquals(49, playerDecrease.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 199
        Player playerMax = new Player(1, "Diogo","L", 199);
        playerMax.setSpecie(new Turtle());

        // Invoke the eatFood() method on the mushrooms instance
        playerMax = mushrooms.eatFood(playerMax, 0, 0);

        // Assert that the player's energy has capped
        assertEquals(200, playerMax.getCurrentEnergy(), 0.01);

        // Create a player instance with an initial energy of 200
        Player playerRepeat = new Player(1, "Diogo","L", 200);
        playerRepeat.setSpecie(new Turtle());

        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);
        // Invoke the eatFood() method again, this time on an odd turn
        playerRepeat = mushrooms.eatFood(playerRepeat, 3, 0);

        // Assert that the player's energy has decreased
        assertEquals(84, playerRepeat.getCurrentEnergy(), 0.01);
    }


    @Test
    public void testRandomGetToolTip() {
        // Create a MagicMushrooms instance with a fixed random value
        Food mushrooms = new MagicMushrooms("id", 1, "imageName", "name");

        // Invoke the getToolTip() method on the mushrooms instance
        String toolTip = mushrooms.getToolTip(1);

        // Assert that the returned tool tip is as expected
        assertNotEquals("Cogumelo Magico: +- 25% energia", toolTip);
    }
}





