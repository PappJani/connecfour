package connectfour.table.display;

import connectfour.table.TablaConf;

/**
 * A játék tábla megjelenítéséért felelős osztály.
 */
public class Megjelenites {

  /**
   * Konstruktor.
   */
  public Megjelenites() {
  }

  /**
   * Megjeleníti a játék tábláját a konzolon.
   *
   * @param tabla A játék tábla, amelyet meg kell jeleníteni.
   */
  public void display(final char[][] tabla) {
    for (int sor = 0; sor < TablaConf.SOR.getIntErtek(); ++sor) {
      for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); ++oszlop) {
        System.out.printf("%c ", tabla[sor][oszlop]);

      }
      System.out.println();
    }
    System.out.println();
  }
}
