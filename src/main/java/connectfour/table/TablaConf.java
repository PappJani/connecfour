package connectfour.table;

public enum TablaConf {
    /**
     * A sorok száma a táblán.
     */
    SOR(6),
    /**
     * Az oszlopok száma a táblán.
     */
    OSZLOP(7),
    /**
     * Az üres mezők jelölése a táblán.
     */
    URES('.');

    /**
     * Int érték.
     */
    private final int intErtek;
    /**
     * Karakterérték.
     */
    private final char charErtek;

    // Konstruktor az egész szám típusú értékekhez (ROWS és COLUMNS)
    TablaConf(final int ertek) {
        this.intErtek = ertek;
        this.charErtek = '\0'; // Alapértelmezett érték, ha nem karakter
    }

    // Konstruktor a karakter típusú értékhez (EMPTY_SLOT)
    TablaConf(final char ertek) {
        this.intErtek = -1; // Alapértelmezett érték, ha nem egész szám
        this.charErtek = ertek;
    }
    /**
     * Metódus az egész szám típusú értékek lekéréséhez.
     * @return visszaadja az intek értékét
     */
    public int getIntErtek() {
        return intErtek;
    }

    /**
     * Metódus a karakter típusú érték lekéréséhez.
     * @return charValue Visszaadja a karakterek értékét
     */
    public char getCharErtek() {
        return charErtek;
    }
}
