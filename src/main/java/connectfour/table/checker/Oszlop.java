package connectfour.table.checker;

import connectfour.table.TablaConf;

/**
 * Represents a column in the Connect Four game.
 */
public class Oszlop {

  /**
   * Checks if the column is full.
   *
   * @param table the table to check.
   * @param oszlop the column to check.
   * @return true if the column is full, false otherwise.
   */
  public boolean oszlopTele(final char[][] table, final int oszlop) {
    return table[0][oszlop] != TablaConf.URES.getCharErtek();
  }
}
