package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMovementResult {

    @Test
    public void testValues() {
        // Verify that the values of the MovementResultCode enum are correct
        assertEquals(MovementResultCode.INVALID_MOVEMENT, MovementResultCode.valueOf("INVALID_MOVEMENT"));
        assertEquals(MovementResultCode.NO_ENERGY, MovementResultCode.valueOf("NO_ENERGY"));
        assertEquals(MovementResultCode.VALID_MOVEMENT, MovementResultCode.valueOf("VALID_MOVEMENT"));
        assertEquals(MovementResultCode.CAUGHT_FOOD, MovementResultCode.valueOf("CAUGHT_FOOD"));
    }

    @Test
    public void testMessage() {
        // Create a new MovementResult object with a message
        MovementResult result = new MovementResult(MovementResultCode.INVALID_MOVEMENT, "This is a message");

        // Verify that the message is returned correctly
        assertEquals("This is a message", result.message());
    }
}
