package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInitializationError {
    @Test
    public void testGetMessage() {
        // Create a new InitializationError object with a message
        InitializationError error = new InitializationError("This is an error message");

        // Verify that the message is returned correctly
        assertEquals("This is an error message", error.getMessage());
    }
}
