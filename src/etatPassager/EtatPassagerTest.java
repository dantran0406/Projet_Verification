package etatPassager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EtatPassagerTest {
    EtatPassager etatPassagerAssis;
    EtatPassager etatPassagerDebout;
    EtatPassager etatPassagerDehors;

 
    @BeforeEach
    void setUp() {
        etatPassagerAssis = new EtatPassager(EtatPassager.Etat.ASSIS);
        etatPassagerDebout = new EtatPassager(EtatPassager.Etat.DEBOUT);
        etatPassagerDehors = new EtatPassager(EtatPassager.Etat.DEHORS);
    }

    @Test
    void testEtatPassagerInitialisation() {
        assertNotNull(etatPassagerAssis);
        assertNotNull(etatPassagerDebout);
        assertNotNull(etatPassagerDehors);
    }

    @Test
    void testEstExterieur() {
        assertTrue(etatPassagerDehors.estExterieur());
        assertFalse(etatPassagerDehors.estAssis());
        assertFalse(etatPassagerDehors.estDebout());
    }

    @Test
    void testEstAssis() {
        assertTrue(etatPassagerAssis.estAssis());
        assertFalse(etatPassagerAssis.estExterieur());
        assertFalse(etatPassagerAssis.estDebout());
    }

    @Test
    void testEstDebout() {
        assertTrue(etatPassagerDebout.estDebout());
        assertFalse(etatPassagerDebout.estAssis());
        assertFalse(etatPassagerDebout.estExterieur());
    }

    @Test
    void testEstInterieur() {
        assertTrue(etatPassagerAssis.estInterieur());
        assertTrue(etatPassagerDebout.estInterieur());
        assertFalse(etatPassagerDehors.estInterieur());
    }

    @Test
    void testToString() {
        assertEquals("<ASSIS>", etatPassagerAssis.toString());
        assertEquals("<DEBOUT>", etatPassagerDebout.toString());
        assertEquals("<DEHORS>", etatPassagerDehors.toString());
    }
}


