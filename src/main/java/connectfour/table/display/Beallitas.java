package connectfour.table.display;

import connectfour.table.TablaConf;

/**
 * A Beallitas osztály a játéktábla alapállapotba állításáért felelős.
 */
public class Beallitas {
  /**
   * Alapállapotba állítja a játék tábla minden celláját.
   *
   * @param tabla A játék tábla, amelyet alaphelyzetbe kell állítani.
   */
  public void beallitas(final char[][] tabla) {
    for (int sor = 0; sor < TablaConf.SOR.getIntErtek(); sor++) {
      for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); oszlop++) {
        tabla[sor][oszlop] = TablaConf.URES.getCharErtek();
      }
    }
  }
}
