package connectfour.main;


import connectfour.game.Jatek;
import connectfour.game.command.Parancskezelo;


public abstract class Main extends Jatek {

    /**
     * main.
     * @param args .
     */
    public static void main(final String[] args) {
        System.out.println("Udvozollek a Connect 4 jatekban!");

        Parancskezelo parancskezelo = new Parancskezelo();
        parancskezelo.Start();  // parancs figyelese

    }
}
