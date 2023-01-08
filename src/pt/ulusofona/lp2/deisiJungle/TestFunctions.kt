package pt.ulusofona.lp2.deisiJungle

import junit.framework.Assert.assertEquals
import org.junit.Test

class TestFunctions {

    @Test
    fun testGetPlayerBySpecie() {
        // Create an instance of the GameManager class and two Player objects with different species
        val gameManager = GameManager()

        // Create an instance of Player and set its attributes
        val playerInfo = arrayOf(arrayOf("1", "Diogo", "Z"), arrayOf("2", "Joao", "L"))
        gameManager.createInitialJungle(10, playerInfo)

        // Test for the case where players with the given species exist
        var result = getPlayerBySpecie(gameManager, listOf("Z"))
        assertEquals("Diogo", result)

        // Test for the case where no players with the given species exist
        result = getPlayerBySpecie(gameManager, listOf("G"))
        assertEquals("", result)
    }

    @Test
    fun testGetMostTraveled() {
        // Create an instance of the GameManager class and two Player objects with different species
        val gameManager = GameManager()

        // Create an instance of Player and set its attributes
        val playerInfo = arrayOf(arrayOf("1", "Diogo", "Z"), arrayOf("2", "Joao", "L"))
        gameManager.createInitialJungle(40, playerInfo)
        gameManager.moveCurrentPlayer(15,true);
        gameManager.moveCurrentPlayer(10,true);
        // Test for the case where there are players with different distances travelled
        var result = getMostTraveled(gameManager)
        assertEquals("Diogo:Z:15\nJoao:L:10\nTotal:25", result)

        // Test for the case where all players have the same distance travelled
        gameManager.moveCurrentPlayer(15,true);
        gameManager.moveCurrentPlayer(20,true);
        result = getMostTraveled(gameManager)
        assertEquals("Diogo:Z:30\nJoao:L:30\nTotal:60", result)
    }

    @Test
    fun testGetPlayerInfo() {
        // Create an instance of the GameManager class
        val gameManager = GameManager()

        // Create an instance of Player and set its attributes
        val playerInfo = arrayOf(arrayOf("1", "Diogo", "Z"),arrayOf("2", "Joao", "E"))
        gameManager.createInitialJungle(10, playerInfo)

        // Test for the case where the player exists
        var result = getPlayerInfo(gameManager, listOf("Diogo"))
        assertEquals("1 | Diogo | Tarzan | 70 | 1", result)

        // Test for the case where the player does not exist
        result = getPlayerInfo(gameManager, listOf("John"))
        assertEquals("Inexistent player", result)
    }

    @Test
    fun testGetTopEnergeticOmnivores() {
        // Create an instance of the GameManager class
        val gameManager = GameManager()

        // Create an instance of Player and set its attributes
        val playerInfo = arrayOf(arrayOf("1", "Diogo", "Z"), arrayOf("2", "Joao", "L"), arrayOf("3", "Ana", "E"))
        gameManager.createInitialJungle(10, playerInfo)

        // Test for the case where there are players with enough energy
        gameManager.playersJogo[0].currentEnergy = 20
        gameManager.playersJogo[1].currentEnergy = 15
        var result = getTopEnergeticOmnivores(gameManager, listOf("2"))
        assertEquals("Diogo:20", result)

        // Test for the case where there are not enough players with enough energy
        gameManager.playersJogo[0].currentEnergy = 5
        result = getTopEnergeticOmnivores(gameManager, listOf("2"))
        assertEquals("Diogo:5", result)

        // Test for the case where there are no players with the correct food type
        val playerInfoInvalid = arrayOf(arrayOf("3", "Ana", "E"),arrayOf("2", "Ana", "E"))
        gameManager.createInitialJungle(10, playerInfoInvalid)
        result = getTopEnergeticOmnivores(gameManager, listOf("2"))
        assertEquals("", result)
    }

    @Test
    fun testGetConsumedFoods() {
        // Create an instance of the GameManager class
        val gameManager = GameManager()

        // Create an instance of Player and set its attributes
        val playerInfo = arrayOf(arrayOf("1", "Diogo", "Z"), arrayOf("2", "Joao", "E"))
        gameManager.createInitialJungle(10, playerInfo)

        // Test for the case where there are consumed foods
        val player = gameManager.playersJogo[0]
        player.foodNamesList.addAll(listOf("apple", "banana", "orange"))
        var result = getConsumedFoods(gameManager)
        assertEquals("apple\nbanana\norange", result)

        // Test for the case where there are no consumed foods
        player.foodNamesList.clear()
        result = getConsumedFoods(gameManager)
        assertEquals("", result)
    }

    @Test
    fun testPostMove() {
        // Create an instance of the GameManager class
        val gameManager = GameManager()

        // Create an instance of Player and set its attributes
        val playerInfo = arrayOf(arrayOf("1", "Diogo", "Z"), arrayOf("2", "Diogo", "E"))
        val foodInfo = arrayOf(arrayOf("c", "3"))
        gameManager.createInitialJungle(10, playerInfo, foodInfo)
        val player = gameManager.playersJogo[0]

        // Test for the case where the movement is invalid
        var result = postMove(gameManager, listOf("-5"))
        assertEquals("Movimento invalido", result)
        // Test for the case where the movement is valid
        result = postMove(gameManager, listOf("5"))
        assertEquals("OK", result)

        // Test for the case where the player caught food
        result = postMove(gameManager, listOf("2"))
        assertEquals("Apanhou comida", result)

        // Test for the case where the player does not have enough energy
        result = postMove(gameManager, listOf("300"))
        assertEquals("Sem energia", result)
    }

    }