package connectfour.table;

import connectfour.table.checker.Oszlop;
import connectfour.table.checker.TeleVizsgalat;
import connectfour.table.coin.Erme;
import connectfour.table.display.Beallitas;
import connectfour.table.display.Megjelenites;

/**
 * A játék tábláját reprezentáló osztály.
 * Feladata a tábla kezelése és állapotainak karbantartása.
 */
public class Tabla {
  /**
   * A tábla, amelyen a játék zajlik.
   */
  private final char[][] tabla;
  /**
   * A tábla beállításait végző osztály.
   */
  private final Beallitas beallitas;
  /**
   * A megjelenítést végző osztály.
   */
  private final Megjelenites megjelenites;
  /**
   * Az oszlopokat vizsgáló osztály.
   */
  private final Oszlop oszlop;
  /**
   * Az érmékkel kapcsolatos műveleteket végző osztály.
   */
  private final Erme erme;
  /**
   * A tábla tele van-e.
   */
  private final TeleVizsgalat teleVizsgalat;

  /**
   * A Tabla osztály a játék tábláját reprezentálja.
   * Ez felel a játék tábla kezeléséért, például
   * annak inicializálásáért és megjelenítéséért.
   */
  public Tabla() {
    tabla = new char[
        TablaConf.SOR.getIntErtek()
        ][
        TablaConf.OSZLOP.getIntErtek()
        ];
    beallitas = new Beallitas();
    megjelenites = new Megjelenites();
    oszlop = new Oszlop();
    erme = new Erme();
    teleVizsgalat = new TeleVizsgalat();
    beallitas.beallitas(tabla);
  }

  /**
   * A metódus megjeleníti a táblát.
   */
  public void megjelenites() {
    megjelenites.display(tabla);
  }

  /**
   * Ellenőrzi, hogy az adott oszlopIndex tele van-e.
   *
   * @param oszlopIndex Az oszlopIndex indexe, amelyet ellenőrizni kell.
   * @return Igaz, ha az oszlopIndex tele van, különben hamis.
   */
  public boolean oszlopTele(final int oszlopIndex) {
    return this.oszlop.oszlopTele(tabla, oszlopIndex);
  }

  /**
   * Kezeli az érmék bedobását az adott oszlopba.
   *
   * @param oszlopIndex Az oszlopIndex indexe, ahová az érme kerül.
   * @param jatekos     Az érme karakter reprezentációja.
   */
  public void erme(final int oszlopIndex, final char jatekos) {
    erme.bedobas(tabla, oszlopIndex, jatekos);
  }

  /**
   * Ellenőrzi, hogy a játékasztal tele van-e.
   *
   * @return Igaz, ha az asztal minden cellája foglalt, egyébként hamis.
   */
  public boolean tele() {
    return teleVizsgalat.tele(tabla);
  }

  /**
   * Visszaadja a játék tábla jelenlegi állapotát.
   *
   * @return A játék tábla kétdimenziós karaktertömb reprezentációja.
   */
  public final char[][] getTabla() {
    return tabla;
  }
}
