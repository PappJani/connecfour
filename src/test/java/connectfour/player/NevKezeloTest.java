package connectfour.player;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NevKezeloTest {

    @Test
    public void testNevBekeres() {
        // Szimulált bemenet
        String simulatedInput = "TesztJatekos\n";
        InputStream originalSystemIn = System.in; // Eredeti System.in mentése
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInputStream); // Szimulált bemenet beállítása

        // NevKezelo példány létrehozása
        NevKezelo nevKezelo = new NevKezelo();

        // Ellenőrzés
        assertEquals("TesztJatekos", nevKezelo.getNev(), "The player's name should match the simulated input.");

        // Visszaállítjuk az eredeti System.in-t
        System.setIn(originalSystemIn);
    }
}
