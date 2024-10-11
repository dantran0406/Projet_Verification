package etatPassager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EtatPassagerChaineTest implements IEtatPassagerTest {
    IEtatPassager etatPassagerAssis;
    IEtatPassager etatPassagerDebout;
    IEtatPassager etatPassagerDehors;

    @BeforeEach
    public void setUp() {
        etatPassagerAssis = new EtatPassagerChaine(EtatPassagerChaine.Etat.ASSIS);
        etatPassagerDebout = new EtatPassagerChaine(EtatPassagerChaine.Etat.DEBOUT);
        etatPassagerDehors = new EtatPassagerChaine(EtatPassagerChaine.Etat.DEHORS);
    }

    @Test
    void testEtatPassagerInitialisation() {
        assertNotNull(etatPassagerAssis);
        assertNotNull(etatPassagerDebout);
        assertNotNull(etatPassagerDehors);
    }

    @Test
    public void testEstExterieur() {
        assertTrue(etatPassagerDehors.estExterieur());
        assertFalse(etatPassagerDehors.estAssis());
        assertFalse(etatPassagerDehors.estDebout());
    }

    @Test
    public void testEstAssis() {
        assertTrue(etatPassagerAssis.estAssis());
        assertFalse(etatPassagerAssis.estExterieur());
        assertFalse(etatPassagerAssis.estDebout());
    }

    @Test
    public void testEstDebout() {
        assertTrue(etatPassagerDebout.estDebout());
        assertFalse(etatPassagerDebout.estAssis());
        assertFalse(etatPassagerDebout.estExterieur());
    }

    @Test
    public void testEstInterieur() {
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

    @Override
    public IEtatPassager creerAssis() {
        return new EtatPassagerChaine(EtatPassagerChaine.Etat.ASSIS);
    }

    @Override
    public IEtatPassager creerDehors() {
        return new EtatPassagerChaine(EtatPassagerChaine.Etat.DEHORS);
    }

    @Override
    public IEtatPassager creerDebout() {
        return new EtatPassagerChaine(EtatPassagerChaine.Etat.DEBOUT);
    }

	@Override
	public void tearDown() throws Exception {
		
	}

	@Override
	public void testEtatPassager() {
		
	}
}



