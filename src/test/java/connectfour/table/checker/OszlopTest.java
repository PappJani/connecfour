package connectfour.table.checker;

import connectfour.table.TablaConf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OszlopTest {

  private Oszlop oszlopChecker;
  private char[][] table;

  @BeforeEach
  public void setUp() {
    oszlopChecker = new Oszlop();

    // Inicializálunk egy 6x7-es táblát (6 sor, 7 oszlop)
    table = new char[6][7];
    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < table[i].length; j++) {
        table[i][j] = TablaConf.URES.getCharErtek(); // Az üres karakterek feltöltése
      }
    }
  }

  @Test
  public void testOszlopNemTele() {
    // Egy üres oszlopot ellenőrzünk
    int oszlop = 3; // 4. oszlop (indexelve 0-tól)
    assertFalse(oszlopChecker.oszlopTele(table, oszlop), "An empty column should not be marked as full.");
  }

  @Test
  public void testOszlopTele() {
    // Feltöltjük az oszlopot
    int oszlop = 2; // 3. oszlop
    for (int i = 0; i < table.length; i++) {
      table[i][oszlop] = 'X'; // Feltöltjük az oszlopot 'X' karakterrel
    }
    assertTrue(oszlopChecker.oszlopTele(table, oszlop), "A fully filled column should be marked as full.");
  }

  @Test
  public void testOszlopReszbenTele() {
    // Részben töltött oszlop
    int oszlop = 5; // 6. oszlop
    table[5][oszlop] = 'X'; // Csak az alsó cellát töltjük ki
    assertFalse(oszlopChecker.oszlopTele(table, oszlop), "A partially filled column should not be marked as full.");
  }
}
