package connectfour.table.coin;

import connectfour.table.TablaConf;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErmeTest {

  @Test
  public void testBedobas() {
    // Létrehozzuk a teszt táblát (6 sor és 7 oszlop)
    char[][] tabla = new char[6][7];

    // A TablaConf.URES.getCharErtek() értéke (üres mező)
    char uresErtek = TablaConf.URES.getCharErtek();
    // Játékos 'X' karakterrel fog dobni
    char jatekos = 'X';

    // Kezdetben minden mező üres
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        tabla[i][j] = uresErtek;
      }
    }

    // Erme objektum létrehozása
    Erme erme = new Erme();

    // Teszt 1: Bedobás egy üres oszlopba
    int oszlop = 3; // A 3-as oszlopba dobunk
    erme.bedobas(tabla, oszlop, jatekos);

    // Ellenőrizni, hogy a legalsó üres mezőbe (első sor) került a jel
    assertEquals("Az 'X' játéknak a legalsó üres helyre kell kerülnie.", jatekos, tabla[5][oszlop]);

    // Teszt 2: Bedobás egy második érmét ugyanabba az oszlopba
    erme.bedobas(tabla, oszlop, jatekos); // A második érmét ugyanabba az oszlopba dobjuk

    // Ellenőrizni, hogy az új érmét a következő üres mezőbe tettük
    assertEquals("A második érmének a következő üres helyre kell kerülni.", jatekos, tabla[4][oszlop]);

    // Teszt 3: Bedobás egy teljes oszlopba
    // Töltjük az oszlopot egészen a legfelső üres sorig
    tabla[4][oszlop] = 'X';
    tabla[3][oszlop] = 'X';
    tabla[2][oszlop] = 'X';
    tabla[1][oszlop] = 'X';

    // Most az oszlop teljes, tehát nem dobhatunk bele többet
    erme.bedobas(tabla, oszlop, jatekos);

    // Ellenőrizni, hogy az oszlop nem változott, mivel már tele van
    assertEquals("A tábla oszlopa már tele van, ezért nem történt bedobás.", 'X', tabla[0][oszlop]);
  }
}