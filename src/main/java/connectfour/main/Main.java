package connectfour.main;


import connectfour.game.Jatek;
import connectfour.game.command.Paracskezelo;


public class Main extends Jatek {

    /**
     * main.
     * @param args .
     */
    public static void main(final String[] args) {
        System.out.println("Udvozollek a Connect 4 jatekban!");

        Paracskezelo parancskezelo = new Paracskezelo();
        parancskezelo.Start();  // parancs figyelese

}
}
