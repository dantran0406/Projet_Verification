package jauge;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class jaugeDistanceTest implements IjaugeNaturelTest {
    IjaugeNaturel jaugeDsInter;
    IjaugeNaturel jaugeInf;
    IjaugeNaturel jaugeSup;
    IjaugeNaturel jaugeLimitVigie;
    IjaugeNaturel jaugeMaxEqMin;
    IjaugeNaturel jaugeSuperieur;
    
    
    @Override
	public IjaugeNaturel creerJauge(long a, long b, long val) {
		return new jaugeDistance(a,b,val);
	}

    
    @Before
    public void setUp() throws Exception {
        
        jaugeDsInter = creerJauge(10,20,11);
        jaugeInf= creerJauge(10,20,10);
        jaugeSup = creerJauge(10,20,30);
        jaugeLimitVigie = creerJauge(20,10,15);
        jaugeMaxEqMin = creerJauge(15,15,10);
        jaugeSuperieur = creerJauge(15,15,20);
    }
    @After
    public void tearDown() throws Exception {
        jaugeDsInter = null;
		jaugeInf = null;
		jaugeSup = null;
		jaugeLimitVigie = null;
		jaugeMaxEqMin = null;
		jaugeSuperieur =null;
		

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
        jaugeDsInter.decrementer();
        assertFalse(jaugeDsInter.estRouge());
        assertTrue(jaugeDsInter.estBleu());
        assertFalse(jaugeDsInter.estVert());
        
        jaugeDsInter.incrementer();
        jaugeDsInter.incrementer();
        assertFalse(jaugeDsInter.estRouge());
        assertFalse(jaugeDsInter.estBleu());
        assertTrue(jaugeDsInter.estVert());
    }
    
    @Test
    public void testLimiteVigieMaxInferieurVigieMin() {
        assertNotNull(jaugeLimitVigie);
    }
    
    @Test
    public void testMaxEgaleMin() {
        assertNotNull(jaugeMaxEqMin);
    }
}