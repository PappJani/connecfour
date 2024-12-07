package connectfour.main;


import connectfour.game.Jatek;
import connectfour.game.command.Parancskezelo;

/**
 * The main class of the Connect 4 game.
 * This class starts the game by initializing the main components.
 */
public abstract class Main extends Jatek {
  // Code here

  /**
   * The main method, which is the entry point of the Connect 4 game.
   *
   * @param args the command-line arguments (not used)
   */
  public static void main(final String[] args) {
    System.out.println("Udvozollek a Connect 4 jatekban!");
    Parancskezelo parancskezelo = new Parancskezelo();
    parancskezelo.start();
    // parancs figyelese
  }
}


