package connectfour.game;

import connectfour.game.JatekTestImpl;
import connectfour.table.Tabla;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JatekTest {

    @Test
    void testJatekTestMod() {
        // Teszt módot állítunk be, így a játék gép által játszik
        JatekTestImpl jatek = new JatekTestImpl(true); // Teszt mód, ahol a gép fog játszani

        // Ellenőrizzük, hogy a tábla inicializálva van-e
        Tabla tabla = jatek.getTable();
        assertNotNull(tabla, "A tábla nem lehet null.");

        // A játéknak el kell indulnia és be kell fejeződnie (győzelem, döntetlen vagy tele tábla)
        jatek.jatekmenet();

        // Ellenőrizzük, hogy a tábla tele van-e, vagy döntetlen a végeredmény
        // Ha nincs döntetlen, akkor a győzelmet is ellenőrizhetjük
        assertTrue(tabla.Tele() || checkVictory(tabla), "A játéknak vagy döntetlennek kell lennie, vagy győztesnek.");
    }

    // Segéd metódus a győzelem ellenőrzésére
    private boolean checkVictory(Tabla tabla) {
        // Implementáld a győzelem logikáját
        // Például visszaadhatsz egy boolean értéket, ha a játékos nyert
        return false;  // Ehhez az igazi győzelem logikát kell implementálni
    }

    @Test
    void testJatekNormalMod() {
        // Normál módban indítjuk a játékot, ahol a felhasználó lép
        JatekTestImpl jatek = new JatekTestImpl(false); // Normál mód, ahol a felhasználó lép

        // Ellenőrizzük, hogy a tábla inicializálva van-e
        Tabla tabla = jatek.getTable();
        assertNotNull(tabla, "A tábla nem lehet null.");

        // Játék logikájának futtatása (felhasználó és gép felváltva lép)
        jatek.jatekmenet();

        // Ellenőrizzük, hogy véget ért-e a játék (döntetlen vagy nyert)
        assertTrue(tabla.Tele() || tabla.getTabla().length == 0, "A játéknak vagy döntetlennek kell lennie, vagy a táblának meg kell telnie.");
    }

    @Test
    void testJatekRandomLepesek() {
        // Teszt módot állítunk be, hogy automatikusan lépjenek a játékosok
        JatekTestImpl jatek = new JatekTestImpl(true); // Teszt mód, ahol a gép lép

        // A tábla inicializálása
        Tabla tabla = jatek.getTable();
        assertNotNull(tabla, "A tábla nem lehet null.");

        // Automatikusan végigfuttatjuk a játékot, random lépésekkel
        jatek.jatekmenet();

        // Ellenőrizzük, hogy a tábla tele van, vagy véget ért a játék
        assertTrue(tabla.Tele() || tabla.getTabla().length == 0, "A játéknak véget kellett érnie: vagy döntetlen, vagy a tábla tele van.");
    }
}