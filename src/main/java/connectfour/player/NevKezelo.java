package connectfour.player;

import java.util.Scanner;

/**
 * Constructs a new instance of NevKezelo.
 * Initializes the player's name by prompting the user.
 */
public class NevKezelo {
  /**
   * Változó a névre.
   */
  private final String nev;

  /**
   * Konstruktor, ami bekéri a játékos nevét.
   */
  public NevKezelo() {
    this.nev = nevBekeres();
  }

  /**
   * Prompts the user to enter their name.
   *
   * @return The entered name as a trimmed string.
   */

  private String nevBekeres() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kerem adja meg a nevet:");
    return scanner.nextLine().trim();
  }

  /**
   * Játékos nevének lekérdezése.
   *
   * @return .
   */
  public String getNev() {
    return nev;
  }
}
