package jauge.test;

import jauge.JaugeNaturel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JaugeNaturelTest {
	
	private void testExceptionControlee() throws ClassNotFoundException {
        throw new ClassNotFoundException("Classe non trouvée pour le test.");
    }

    public void methodeAppelante() throws ClassNotFoundException {
        testExceptionControlee(); // Appel indirect
    }

    @Test
    public void testLeverExceptionControleeIndirecte() {
        assertThrows(ClassNotFoundException.class, () -> {
            methodeAppelante();
        });
    }

    
    @Test
    public void testCreationNonValide() {
        // Test avec vigieMin >= vigieMax
        assertThrows(IllegalArgumentException.class, () -> new JaugeNaturel(10, 5, 7));

        // Test avec depart hors des bornes
        assertThrows(IllegalArgumentException.class, () -> new JaugeNaturel(0, 10, -1));
        assertThrows(IllegalArgumentException.class, () -> new JaugeNaturel(0, 10, 11));
    }

    @Test
    public void testCreationValide() {
        // Cas valide
        JaugeNaturel jauge = new JaugeNaturel(0, 10, 5);
        assertEquals(5, jauge.getValeur());
    }

    @Test
    public void testEtatRouge() {
        JaugeNaturel jauge = new JaugeNaturel(0, 10, 10);
        assertTrue(jauge.estRouge());
    }

    @Test
    public void testIncrementer() {
        JaugeNaturel jauge = new JaugeNaturel(0, 10, 5);
        jauge.incrementer();
        assertEquals(6, jauge.getValeur());
    }
}
