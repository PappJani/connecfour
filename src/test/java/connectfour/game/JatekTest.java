package connectfour.game;

import connectfour.table.TablaConf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JatekTest {

    private TesztJatek jatek;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // Teszt módban példányosítjuk
        jatek = new TesztJatek(true);

        // Standard kimenet eltérítése, hogy ellenőrizhessük az outputot
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testJatekmenetAutomatikus() {
        // Szimulált táblaállapot
        String bemenet = ""; // Teszt módban nem kell felhasználói bemenet
        System.setIn(new ByteArrayInputStream(bemenet.getBytes()));

        // A játékmenet futtatása
        jatek.jatekmenet();

        // Ellenőrizzük, hogy az output tartalmazza-e a győzelem vagy döntetlen üzenetet
        String output = outputStream.toString();
        assertTrue(output.contains("nyert") || output.contains("döntetlen"), "The game should end with a win or a draw.");
    }
}
