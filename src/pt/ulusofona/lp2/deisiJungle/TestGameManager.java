package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGameManager {

    @Test
    public void TestMoveCurrentPlayer() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][3];

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Diogo";
        playerInfo[0][2] = "P";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Joao";
        playerInfo[1][2] = "T";


        gameManager.createInitialJungle(47, 20, playerInfo);
        Boolean resultadoEsperado = gameManager.moveCurrentPlayer(3,true);

        assertEquals("O resultado do método devia ser: ", resultadoEsperado, true);
    }

    @Test
    public void Test2MoveCurrentPlayer() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][3];

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Diogo";
        playerInfo[0][2] = "P";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Joao";
        playerInfo[1][2] = "T";


        gameManager.createInitialJungle(47, 20, playerInfo);
        Boolean resultadoEsperado = gameManager.moveCurrentPlayer(3,true);



        assertEquals("O resultado do método devia ser: ", resultadoEsperado, true);
    }

    @Test
    public void Test3MoveCurrentPlayer() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][3];

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Diogo";
        playerInfo[0][2] = "P";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Joao";
        playerInfo[1][2] = "T";


        gameManager.createInitialJungle(47, 20, playerInfo);
        Boolean resultadoEsperado = gameManager.moveCurrentPlayer(348,true);

        assertEquals("O resultado do método devia ser: ", resultadoEsperado, true);
    }

    @Test
    public void Test4MoveCurrentPlayer() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][3];

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Diogo";
        playerInfo[0][2] = "P";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Joao";
        playerInfo[1][2] = "T";


        gameManager.createInitialJungle(10, 20, playerInfo);
        Boolean resultadoEsperado = gameManager.moveCurrentPlayer(11,true);

        assertEquals("O resultado do método devia ser: ", resultadoEsperado, true);
    }

}