package pt.ulusofona.lp2.deisiJungle;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestBoard {
    @Test
    public void testCreateBoard() {
        GameManager gameManager = new GameManager();
        // Create a new Board object using the createBoard method
        Board board = gameManager.jungle.createBoard(10);

        // Verify that the length instance variable of the Board object is set to the correct value
        assertEquals(10, board.length);

        // Verify that the arrayCells instance variable of the Board object is initialized correctly
        assertNotNull(board.arrayCells);
        assertEquals(10, board.arrayCells.length);
        for (Cell cell : board.arrayCells) {
            assertNotNull(cell.cellInformationPlayer);
            assertNull(cell.cellInformationFood);
        }
    }
}
