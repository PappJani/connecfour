package connectfour.table.coin;

import connectfour.table.TablaConf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErmeTest {

    private Erme erme;
    private char[][] tabla;

    @BeforeEach
    public void setUp() {
        erme = new Erme();
        // 6x7-es Connect Four tábla, feltételezve az alapértelmezett beállításokat
        tabla = new char[6][7];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = TablaConf.URES.getCharErtek(); // Üres karakter
            }
        }
    }

    @Test
    public void testBedobasInEmptyColumn() {
        // Bedobás egy üres oszlopba
        int oszlop = 3; // 4. oszlop (indexelve 0-tól)
        char jatekos = 'X';

        erme.bedobas(tabla, oszlop, jatekos);

        // Ellenőrizzük, hogy a legalsó cella az oszlopban tartalmazza-e a játékost
        assertEquals(jatekos, tabla[5][oszlop], "The coin should be placed in the bottom-most row of the column.");
    }

    @Test
    public void testBedobasInPartiallyFilledColumn() {
        // Előre feltöltjük az oszlopot részben
        int oszlop = 2; // 3. oszlop
        char jatekos1 = 'X';
        char jatekos2 = 'O';

        // Első bedobás
        erme.bedobas(tabla, oszlop, jatekos1);
        // Második bedobás
        erme.bedobas(tabla, oszlop, jatekos2);

        // Ellenőrizzük az oszlop állapotát
        assertEquals(jatekos1, tabla[5][oszlop], "The first coin should be in the bottom-most row.");
        assertEquals(jatekos2, tabla[4][oszlop], "The second coin should be above the first one.");
    }

    @Test
    public void testBedobasInFullColumn() {
        // Feltöltjük az oszlopot teljesen
        int oszlop = 1; // 2. oszlop
        char jatekos = 'X';

        for (int i = 0; i < tabla.length; i++) {
            erme.bedobas(tabla, oszlop, jatekos);
        }

        // Próbáljunk meg újabb érmét bedobni
        erme.bedobas(tabla, oszlop, 'O');

        // Ellenőrizzük, hogy nem történt változás (a legfelső sor tartalmazza az eredeti értéket)
        assertEquals(jatekos, tabla[0][oszlop], "The column should remain unchanged when it is full.");
    }
}
