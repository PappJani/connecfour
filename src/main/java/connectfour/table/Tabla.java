package connectfour.table;

import connectfour.table.coin.Erme;
import connectfour.table.display.Megjelenites;
import connectfour.table.display.Beallitas;
import connectfour.table.checker.TeleVizsgalat;
import connectfour.table.checker.Oszlop;

public class Tabla {
    private char[][] tabla;
    private Beallitas beallitas;
    private Megjelenites megjelenites;
    private Oszlop oszlop;
    private Erme erme;
    private TeleVizsgalat teleVizsgalat;

    public Tabla() {
        tabla = new char[TablaConf.SOR.getIntErtek()]
                [TablaConf.OSZLOP.getIntErtek()];
        beallitas = new Beallitas();
        megjelenites = new Megjelenites();
        oszlop = new Oszlop();
        erme = new Erme();
        teleVizsgalat = new TeleVizsgalat();
        beallitas.beallitas(tabla);
    }

    public void megjelenites() {
        megjelenites.display(tabla);
    }

    public boolean OszlopTele(final int oszlop) {
        return this.oszlop.oszlopTele(tabla, oszlop);
    }

    public void erme(final int oszlop, final char jatekos) {
        erme.Bedobas(tabla, oszlop, jatekos);
    }

    public boolean Tele() {
        return teleVizsgalat.Tele(tabla);
    }

    public char[][] getTabla() {
        return tabla;
    }
}
