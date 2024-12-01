package connectfour.game;

import connectfour.table.Tabla;
import connectfour.game.condition.NyeresiFeltetel;

import java.util.Random;
import java.util.Scanner;

public class JatekTestImpl extends Jatek {

    private Tabla tabla;
    private Random random;
    private Scanner scanner;

    public JatekTestImpl(boolean testMod) {
        super(testMod); // Meghívjuk a szülő osztály konstruktorát, ami a testMod paramétert beállítja
        this.tabla = new Tabla();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    @Override
    protected Tabla getTable() {
        return tabla;
    }

    @Override
    protected NyeresiFeltetel getGyozelem() {
        return new NyeresiFeltetel();
    }

    @Override
    protected Random getRandom() {
        return random;
    }

    @Override
    protected Scanner getScanner() {
        return scanner;
    }
}
