package connectfour.table.checker;

import connectfour.table.TablaConf;

public class TeleVizsgalat {
    public boolean Tele(char[][] tabla) {
        for (int oszlop = 0; oszlop < TablaConf.OSZLOP.getIntErtek(); oszlop++) {
            if (tabla[0][oszlop] == TablaConf.URES.getCharErtek()) {
                return false;
            }
        }
        return true;
    }
}