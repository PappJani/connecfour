package connectfour.table.checker;

import connectfour.table.TablaConf;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeleVizsgalatTest {

  @Test
  public void testTele() {
    // Létrehozzuk a teszt táblát
    char[][] tabla = new char[6][7]; // A Connect 4 játékos táblája: 6 sor, 7 oszlop

    // A TablaConf.URES.getCharErtek() értéke
    char uresErtek = TablaConf.URES.getCharErtek();

    // Teszt 1: Üres tábla
    // Kezdetben minden mező üres, tehát a tábla nem lehet teljes
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        tabla[i][j] = uresErtek;
      }
    }

    // TeleVizsgalat objektum
    TeleVizsgalat teleVizsgalat = new TeleVizsgalat();

    // Tesztelés: Az oszlopok első sora üres, tehát a tábla nem lehet tele
    assertFalse("A tábla nem lehet teljes, ha van üres oszlop első sora", teleVizsgalat.tele(tabla));

    // Teszt 2: Az oszlopok első sorai tele vannak
    // Töltsük meg az első sort minden oszlopban
    for (int oszlop = 0; oszlop < tabla[0].length; oszlop++) {
      tabla[0][oszlop] = 'X'; // Tegyünk egy 'X' karaktert minden oszlop első sorába
    }

    // Tesztelés: Mivel az első sor teljes, a tábla most már tele van
    assertTrue("A tábla teljes, mivel az első sor minden oszlopa tele van", teleVizsgalat.tele(tabla));

    // Teszt 3: Egy oszlop első sorában üres mező
    // Most tegyünk egy üres mezőt az egyik oszlop első sorába
    tabla[0][3] = uresErtek; // Az 3. oszlop első sorát üresre állítjuk

    // Tesztelés: Az oszlop első sora üres, tehát a tábla nem teljes
    assertFalse("A tábla nem lehet teljes, ha bármelyik oszlop első sora üres", teleVizsgalat.tele(tabla));
  }
}