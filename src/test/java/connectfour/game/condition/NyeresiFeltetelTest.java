package connectfour.game.condition;

import connectfour.game.condition.NyeresiFeltetel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NyeresiFeltetelTest {

  // Teszt a vízszintes győzelem ellenőrzésére
  @Test
  public void testVízszintesGyőzelem() {
    char[][] tabla = {
        {'X', 'X', 'X', 'X', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    NyeresiFeltetel nyeresiFeltetel = new NyeresiFeltetel();

    // A tesztnek igennel kell válaszolnia, mert az "X" vízszintesen nyer
    assertTrue(nyeresiFeltetel.gyozelemEll(tabla, 'X'));
  }

  // Teszt a függőleges győzelem ellenőrzésére
  @Test
  public void testFuggolegesGyőzelem() {
    char[][] tabla = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        {'X', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    NyeresiFeltetel nyeresiFeltetel = new NyeresiFeltetel();

    // A tesztnek igennel kell válaszolnia, mert az "X" függőlegesen nyer
    assertTrue(nyeresiFeltetel.gyozelemEll(tabla, 'X'));
  }

  // Teszt az átlós győzelem balról jobbra
  @Test
  public void testAtlosBalrolJobbraGyőzelem() {
    char[][] tabla = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', 'X', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', 'X', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', 'X', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', 'X', ' '}
    };

    NyeresiFeltetel nyeresiFeltetel = new NyeresiFeltetel();

    // A tesztnek igennel kell válaszolnia, mert az "X" átlósan balról jobbra nyer
    assertTrue(nyeresiFeltetel.gyozelemEll(tabla, 'X'));
  }

  // Teszt az átlós győzelem jobbról balra
  @Test
  public void testAtlosJobbrolBalraGyőzelem() {
    char[][] tabla = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', 'X', ' ', ' ', ' '},
        {' ', ' ', 'X', ' ', ' ', ' ', ' '},
        {' ', 'X', ' ', ' ', ' ', ' ', ' '},
        {'X', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    NyeresiFeltetel nyeresiFeltetel = new NyeresiFeltetel();

    // A tesztnek igennel kell válaszolnia, mert az "X" átlósan jobbról balra nyer
    assertTrue(nyeresiFeltetel.gyozelemEll(tabla, 'X'));
  }
}