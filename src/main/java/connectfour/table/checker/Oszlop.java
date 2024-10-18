package connectfour.table.checker;


import connectfour.table.TablaConf;

public class Oszlop {
    public boolean oszlopTele(char[][] tabla, final int oszlop) {
        return tabla[0][oszlop] != TablaConf.URES.getCharErtek();
    }
}
