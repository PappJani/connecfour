package connectfour.table.display;

import connectfour.table.display.Beallitas;
import connectfour.table.TablaConf;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BeallitasTest {

    private Beallitas beallitas;
    private char[][] tabla;

    @Before
    public void setUp() {
        // Minden teszt előtt létrehozzuk a Beallitas példányt és a táblát
        beallitas = new Beallitas();
        tabla = new char[TablaConf.SOR.getIntErtek()][TablaConf.OSZLOP.getIntErtek()];
    }

    @Test
    public void testBeallitas() {
        // Meghívjuk a beallitas metódust, hogy beállítsa az üres mezőket a táblán
        beallitas.beallitas(tabla);

        // Ellenőrizzük, hogy minden mező üres (TablaConf.URES karakterrel)
        for (int sor = 0; sor < TablaConf.SOR.getIntErtek(); sor++) {
            for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); oszlop++) {
                assertEquals("A mezőnek üresnek kell lennie!", TablaConf.URES.getCharErtek(), tabla[sor][oszlop]);
            }
        }
    }
}