package connectfour.game;

import connectfour.table.Tabla;
import connectfour.game.condition.NyeresiFeltetel;

import java.util.Random;
import java.util.Scanner;

public class Jatek {
    /**
     * Magic number.
     */
    public static final int HET = 7;
    /**
     * .
     */
    private Tabla table;
    /**
     * .
     */
    private char jelenlegijatekos;
    /**
     * .
     */
    private Random random;
    /**
     * .
     */
    private NyeresiFeltetel gyozelem;

    /**
     * .
     */
    public Jatek() {
        // Létrehozza a játéktáblát, az első játékost és a véletlenszám-generátort
        table = new Tabla();
        jelenlegijatekos = 'X'; // Az első játékos 'X'
        random = new Random(); // Véletlenszám-generátor a gépi játékoshoz
        gyozelem = new NyeresiFeltetel(); // WinChecker példány létrehozása
    }


    /**
     * A játék menete.
     */
    public void jatekmenet() {
        Scanner scanner = new Scanner(System.in);
        boolean nyertes = false;

        System.out.println("Üdvözlünk a Connect4 játékban!");
        table.megjelenites();

        // Amíg valaki nem nyer, vagy a tábla meg nem telik
        while (!nyertes && !table.Tele()) {
            int oszlop;

            // Ha az emberi játékos (X) jön
            if (jelenlegijatekos == 'X') {
                System.out.println("Játékos " + jelenlegijatekos + " lépése.");

                // Játékos bemenete (oszlop kiválasztása)
                do {
                    System.out.print("Válassz egy oszlopot (0-6): ");
                    oszlop = scanner.nextInt();
                } while (oszlop < 0 || oszlop >= HET || table.OszlopTele(oszlop));

            } else { // Ha a gépi játékos jön
                System.out.println("Játékos "
                        + jelenlegijatekos + " lépése (gépi játékos).");

                // Véletlen oszlop választása
                do {
                    oszlop = random.nextInt(HET); // 0 és 6 között
                } while (table.OszlopTele(oszlop));

                System.out.println("Gépi játékos az "
                        + oszlop + " oszlopba dobja a korongot.");
            }

            // Dobd be a korongot
            table.erme(oszlop, jelenlegijatekos);
            table.megjelenites();

            // Ellenőrzi, hogy a jelenlegi játékos nyert-e
            if (gyozelem.gyozelemEll(table.getTabla(), jelenlegijatekos)) {
                System.out.println("Játékos " + jelenlegijatekos + " nyert!");
                nyertes = true;
            } else {
                // Váltás a másik játékosra
                jelenlegijatekos = (jelenlegijatekos == 'X') ? 'O' : 'X';
            }
        }

        // Döntetlen esetén
        if (!nyertes) {
            System.out.println("A játék döntetlen!");
        }

        scanner.close();
    }
}
