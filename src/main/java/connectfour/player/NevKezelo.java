package connectfour.player;

import java.util.Scanner;

public class NevKezelo {
    /**
     * Változó a névre.
     */
    private String nev;

    /**
     * Konstruktor, ami bekéri a játékos nevét.
     */
    public NevKezelo() {
        this.nev = NevBekeres();
    }

    // Név bekérése
    private String NevBekeres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kerem adja meg a nevet:");
        return scanner.nextLine().trim();
    }

    /**
     * Játékos nevének lekérdezése.
     * @return .
     */
    public String getNev() {
        return nev;
    }

    /**
     * .
     */
    public void printNev() {
        System.out.println("Jatekos neve: " + nev);
    }
}
