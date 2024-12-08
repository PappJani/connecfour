package connectfour.table.coin;

import connectfour.table.TablaConf;

/**
 * Represents a coin in the Connect Four game.
 */
public final class Erme {

  /**
   * Drops a coin into the specified column of the Connect Four table.
   *
   * @param tabla   the game table.
   * @param oszlop  the column index where the coin should be dropped.
   * @param jatekos the character representing the player's coin.
   */
  public void bedobas(
      final char[][] tabla,
      final int oszlop,
      final char jatekos) {
    int sor = TablaConf.SOR.getIntErtek() - 1;
    for (; sor >= 0; sor--) {
      if (tabla[sor][oszlop] == TablaConf.URES.getCharErtek()) {
        tabla[sor][oszlop] = jatekos;
        break;
      }
    }
  }

}
