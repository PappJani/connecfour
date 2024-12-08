package connectfour.game;

import connectfour.game.condition.NyeresiFeltetel;
import connectfour.table.Tabla;
import java.util.Random;
import java.util.Scanner;

/**
 * A Jatek osztály az absztrakt alapja a játéklogika megvalósításának.
 * Ez az osztály tartalmazza a játék közös elemeit, amelyeket a
 * konkrét játékosztályok tovább örökölnek.
 */
public abstract class Jatek {
  // Az osztály tartalma
  /**
   * A játék tábláján az oszlopok száma.
   * Ez a konstans a játékmező szélességét határozza meg.
   */
  public static final int HET = 7;
  /**
   * A játék tábláján a sorok száma.
   * Ez a konstans a játékmező magasságát határozza meg.
   */
  private final Tabla table;
  /**
   * A jelenlegi játékos karaktere.
   */
  private char jelenlegijatekos;
  /**
   * A random szám generátor.
   */
  private final Random random;
  /**
   * A nyerési feltétel.
   */
  private final NyeresiFeltetel gyozelem;
  /**
   * Teszt mód.
   */
  private final boolean testMod;
  // Új változó, ami jelzi, hogy teszt módban vagyunk-e

  // Paraméteres konstruktor (teszt mód beállítása)

  /**
   * A Jatek osztály paraméteres konstruktora.
   *
   * @param isTestMod meghatározza, hogy a játék teszt módban fusson-e.
   */
  public Jatek(final boolean isTestMod) {
    table = new Tabla();
    jelenlegijatekos = 'X';
    random = new Random();
    gyozelem = new NyeresiFeltetel();
    this.testMod = isTestMod;
  }

  // Alapértelmezett konstruktor (testMod false-ra állítva)

  /**
   * Az alapértelmezett konstruktor.
   */
  public Jatek() {
    this(false); // Alapértelmezés szerint normál módban indítjuk
  }

  /**
   * A játékmenetet megvalósító metódus.
   */
  public void jatekmenet() {
    Scanner scanner = new Scanner(System.in);
    boolean nyertes = false;

    System.out.println("Üdvözlünk a Connect4 játékban!");
    table.megjelenites();

    while (!nyertes && !table.tele()) {
      int oszlop;

      if (jelenlegijatekos == 'X') {
        if (testMod) {
          System.out.println(
              "Játékos " + jelenlegijatekos + " lépése (automatikus lépés)."
          );
          do {
            oszlop = random.nextInt(HET);
          } while (table.oszlopTele(oszlop));
          System.out.println(
              "Játékos X az " + oszlop + " oszlopba dobja a korongot."
          );
        } else {
          System.out.println("Játékos " + jelenlegijatekos + " lépése.");
          do {
            System.out.print("Válassz egy oszlopot (0-6): ");
            oszlop = scanner.nextInt();
          } while (oszlop < 0 || oszlop >= HET || table.oszlopTele(oszlop));
        }
      } else {
        System.out.println(
            "Játékos " + jelenlegijatekos + " lépése (gépi játékos)."
        );
        do {
          oszlop = random.nextInt(HET);
        } while (table.oszlopTele(oszlop));
        System.out.println(
            "Gépi játékos az " + oszlop + " oszlopba dobja a korongot."
        );
      }

      table.erme(oszlop, jelenlegijatekos);
      table.megjelenites();

      if (gyozelem.gyozelemEll(table.getTabla(), jelenlegijatekos)) {
        System.out.println("Játékos " + jelenlegijatekos + " nyert!");
        nyertes = true;
      } else {
        jelenlegijatekos = (jelenlegijatekos == 'X') ? 'O' : 'X';
      }
    }

    if (!nyertes) {
      System.out.println("A játék döntetlen!");
    }

    scanner.close();
  }

  /**
   * A játékmenetet megvalósító metódus.
   *
   * @return a játék tábláját reprezentáló objektum.
   */
  protected abstract Tabla getTable();

  /**
   * Visszaadja a nyerési feltételeket leíró objektumot.
   * Használható a játék logikájában a győzelmi állapot ellenőrzésére.
   *
   * @return a nyerési feltételek objektuma
   */
  protected abstract NyeresiFeltetel getGyozelem();

  /**
   * Visszaadja a jelenlegi játékost.
   *
   * @return a jelenlegi játékos karaktere.
   */
  protected abstract Random getRandom();

  /**
   * Visszaadja a játékos által megadott bemenetet olvasó objektumot.
   *
   * @return a bemenetet olvasó objektum.
   */
  protected abstract Scanner getScanner();
}
