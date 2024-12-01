package connectfour.game.command;

import connectfour.game.Jatek;
import connectfour.game.condition.NyeresiFeltetel;
import connectfour.player.NevKezelo;
import connectfour.table.Tabla;

import java.util.Random;
import java.util.Scanner;

public class Parancskezelo extends NevKezelo {
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

    public boolean isGameStarted() {
        return gameStarted;
    }
}
