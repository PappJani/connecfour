package connectfour.table.checker;

import connectfour.table.checker.Oszlop;
import connectfour.table.TablaConf;
import org.junit.Test;

import static org.junit.Assert.*;

public class OszlopTest {

  @Test
  public void testOszlopTele() {
    // Létrehozzuk a teszt táblát
    char[][] tabla = new char[6][7]; // A Connect 4 játékos táblája: 6 sor, 7 oszlop

    // A TablaConf.URES.getCharErtek() értéke
    char uresErtek = TablaConf.URES.getCharErtek();

    // A teszt oszlop
    int oszlop = 3; // Az 3. oszlopot fogjuk tesztelni

    // Kezdetben minden mező üres, tehát az oszlop nem tele
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        tabla[i][j] = uresErtek;
      }
    }

    // Tesztelés: Üres oszlop (nem tele)
    Oszlop oszlopChecker = new Oszlop();
    assertFalse("Az oszlopnak üresnek kell lennie", oszlopChecker.oszlopTele(tabla, oszlop));

    // Most tegyünk valamit az oszlop első sorába, hogy "tele" legyen
    tabla[0][oszlop] = 'X'; // Az oszlop első sorába tettünk egy 'X' karaktert

    // Tesztelés: Tele oszlop
    assertTrue("Az oszlopnak tele kell lennie", oszlopChecker.oszlopTele(tabla, oszlop));
  }
}