package connectfour.game;

import connectfour.game.condition.NyeresiFeltetel;
import connectfour.table.Tabla;

import java.util.Random;
import java.util.Scanner;

public class TesztJatek extends Jatek {

  public TesztJatek(boolean isTestMod) {
    super(isTestMod);
  }

  @Override
  protected Tabla getTable() {
    return new Tabla();
  }

  @Override
  protected NyeresiFeltetel getGyozelem() {
    return new NyeresiFeltetel();
  }

  @Override
  protected Random getRandom() {
    return new Random();
  }

  @Override
  protected Scanner getScanner() {
    return new Scanner(System.in);
  }
}
