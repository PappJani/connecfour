package connectfour.table;

import connectfour.table.TablaConf;
import org.junit.Test;

import static org.junit.Assert.*;

public class TablaConfTest {

  @Test
  public void testGetIntErtek() {
    // Teszteljük, hogy a sorok száma (6) és az oszlopok száma (7) helyesen kerülnek visszaadásra.
    assertEquals("A sorok számának 6-nak kell lennie.", 6, TablaConf.SOR.getIntErtek());
    assertEquals("Az oszlopok számának 7-nek kell lennie.", 7, TablaConf.OSZLOP.getIntErtek());
  }

  @Test
  public void testGetCharErtek() {
    // Teszteljük, hogy az üres mező karakterének (.) helyesen kell visszatérnie.
    assertEquals("Az üres mező karakterének '.' kell lennie.", '.', TablaConf.URES.getCharErtek());
  }

  @Test
  public void testConstructorForInt() {
    // Teszteljük, hogy az integer típusú értékek (SOR, OSZLOP) helyesen lettek beállítva.
    assertEquals("A SOR értékének 6-nak kell lennie.", 6, TablaConf.SOR.getIntErtek());
    assertEquals("Az OSZLOP értékének 7-nek kell lennie.", 7, TablaConf.OSZLOP.getIntErtek());
  }

  @Test
  public void testConstructorForChar() {
    // Teszteljük, hogy a karakter típusú értékek (URES) helyesen lettek beállítva.
    assertEquals("Az URES értékének '.' karakternek kell lennie.", '.', TablaConf.URES.getCharErtek());
  }
}