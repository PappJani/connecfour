package connectfour.player;

import connectfour.player.NevKezelo;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class NevKezeloTest {

    @Test
    public void testNevBekeres() {
        // Tesztbemenet szimulálása
        String testInput = "TesztJatekos\n"; // A név most "TesztJatekos"
        InputStream originalSystemIn = System.in; // Eredeti System.in elmentése
        try {
            // Átirányítjuk a System.in-t egy ByteArrayInputStream-re
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));

            // A NevKezelo példányosítása és a bemenet átadása
            NevKezelo nevKezelo = new NevKezelo();

            // A nev értékének lekérése
            String nev = nevKezelo.getNev();

            // Ellenőrizni, hogy a név megegyezik-e a várt értékkel
            assertEquals("TesztJatekos", nev); // Várt érték "TesztJatekos"
        } finally {
            // A teszt után visszaállítjuk a System.in-t az eredetire
            System.setIn(originalSystemIn);
        }
    }
}