package connectfour.game.command;

import connectfour.game.Jatek;
import connectfour.game.condition.NyeresiFeltetel;
import connectfour.player.NevKezelo;
import connectfour.table.Tabla;
import java.util.Random;
import java.util.Scanner;

/**
 * Command handler for the Connect 4 game.
 * This class can be extended to add new commands.
 */
public class Parancskezelo extends NevKezelo {
  /**
   * Starts the game and listens for user input.
   */
  public void start() {
    // Method implementation
    Scanner scanner = new Scanner(System.in);
    // Rest of the implementation
    String userInput = "";

    // Vár amig "Kezdes"
    while (!userInput.equalsIgnoreCase("Kezdes")) {
      System.out.println("Ird be: 'Kezdes' a jatek elinditasahoz ");
      userInput = scanner.nextLine();
    }

    //"Kezdes"
    System.out.println("A játék elindul...");
    Jatek jatek = new Jatek() {
      @Override
      protected Tabla getTable() {
        return null;
      }

      @Override
      protected NyeresiFeltetel getGyozelem() {
        return null;
      }

      @Override
      protected Random getRandom() {
        return null;
      }

      @Override
      protected Scanner getScanner() {
        return null;
      }
    };
    jatek.jatekmenet();
  }
}
