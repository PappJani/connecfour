package connectfour.game.condition;

import connectfour.table.TablaConf;


public class NyeresiFeltetel {


    /**
     * Győzelmi feltételek ellenőrzése.
     * @param tabla .
     * @param jatekos .
     * @return .
     */
    public boolean gyozelemEll(final char[][] tabla, final char jatekos) {
        int rows = TablaConf.SOR.getIntErtek();
        int cols = TablaConf.OSZLOP.getIntErtek();
        final int harom = 3;

        // Vízszintes ellenőrzés
        for (int sor = 0; sor < rows; sor++) {
            for (int oszlop = 0; oszlop < cols - harom; oszlop++) {
                if (tabla[sor][oszlop] == jatekos
                        && tabla[sor][oszlop + 1] == jatekos
                        && tabla[sor][oszlop + 2] == jatekos
                        && tabla[sor][oszlop + harom] == jatekos) {
                    return true;
                }
            }
        }

        // Függőleges ellenőrzés
        for (int sor = 0; sor < rows - harom; sor++) {
            for (int oszlop = 0; oszlop < cols; oszlop++) {
                if (tabla[sor][oszlop] == jatekos
                        && tabla[sor + 1][oszlop] == jatekos
                        && tabla[sor + 2][oszlop] == jatekos
                        && tabla[sor + harom][oszlop] == jatekos) {
                    return true;
                }
            }
        }

        // Átlós ellenőrzés balról jobbra
        for (int row = 0; row < rows - harom; row++) {
            for (int col = 0; col < cols - harom; col++) {
                if (tabla[row][col] == jatekos
                        && tabla[row + 1][col + 1] == jatekos
                        && tabla[row + 2][col + 2] == jatekos
                        && tabla[row + harom][col + harom] == jatekos) {
                    return true;
                }
            }
        }

        // Átlós ellenőrzés jobbról balra
        for (int row = 0; row < rows - harom; row++) {
            for (int col = harom; col < cols; col++) {
                if (tabla[row][col] == jatekos
                        && tabla[row + 1][col - 1] == jatekos
                        && tabla[row + 2][col - 2] == jatekos
                        && tabla[row + harom][col - harom] == jatekos) {
                    return true;
                }
            }
        }

        return false; // Nincs győzelem
    }
}
