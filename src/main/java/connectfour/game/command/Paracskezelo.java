package connectfour.game.command;

import connectfour.game.Jatek;
import connectfour.player.NevKezelo;

import java.util.Scanner;

public class Paracskezelo extends NevKezelo {
    /**
     * Alaőból hamis
     */
    private boolean gameStarted = false;
    /**
     * .
     */
    private NevKezelo player;

    /**
     * Indítja a játékot.
     */
    public void Start() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        // Vár amig "Start"
        while (!userInput.equalsIgnoreCase("Kezdes")) {
            System.out.println("Ird be: 'Kezdes' a jatek elinditasahoz ");
            userInput = scanner.nextLine();
        }

        //"Start"
        System.out.println("A játék elindul...");
        Jatek jatek = new Jatek();
        jatek.jatekmenet();
    }
}
