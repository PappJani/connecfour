package connectfour.game;

import connectfour.table.Tabla;
import connectfour.game.condition.NyeresiFeltetel;

import java.util.Random;
import java.util.Scanner;

public abstract class Jatek {
    public static final int HET = 7;
    private Tabla table;
    private char jelenlegijatekos;
    private Random random;
    private NyeresiFeltetel gyozelem;
    private boolean testMod; // Új változó, ami jelzi, hogy teszt módban vagyunk-e

    // Paraméteres konstruktor (teszt mód beállítása)
    public Jatek(boolean testMod) {
        table = new Tabla();
        jelenlegijatekos = 'X';
        random = new Random();
        gyozelem = new NyeresiFeltetel();
        this.testMod = testMod;
    }

    // Alapértelmezett konstruktor (testMod false-ra állítva)
    public Jatek() {
        this(false); // Alapértelmezés szerint normál módban indítjuk
    }

    public void jatekmenet() {
        Scanner scanner = new Scanner(System.in);
        boolean nyertes = false;

        System.out.println("Üdvözlünk a Connect4 játékban!");
        table.megjelenites();

        while (!nyertes && !table.Tele()) {
            int oszlop;

            if (jelenlegijatekos == 'X') {
                if (testMod) {
                    System.out.println("Játékos " + jelenlegijatekos + " lépése (automatikus lépés).");
                    do {
                        oszlop = random.nextInt(HET); // Random oszlop választása (0-6 között)
                    } while (table.OszlopTele(oszlop)); // Ha a választott oszlop tele, újra próbálkozik
                    System.out.println("Játékos X az " + oszlop + " oszlopba dobja a korongot.");
                } else {
                    System.out.println("Játékos " + jelenlegijatekos + " lépése.");
                    do {
                        System.out.print("Válassz egy oszlopot (0-6): ");
                        oszlop = scanner.nextInt();
                    } while (oszlop < 0 || oszlop >= HET || table.OszlopTele(oszlop));
                }
            } else {
                System.out.println("Játékos " + jelenlegijatekos + " lépése (gépi játékos).");
                do {
                    oszlop = random.nextInt(HET); // Random oszlop választása (0-6 között)
                } while (table.OszlopTele(oszlop)); // Ha a választott oszlop tele, újra próbálkozik
                System.out.println("Gépi játékos az " + oszlop + " oszlopba dobja a korongot.");
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

    protected abstract Tabla getTable();

    protected abstract NyeresiFeltetel getGyozelem();

    protected abstract Random getRandom();

    protected abstract Scanner getScanner();
}