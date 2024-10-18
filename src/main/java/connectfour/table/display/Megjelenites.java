package connectfour.table.display;

import connectfour.table.TablaConf;

public class Megjelenites {

    public Megjelenites() {
    }
    public void display(char[][] tabla) {
        for (int sor = 0; sor < TablaConf.SOR.getIntErtek(); ++sor) {
            for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); ++oszlop) {
                System.out.print(tabla[sor][oszlop] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}