package connectfour.table.coin;

import connectfour.table.TablaConf;

public class Erme {
    public void Bedobas(char[][] tabla, final int oszlop, final char jatekos) {
        for (int sor = TablaConf.SOR.getIntErtek() - 1; sor >= 0; sor--) {
            if (tabla[sor][oszlop] == TablaConf.URES.getCharErtek()) {
                tabla[sor][oszlop] = jatekos;
                break;
            }
        }
    }
}