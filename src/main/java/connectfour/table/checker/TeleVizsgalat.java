package connectfour.table.checker;

import connectfour.table.TablaConf;

/**
 * Class for verifying if the Connect Four table is full.
 */
public final class TeleVizsgalat {

  /**
   * Checks if the entire table is full.
   *
   * @param tabla the table to check.
   * @return true if the table is full, false otherwise.
   */
  public boolean tele(final char[][] tabla) {
    for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); oszlop++) {
      if (tabla[0][oszlop] == TablaConf.URES.getCharErtek()) {
        return false;
      }
    }
    return true;
  }
}
