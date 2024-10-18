package connectfour.table.display;

import connectfour.table.TablaConf;

public class Beallitas {
    public void beallitas(char[][] tabla) {
        for (int sor = 0; sor < TablaConf.SOR.getIntErtek(); sor++) {
            for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); oszlop++) {
                tabla[sor][oszlop] = TablaConf.URES.getCharErtek();
            }
        }
    }
}