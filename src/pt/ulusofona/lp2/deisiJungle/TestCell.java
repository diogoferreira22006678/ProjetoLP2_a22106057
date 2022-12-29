package pt.ulusofona.lp2.deisiJungle;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.food.Bananas;

import java.util.ArrayList;

public class TestCell {
    @Test
    public void testAddInformationFood() {
        // Create a new Cell object and an array of Cell objects
        Cell cell = new Cell(new ArrayList<>());
        Cell[] arrayCell = new Cell[] { cell };

        // Add a Food object to the Cell object using the addInformationFood method
        Bananas bananas = new Bananas("id", 0, "imageName", 0, "name");
        arrayCell = cell.addInformationFood(bananas, arrayCell, 1);

        // Verify that the Food object was added to the Cell object correctly
        assertEquals(bananas, arrayCell[0].cellInformationFood);
    }

    @Test
    public void testAddInformation() {
        // Create a new Cell object and an array of Cell objects
        Cell cell = new Cell(new ArrayList<>());
        Cell[] arrayCell = new Cell[] { cell };

        // Add a Player object to the Cell object using the addInformation method
        Player player = new Player();
        arrayCell = cell.addInformation(player, arrayCell, 1);

        // Verify that the Player object was added to the Cell object correctly
        assertEquals(player, arrayCell[0].cellInformationPlayer.get(0));
    }

    @Test
    public void testRemoveInformation() {
        // Create a new Cell object and an array of Cell objects
        Cell cell = new Cell(new ArrayList<>());
        Cell[] arrayCell = new Cell[] { cell };

        // Add a Player object to the Cell object
        Player player = new Player();
        arrayCell = cell.addInformation(player, arrayCell, 1);

        // Remove the Player object from the Cell object using the removeInformation method
        arrayCell = cell.removeInformation(player.getId(), arrayCell, 1);

        // Verify that the Player object was removed from the Cell object correctly
        assertEquals(0, arrayCell[0].cellInformationPlayer.size());
    }

    @Test
    public void testGetPlayersIdCell() {
        // Create a new Cell object and an array of Cell objects
        Cell cell = new Cell(new ArrayList<>());
        Cell[] arrayCell = new Cell[] { cell };

        // Add two Player objects to the Cell object
        Player player1 = new Player();
        Player player2 = new Player();
        arrayCell = cell.addInformation(player1, arrayCell, 1);
        arrayCell = cell.addInformation(player2, arrayCell, 1);

        // Get the IDs of the players in the Cell object using the getPlayersIdCell method
        int[] playerIds = cell.getPlayersIdCell(arrayCell, 1);

        // Verify that the IDs of the players are returned correctly
        assertArrayEquals(new int[] { player1.getId(), player2.getId() }, playerIds);
    }
}