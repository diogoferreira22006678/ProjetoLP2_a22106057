package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.food.Bananas;
import pt.ulusofona.lp2.deisiJungle.food.Food;
import pt.ulusofona.lp2.deisiJungle.food.Meat;
import pt.ulusofona.lp2.deisiJungle.food.Water;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestGameManager {
    GameManager gameManager = new GameManager();

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
    public void testCreateInitialJungleSuccess() throws InvalidInitialJungleException {
        // Create a sample input for the createInitialJungle method

    }

    @Test
    public void testCreateInitialJungleInvalidLengthPlayersAndFoods() {
    }

    @Test
    public void playFromEnunciado() throws InvalidInitialJungleException {
        Board board = new Board();
        board = board.createBoard(10);
        Food water = new Water("u",0,"Image","Name");
        Player tarzanTest = new Player(1, "Joao", "Z", 70, 0, 1, "Tarzan", 0, 0);
        tarzanTest.setSpecie(new Tarzan());
        Player tarzanTestSerious = new Player(1, "Joao", "Z", 70, 0, 1, "Tarzan", 0, 0);
        tarzanTest.setSpecie(new Tarzan());
        Player lionTest = new Player(1, "Diogo", "L", 80, 0, 1, "Tarzan", 0, 0);
        lionTest.setSpecie(new Lion());
        Player lionTestSerious = new Player(1, "Diogo", "L", 80, 0, 1, "Tarzan", 0, 0);
        lionTest.setSpecie(new Lion());

        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        String[][] foodInfo = {{"a","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);

        tarzanTest = tarzanTest.move(3,tarzanTest);
        water.eatFood(tarzanTest,1,3);
        assertEquals(76,tarzanTest.getCurrentEnergy());

        lionTest = lionTest.move(5,lionTest);
        assertEquals(70,lionTest.getCurrentEnergy());

        tarzanTest = tarzanTest.specie.sleep(tarzanTest);
        water.eatFood(tarzanTest,3,3);
        assertEquals(115,tarzanTest.getCurrentEnergy());

        lionTest.move(4,lionTest);
        assertEquals(62,lionTest.getCurrentEnergy());


        MovementResult resultFirstPlay = gameManager.moveCurrentPlayer(3,false);
        assertEquals("VALID_MOVEMENT",resultFirstPlay.code().toString());

        MovementResult resultSecondPlay = gameManager.moveCurrentPlayer(5,false);
        assertEquals("VALID_MOVEMENT",resultSecondPlay.code().toString());

        MovementResult resultThirdPlay = gameManager.moveCurrentPlayer(0,false);
        assertEquals("VALID_MOVEMENT",resultThirdPlay.code().toString());

        MovementResult resultFourthPlay = gameManager.moveCurrentPlayer(4,false);
        assertEquals("VALID_MOVEMENT",resultFourthPlay.code().toString());
        assertEquals(2,Integer.parseInt(gameManager.getWinnerInfo()[0]));
    }

    @Test
    public void playerEatsSpoiledMeat() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        String[][] foodInfo = {{"c","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);

        gameManager.moveCurrentPlayer(0,false); //1
        gameManager.moveCurrentPlayer(0,false); //2
        gameManager.moveCurrentPlayer(0,false); //3
        gameManager.moveCurrentPlayer(0,false); //4
        gameManager.moveCurrentPlayer(0,false); //5
        gameManager.moveCurrentPlayer(0,false); //6
        gameManager.moveCurrentPlayer(0,false); //7
        gameManager.moveCurrentPlayer(0,false); //8
        gameManager.moveCurrentPlayer(0,false); //9
        gameManager.moveCurrentPlayer(0,false); //10
        gameManager.moveCurrentPlayer(2,false); //11
        gameManager.moveCurrentPlayer(0,false); //12

        MovementResult resultSpoiled = gameManager.moveCurrentPlayer(0,false); //13
        String[] infoPlayer1 = gameManager.getPlayerInfo(1);
        String[] infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("CAUGHT_FOOD",resultSpoiled.code().toString());
        assertEquals("100",infoPlayer1[3]);
        assertEquals("140",infoPlayer2[3]);
    }

    @Test
    public void playerEatsTestMultipleBananas() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        String[][] foodInfo = {{"b","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);

        gameManager.moveCurrentPlayer(0,false); //1
        gameManager.moveCurrentPlayer(0,false); //2
        gameManager.moveCurrentPlayer(0,false); //3
        gameManager.moveCurrentPlayer(0,false); //4
        gameManager.moveCurrentPlayer(0,false); //5
        gameManager.moveCurrentPlayer(0,false); //6
        gameManager.moveCurrentPlayer(0,false); //7
        gameManager.moveCurrentPlayer(0,false); //8
        gameManager.moveCurrentPlayer(0,false); //9
        gameManager.moveCurrentPlayer(0,false); //10

        MovementResult firstBanana = gameManager.moveCurrentPlayer(2,false); //11
        String[] infoPlayer1 = gameManager.getPlayerInfo(1);
        String[] infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("200",infoPlayer1[3]);
        assertEquals("130",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false); //12
        MovementResult secondBanana = gameManager.moveCurrentPlayer(0,false); //13
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("160",infoPlayer1[3]);
        assertEquals("140",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false);
        MovementResult thirdBanana = gameManager.moveCurrentPlayer(0,false); //14
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("140",infoPlayer1[3]);
        assertEquals("150",infoPlayer2[3]);
    }

    @Test
    public void playerEatsTestMultipleBananasSamePlace() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        String[][] foodInfo = {{"b","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);

        gameManager.moveCurrentPlayer(2,false); //1
        gameManager.moveCurrentPlayer(0,false); //2
        String[] infoPlayer1 = gameManager.getPlayerInfo(1);
        String[] infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("106",infoPlayer1[3]);
        assertEquals("90",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false); //3
        gameManager.moveCurrentPlayer(0,false); //4
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("86",infoPlayer1[3]);
        assertEquals("100",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false); //5
        gameManager.moveCurrentPlayer(0,false); //6
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("66",infoPlayer1[3]);
        assertEquals("110",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false); //7
        gameManager.moveCurrentPlayer(0,false); //8
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("86",infoPlayer1[3]);
        assertEquals("120",infoPlayer2[3]);

    }

    @Test
    public void playerEatsTestMultipleBananasBackwards() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        String[][] foodInfo = {{"b","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);

        gameManager.moveCurrentPlayer(2,false); //1
        gameManager.moveCurrentPlayer(0,false); //2
        String[] infoPlayer1 = gameManager.getPlayerInfo(1);
        String[] infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("106",infoPlayer1[3]);
        assertEquals("90",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false); //3
        gameManager.moveCurrentPlayer(0,false); //4
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("86",infoPlayer1[3]);
        assertEquals("100",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(2,false); //5
        gameManager.moveCurrentPlayer(0,false); //6
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("82",infoPlayer1[3]);
        assertEquals("110",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(-2,false); //7
        gameManager.moveCurrentPlayer(0,false); //8
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("38",infoPlayer1[3]);
        assertEquals("120",infoPlayer2[3]);

    }

    @Test
    public void playerEatsTestMultipleBananasFoward() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        String[][] foodInfo = {{"b","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);
        gameManager.moveCurrentPlayer(2,false); //1
        gameManager.moveCurrentPlayer(0,false); //2
        String[] infoPlayer1 = gameManager.getPlayerInfo(1);
        String[] infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("106",infoPlayer1[3]);
        assertEquals("90",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(-2,false); //3
        gameManager.moveCurrentPlayer(0,false); //4
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("102",infoPlayer1[3]);
        assertEquals("100",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(2,false); //5
        gameManager.moveCurrentPlayer(0,false); //6
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("58",infoPlayer1[3]);
        assertEquals("110",infoPlayer2[3]);
        gameManager.moveCurrentPlayer(0,false); //7
        gameManager.moveCurrentPlayer(0,false); //8
        infoPlayer1 = gameManager.getPlayerInfo(1);
        infoPlayer2 = gameManager.getPlayerInfo(2);
        assertEquals("38",infoPlayer1[3]);
        assertEquals("120",infoPlayer2[3]);

    }

    @Test
    public void playerTestOverrideSpeed() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"},{"3","Daniela","P"},{"4","Jonas","E"}};
        String[][] foodInfo = {{"b","3"}};

        gameManager.createInitialJungle(10,playerInfo,foodInfo);

        assertEquals(gameManager.playersJogo[0].getSpecie().getMinVelocity() + " " + gameManager.playersJogo[0].getSpecie().getMaxVelocity(),"1 6");
        assertEquals(gameManager.playersJogo[1].getSpecie().getMinVelocity() + " " + gameManager.playersJogo[1].getSpecie().getMaxVelocity(),"4 6");
        assertEquals(gameManager.playersJogo[2].getSpecie().getMinVelocity() + " " + gameManager.playersJogo[2].getSpecie().getMaxVelocity(),"5 6");
        assertEquals(gameManager.playersJogo[3].getSpecie().getMinVelocity() + " " + gameManager.playersJogo[3].getSpecie().getMaxVelocity(),"1 6");

        gameManager.moveCurrentPlayer(-2,false);
        gameManager.getPlayerIds(3);
        MovementResult result = gameManager.moveCurrentPlayer(2,false);

        assertEquals("INVALID_MOVEMENT",result.code().toString());
    }

    @Test
    public void testWinnerInfoNoEnergy() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","P"},{"2","Joao","P"}};


        gameManager.createInitialJungle(40,playerInfo);

        gameManager.moveCurrentPlayer(5,false); //1
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //2
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //3
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //4
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //5
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //6
        MovementResult result = gameManager.moveCurrentPlayer(5,false); //7
        assertEquals("NO_ENERGY",result.code().toString());
        assertNull(gameManager.getWinnerInfo());
        result = gameManager.moveCurrentPlayer(5,false); //8
        assertEquals("NO_ENERGY",result.code().toString());
        assertNull(gameManager.getWinnerInfo());

    }

    @Test
    public void testWinnerInfoHalfBoard() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","P"},{"2","Joao","P"}};


        gameManager.createInitialJungle(30,playerInfo);

        gameManager.moveCurrentPlayer(5,false); //1
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(0,false); //2
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //3
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(0,false); //4
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(6,false); //5
        System.out.println(gameManager.playersJogo[0].getCurrentHouse() + " " +gameManager.playersJogo[1].getCurrentHouse());
        assertNotNull(gameManager.getWinnerInfo());

    }

    @Test
    public void testWinnerInfoHalfBoardOdd() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","E"},{"2","Joao","E"}};


        gameManager.createInitialJungle(29,playerInfo);

        gameManager.moveCurrentPlayer(5,false); //1
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(0,false); //2
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //3
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(0,false); //4
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //5
        System.out.println(gameManager.playersJogo[0].getCurrentHouse() + " " +gameManager.playersJogo[1].getCurrentHouse());
        assertNotNull(gameManager.getWinnerInfo());

    }

    @Test
    public void testWinnerInfoFinalBoard() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","E"},{"2","Joao","E"}};


        gameManager.createInitialJungle(10,playerInfo);

        gameManager.moveCurrentPlayer(5,false); //1
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(6,false); //2
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(4,false); //3
        System.out.println(gameManager.playersJogo[0].getCurrentHouse() + " " +gameManager.playersJogo[1].getCurrentHouse());
        System.out.println(gameManager.jungle.length);
        assertNotNull(gameManager.getWinnerInfo());
    }

    @Test
    public void testWinnerInfoFinalBoardOdd() throws InvalidInitialJungleException {
        String[][] playerInfo = {{"1","Diogo","E"},{"2","Joao","E"}};


        gameManager.createInitialJungle(11,playerInfo);

        gameManager.moveCurrentPlayer(5,false); //1
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(6,false); //2
        assertNull(gameManager.getWinnerInfo());
        gameManager.moveCurrentPlayer(5,false); //3
        System.out.println(gameManager.playersJogo[0].getCurrentHouse() + " " +gameManager.playersJogo[1].getCurrentHouse());
        System.out.println(gameManager.jungle.length);
        assertNotNull(gameManager.getWinnerInfo());
    }

    @Test
    public void testCreateFood() throws InvalidInitialJungleException {

        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};

        gameManager.createInitialJungle(10,playerInfo);
        // Set up the input for the createFood method

        String[][] foodInfo = {
                {"e", "1"},
                {"a", "2"},
                {"b", "3"},
                {"c", "4"},
                {"m", "5"}
        };

        // Create a new Game object and call the createFood method


        gameManager.createFood(foodInfo);
        // Verify that the food was created and added to the game correctly
        assertEquals("e", gameManager.jungle.arrayCells[0].cellInformationFood.getId());
        assertEquals("a", gameManager.jungle.arrayCells[1].cellInformationFood.getId());
        assertEquals("b", gameManager.jungle.arrayCells[2].cellInformationFood.getId());
        assertEquals("c", gameManager.jungle.arrayCells[3].cellInformationFood.getId());
        assertEquals("m", gameManager.jungle.arrayCells[4].cellInformationFood.getId());
    }

    @Test
    public void testGetPlayerIds() throws InvalidInitialJungleException {
        // Set up the input for the getPlayerIds method
        int squareNr = 1;
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        // Create a new Game object and add some players to the first square
        GameManager game = new GameManager();
        game.createInitialJungle(10, playerInfo);
        game.jungle.arrayCells[0].cellInformationPlayer.add(new Player(3, "Player 3", "Z", 100, 0, 1, "Tarzan", 0, 0));
        game.jungle.arrayCells[0].cellInformationPlayer.add(new Player(4, "Player 4", "E", 100, 0, 1, "Elephant", 0, 0));
        game.jungle.arrayCells[0].cellInformationPlayer.add(new Player(5, "Player 5", "L", 100, 0, 1, "Lion", 0, 0));

        // Call the getPlayerIds method and verify that the correct IDs are returned
        int[] playerIds = game.getPlayerIds(squareNr);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, playerIds);
    }

    @Test
    public void testGetSquareInfo() throws InvalidInitialJungleException {

        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        // Create a new Game object and add some players to the first square
        GameManager game = new GameManager();
        game.createInitialJungle(10, playerInfo);
        game.jungle.arrayCells[0].cellInformationPlayer.add(new Player(3, "Player 3", "Z", 100, 0, 1, "Tarzan", 0, 0));
        game.jungle.arrayCells[0].cellInformationPlayer.add(new Player(4, "Player 4", "E", 100, 0, 1, "Elephant", 0, 0));
        game.jungle.arrayCells[0].cellInformationPlayer.add(new Player(5, "Player 5", "L", 100, 0, 1, "Lion", 0, 0));
        game.jungle.arrayCells[0].cellInformationFood = new Bananas("b", 3, "bananas.png", 3, "Bananas");

        // Call the getSquareInfo method and verify that the correct information is returned
        String[] squareInfo = game.getSquareInfo(3);
        String[] squareInfoStart = game.getSquareInfo(1);
        String[] squareInfoFinish = game.getSquareInfo(10);
        assertArrayEquals(new String[] {"blank.png", "Vazio", ""}, squareInfo);
        assertArrayEquals(new String[] {"finish.png", "Meta", ""}, squareInfoFinish);
        assertArrayEquals(new String[] {"bananas.png", "Bananas : 3 : + 40 energia", "1,2,3,4,5"}, squareInfoStart);

    }

    @Test
    public void testGetPlayerInfo() {
        // Set up the input for the getPlayerInfo method
        int playerId = 1;

        // Create a new Game object and add a player with the given ID
        GameManager game = new GameManager();
        game.playersJogo = new Player[] {new Player(1, "Player 1", "Z", 100, 0, 1, "Tarzan", 0, 0)};
        game.playersJogo[0].setSpecie(new Tarzan());
        game.playersJogo[0].getSpecie().setMinSpeed(1);
        game.playersJogo[0].getSpecie().setMaxSpeed(6);

        // Call the getPlayerInfo method and verify that the correct information is returned
        String[] playerInfo = game.getPlayerInfo(playerId);
        assertArrayEquals(new String[] {"1", "Player 1", "Z", "100", "1..6"}, playerInfo);
    }

    @Test
    public void testGetCurrentPlayerInfo() {
        // Set up the input for the getCurrentPlayerInfo method
        int playerId = 1;

        // Create a new Game object and add a player with the given ID and set its turn to 1
        GameManager game = new GameManager();
        Player player = new Player(1, "Player 1", "Z", 100, 0, 1, "Tarzan", 0, 0);
        player.setTurn(1);
        game.playersJogo = new Player[] {player};
        game.playersJogo[0].setSpecie(new Tarzan());
        game.playersJogo[0].getSpecie().setMinSpeed(1);
        game.playersJogo[0].getSpecie().setMaxSpeed(6);

        // Call the getCurrentPlayerInfo method and verify that the correct information is returned
        String[] playerInfo = game.getCurrentPlayerInfo();
        assertArrayEquals(new String[] {"1", "Player 1", "Z", "100", "1..6"}, playerInfo);
    }

    @Test
    public void testGetCurrentPlayerEnergyInfo() {
        // Set up the input for the getCurrentPlayerEnergyInfo method
        int nrPositions = 2;

        // Create a new Game object and add a player with the given ID and set its turn to 1
        GameManager game = new GameManager();
        Player player = new Player(1, "Player 1", "Z", 100, 0, 1, "Tarzan", 0, 0);
        player.setTurn(1);
        player.setSpecie(new Tarzan());
        game.playersJogo = new Player[] {player};

        // Call the getCurrentPlayerEnergyInfo method and verify that the correct information is returned
        String[] playerInfo = game.getCurrentPlayerEnergyInfo(nrPositions);
        assertArrayEquals(new String[] {"4", "20"}, playerInfo);
    }

    @Test
    public void testGetPlayersInfo() throws InvalidInitialJungleException {
        // Create a new Board object and add some players to it
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        // Create a new Game object and add some players to the first square
        GameManager game = new GameManager();
        game.createInitialJungle(10, playerInfo);

        // Test the getPlayerIds method
        String[][] actualInfo = game.getPlayersInfo();
        assertEquals("1 Diogo Diogo 1..6", actualInfo[0][0] + " " + actualInfo[0][1] + " " + actualInfo[0][1] + " " + actualInfo[0][4]);
        assertEquals("2 Joao Joao 4..6", actualInfo[1][0] + " " + actualInfo[1][1] + " " + actualInfo[1][1] + " " + actualInfo[1][4]);
    }

    GameManager gameManagersave = new GameManager();

    @Test
    public void testSaveGame() throws IOException, InvalidInitialJungleException {
        // Test case 1: Save game to a new file
        File file = new File("test1.txt");
        boolean expectedOutput = true;

        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        gameManagersave.createInitialJungle(10, playerInfo);

        boolean result = gameManagersave.saveGame(file);
        assertEquals(expectedOutput, result);

        // Verify that the file was created and contains the expected data
        assertTrue(file.exists());
        verifyFileContent(file);

        // Test case 2: Save game to an existing file
        file = new File("test2.txt");
        file.createNewFile();
        expectedOutput = true;

        result = gameManagersave.saveGame(file);
        assertEquals(expectedOutput, result);

        // Verify that the file was overwritten and contains the expected data
        assertTrue(file.exists());
        verifyFileContent(file);

        // Test case 3: Save game to a file with insufficient permissions
        file = new File("/root/test3.txt");
        expectedOutput = false;

        result = gameManagersave.saveGame(file);
        assertEquals(expectedOutput, result);

        // Verify that the file was not created
        assertFalse(file.exists());
    }

    private void verifyFileContent(File file) throws IOException {
        // Read the file and verify its content
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        assertEquals("Turn " + gameManagersave.turn, line);
        line = reader.readLine();
        assertEquals("Length " + gameManagersave.jungle.length, line);

        reader.close();
    }


    private GameManager gameManagerLoad = new GameManager();

    @Test
    public void testSaveAndLoadGame() throws IOException, InvalidInitialJungleException {

        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        gameManagerLoad.createInitialJungle(10, playerInfo);
        // Set up the test by saving a game to a file
        File file = new File("test.txt");
        boolean saveResult = gameManagerLoad.saveGame(file);

        // Invoke the method under test
        boolean loadResult = gameManagerLoad.loadGame(file);

        // Verify the results
        assertTrue(saveResult);
        assertTrue(loadResult);
        // Verify that the game was loaded correctly by comparing the data to the original game
        verifyLoadedGame(gameManagerLoad, gameManagerLoad);
    }

    private void verifyLoadedGame(GameManager expected, GameManager actual) {
        // Compare the data of the expected and actual games
        assertEquals(expected.turn, actual.turn);
        assertEquals(expected.jungle.length, actual.jungle.length);
        assertArrayEquals(expected.playersJogo, actual.playersJogo);
        assertArrayEquals(expected.jungle.arrayCells, actual.jungle.arrayCells);
        assertEquals(expected.saveInfoPlayer, actual.saveInfoPlayer);
        assertEquals(expected.saveInfoFood, actual.saveInfoFood);
        // ... compare other data as needed
    }

    @Test
    public void testWhoIsTaborda() {
        // Invoke the method under test
        String result = gameManager.whoIsTaborda();

        // Verify the results
        assertEquals("Wrestling", result);
    }

    @Test
    public void testGetGameResults() {
        // Set up the test data
        Player player1 = new Player(1, "Player 1", "Z", 5, 3, 20, "Tarzan", 0, 0);
        Player player2 = new Player(2, "Player 2", "E", 4, 2, 4, "Elefante", 0, 0);
        Player player3 = new Player(3, "Player 3", "P", 3, 1, 7, "Leao", 0, 0);
        gameManager.playersJogo = new Player[] {player1, player2, player3};

        // Invoke the method under test
        ArrayList<String> results = gameManager.getGameResults();

        // Verify the results
        assertEquals("#1 Player 1, Tarzan, 20, 0, 0", results.get(0));
        assertEquals("#2 Player 3, Leao, 7, 0, 0", results.get(1));
        assertEquals("#3 Player 2, Elefante, 4, 0, 0", results.get(2));
    }

    @Test
    public void testWinnerByDefault() throws InvalidInitialJungleException {
        // Create an instance of Player and set its attributes
        String[][] playerInfo = {{"1","Diogo","Z"},{"2","Joao","L"}};
        gameManagerLoad.createInitialJungle(10, playerInfo);

        gameManagerLoad.moveCurrentPlayer(10,true);

        // Call the getWinnerInfo method and store the result in a variable
        String[] result = gameManagerLoad.getWinnerInfo();

        // Use JUnit's assertArrayEquals method to check that the returned array is equal to the expected array
        assertArrayEquals(new String[]{"1", "Diogo", "Z", "52"}, result);

        gameManagerLoad.createInitialJungle(10, playerInfo);

        gameManagerLoad.moveCurrentPlayer(8,true);

        // Call the getWinnerInfo method and store the result in a variable
        String[] resultHalf = gameManagerLoad.getWinnerInfo();

        // Use JUnit's assertArrayEquals method to check that the returned array is equal to the expected array
        assertArrayEquals(new String[]{"2", "Joao", "L", "80"}, resultHalf);
    }


}