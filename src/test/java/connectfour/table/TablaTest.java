package connectfour.table;

import connectfour.table.Tabla;
import connectfour.table.TablaConf;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TablaTest {

    private Tabla tabla;

    @Before
    public void setUp() {
        // Minden teszt előtt új tábla objektumot hozunk létre
        tabla = new Tabla();
    }

    @Test
    public void testTablaInicializalas() {
        // Ellenőrizzük, hogy a tábla megfelelő méretű és üres.
        char[][] tablaArray = tabla.getTabla();

        // A tábla sorainak száma 6, oszlopainak száma 7 legyen
        assertEquals("A tábla sorainak száma 6-nak kell lennie.", 6, tablaArray.length);
        assertEquals("A tábla oszlopainak száma 7-nek kell lennie.", 7, tablaArray[0].length);

        // Ellenőrizzük, hogy az összes mező üres (TablaConf.URES karakterrel)
        for (int i = 0; i < tablaArray.length; i++) {
            for (int j = 0; j < tablaArray[i].length; j++) {
                assertEquals("A mező üres kell, hogy legyen.", TablaConf.URES.getCharErtek(), tablaArray[i][j]);
            }
        }
    }
    
    @Test
    public void testErmeBedobas() {
        // Teszteljük, hogy az érme bedobása működik-e.
        // Bedobunk egy 'X' jelű érmét az 0. oszlopba
        tabla.erme(0, 'X');
        char[][] tablaArray = tabla.getTabla();

        // Ellenőrizzük, hogy az érme a megfelelő helyen van
        assertEquals("Az érme nem került a megfelelő helyre.", 'X', tablaArray[5][0]);

        // Bedobunk egy második érmét a 0. oszlopba
        tabla.erme(0, 'O');
        assertEquals("A második érme nem került a megfelelő helyre.", 'O', tablaArray[4][0]);
    }

    @Test
    public void testTele() {
        // Teszteljük, hogy a Tele metódus helyesen adja vissza a tábla állapotát.

        // Először nincs tele a tábla
        assertFalse("A tábla nem lehet tele az elején.", tabla.Tele());

        // Feltöltjük az egész táblát
        for (int i = 0; i < TablaConf.OSZLOP.getIntErtek(); i++) {
            for (int j = 0; j < TablaConf.SOR.getIntErtek(); j++) {
                tabla.erme(i, 'X');
            }
        }

        // Most már tele kell, hogy legyen a tábla
        assertTrue("A tábla tele kell, hogy legyen.", tabla.Tele());
    }
}