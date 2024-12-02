package jauge;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class jaugeNaturelTest implements IjaugeNaturelTest {
    
	IjaugeNaturel jaugeDsInter;
    IjaugeNaturel jaugeInf;
    IjaugeNaturel jaugeSup;
    IjaugeNaturel  jaugeLimiteViggie;
    IjaugeNaturel  jaugeMaxEqMin;

        
	@Override
	public IjaugeNaturel creerJauge(long a, long b, long val) {
		return new jaugeNaturel(a,b,val);
	}

	@Before
	public void setUp() throws Exception {
	    
		jaugeDsInter = creerJauge(4,6,5);
		jaugeInf = creerJauge(4,6,2);
		jaugeSup = creerJauge(4,6,7);
		jaugeLimiteViggie = creerJauge(8,4,6);
		jaugeMaxEqMin = creerJauge(8,8,6);

	}

	@After
	public void tearDown() throws Exception {
		jaugeDsInter = null;
		jaugeInf = null;
		jaugeSup = null;
		jaugeLimiteViggie = null;
		jaugeMaxEqMin = null;
		
	}

	@Test
	public void testDansIntervalle() {
		assertFalse(jaugeDsInter.estRouge());
		assertFalse(jaugeDsInter.estBleu());
		assertTrue(jaugeDsInter.estVert());
	}
	
    @Test
    public void testInferieurIntervalle() {
        assertTrue(jaugeInf.estBleu());
        assertFalse(jaugeInf.estVert());
        assertFalse(jaugeInf.estRouge());
        
    }
    
    @Test
    public void testSuperieurIntervalle() {
        assertFalse(jaugeSup.estBleu());
        assertFalse(jaugeSup.estVert());
        assertTrue(jaugeSup.estRouge());
    }
    
    @Test
    public void testDeplacement() {
    	jaugeDsInter.decrementer();
        assertFalse(jaugeDsInter.estRouge());
        assertTrue(jaugeDsInter.estBleu());
        assertFalse(jaugeDsInter.estVert());
        
        jaugeDsInter.incrementer();
        assertFalse(jaugeDsInter.estRouge());
        assertFalse(jaugeDsInter.estBleu());
        assertTrue(jaugeDsInter.estVert());
    }

    @Test
    public void testLimiteVigieMaxInferieurVigieMin() {
    	assertNotNull(jaugeLimiteViggie);
    	
    }

    @Test 
    public void testMaxEgaleMin() {
    	assertNotNull(jaugeMaxEqMin);	
    }
}
