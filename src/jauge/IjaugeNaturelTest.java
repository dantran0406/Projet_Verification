package jauge;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public interface IjaugeNaturelTest {

	public IjaugeNaturel creerJauge(long a , long b, long val);
	
    @After
	public void setUp() throws Exception;
	
    @Before
	public void tearDown() throws Exception;

	@Test
	public void testDansIntervalle();
	
	@Test
    public void testInferieurIntervalle();
 
	
	@Test
    public void testSuperieurIntervalle();

	
	@Test
    public void testDeplacement();

	@Test
    public void testLimiteVigieMaxInferieurVigieMin();

	@Test
    public void testMaxEgaleMin();   
}
