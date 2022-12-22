package pt.ulusofona.lp2.deisiJungle;

import org.junit.Assert;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.Specie.*;

import static org.junit.Assert.*;


public class TestGameManager {
    GameManager gameManager = new GameManager();
    Player[] playerJogo = new Player[2];



    @Test
    public void testGetSpeciesSize() {
        String[][] species = gameManager.getSpecies();
        assertEquals(5, species.length);
    }

    @Test
    public void testGetSpeciesAllElementValues() {
        String[][] species = gameManager.getSpecies();
        assertArrayEquals(new String[] {"E", "Elefante", "elephant.png", "180", "4", "10", "1..6"}, species[0]);
        assertArrayEquals(new String[] {"L", "Leão", "lion.png", "80", "2", "10", "4..6"}, species[1]);
        assertArrayEquals(new String[] {"P", "Pássaro", "bird.png", "70", "4", "50", "5..6"}, species[2]);
        assertArrayEquals(new String[] {"Z", "Tarzan", "tarzan.png", "70", "2", "20", "1..6"}, species[3]);
        assertArrayEquals(new String[] {"T", "Tartaruga", "turtle.png", "150", "1", "5", "1..3"}, species[4]);
    }

    @Test
    public void testGetFoodTypes() {
        String[][] expected = {
                {"e", "Erva", "grass.png"},
                {"a", "Agua", "water.png"},
                {"b", "Cacho de bananas", "bananas.png"},
                {"c", "Carne", "meat.png"},
                {"m", "Cogumelos magicos", "mushroom.png"}
        };
        String[][] actual = gameManager.getFoodTypes();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCreateInitialJungleSuccess() {
        // Create a sample input for the createInitialJungle method
        int jungleSize = 10;
        String[][] playersInfo = {{"1", "Tarzan", "Z"}, {"2", "Leao", "L"}};
        String[][] foodInfo = {{"u", "4"}, {"c", "9"}};

        // Create an instance of the createInitialJungle class and call the createInitialJungle method
        gameManager.createInitialJungle(jungleSize, playersInfo, foodInfo);
        InitializationError error = gameManager.createInitialJungle(jungleSize, playersInfo);

        // Verify that the output is as expected
        assertNull(error);
        assertEquals(10, gameManager.jungle.length);
        assertEquals(2, gameManager.playersJogo.length);
        assertEquals("Tarzan", gameManager.playersJogo[0].getName());
        assertEquals("Leao", gameManager.playersJogo[1].getName());
        assertTrue(gameManager.playersJogo[0].getSpecie() instanceof Tarzan);
        assertTrue(gameManager.playersJogo[1].getSpecie() instanceof Lion);

    }

    @Test
    public void testCreateInitialJungleInvalidLengthPlayersAndFoods() {
        // Create a sample input for the createInitialJungle method with an invalid number of players
        int jungleSize = 10;
        String[][] playersInfoInvalidNumber = {{"1", "Tarzan", "Z"}};
        String[][] playersIDInvalidNumber = {{"1", "Tarzan", "Z"},{"y","Leao","L"}};
        String[][] playersInfoNull = {{"1", "Tarzan", "Z"},{null, null, null}};
        String[][] playersMoreThenOneTarzan = {{"1", "Tarzan", "Z"},{"2", "Tarzan", "Z"}};
        String[][] playersInvalidSpecie = {{"1", "Tarzan", "Z"},{"2", "Leao", "U"}};
        String[][] playersValid = {{"1", "Tarzan", "Z"},{"2", "Leao", "L"}};
        String[][] foodInfoInvalidPosition = {{"u", "11"}, {"c", "9"}};
        String[][] foodInfoInvalidID = {{"h", "6"}, {"c", "9"}};

        InitializationError errorInvalidPlayers = gameManager.createInitialJungle(jungleSize, playersInfoInvalidNumber);
        InitializationError errorPlayerInfoNull = gameManager.createInitialJungle(jungleSize, playersInfoNull);
        InitializationError errorPlayerIDInvalidNumber = gameManager.createInitialJungle(jungleSize, playersIDInvalidNumber);
        InitializationError errorMoreThenOneTarzan = gameManager.createInitialJungle(jungleSize, playersMoreThenOneTarzan);
        InitializationError errorPlayerInvalidSpecie = gameManager.createInitialJungle(jungleSize, playersInvalidSpecie);
        InitializationError errorInvalidJungleLength = gameManager.createInitialJungle(3, playersValid);
        InitializationError errorFoodInvalidPositioning = gameManager.createInitialJungle(jungleSize, playersValid,foodInfoInvalidPosition);
        InitializationError errorFoodInfoInvalidID = gameManager.createInitialJungle(jungleSize, playersValid,foodInfoInvalidID);


        // Verify that the output is as expected
        assertNotNull(errorInvalidPlayers);
        assertEquals("INVALID NUMBER OF PLAYERS", errorInvalidPlayers.getMessage());
        assertNotNull(errorPlayerInfoNull);
        assertEquals("PLAYERINFO NULL", errorPlayerInfoNull.getMessage());
        assertNotNull(errorPlayerIDInvalidNumber);
        assertEquals("INVAlID PLAYER ID", errorPlayerIDInvalidNumber.getMessage());
        assertNotNull(errorMoreThenOneTarzan);
        assertEquals("MORE THEN ONE TARZAN", errorMoreThenOneTarzan.getMessage());
        assertNotNull(errorPlayerInvalidSpecie);
        assertEquals("INVALID PLAYER SPECIE", errorPlayerInvalidSpecie.getMessage());
        assertNotNull(errorInvalidJungleLength);
        assertEquals("INVALID LENGTH", errorInvalidJungleLength.getMessage());
        assertNotNull(errorFoodInvalidPositioning);
        assertEquals("Invalid Food Positioning", errorFoodInvalidPositioning.getMessage());
        assertNotNull(errorFoodInfoInvalidID);
        assertEquals("Invalid Food ID", errorFoodInfoInvalidID.getMessage());


    }

}