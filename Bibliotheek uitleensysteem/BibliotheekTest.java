import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * De testklasse BibliotheekTest.
 *
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class BibliotheekTest
{
    private Bibliotheek biblioth1;
    private Bibliotheek biblioth2;

    
    /**
     * Default constructor for test class BibliotheekTest.
     */
    public BibliotheekTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        // Bibliotheek met 3 artikelen.
        biblioth1 = new Bibliotheek();
        biblioth1.addBoek("Roman Empire", "Roman");
        biblioth1.addCd("Nederpop", "Pop", "12092006");
        biblioth1.addVideoband("The Bandit", "A");
        biblioth2 = new Bibliotheek();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddLid()
    {
        biblioth2.addLid("Paula");
        biblioth2.addLid("Piet");
        assertEquals(2, biblioth2.leden.size());
        assertEquals("Paula", biblioth2.leden.get(0).getNaam());
        assertEquals(0, biblioth2.leden.get(0).getID());
        assertEquals("Piet", biblioth2.leden.get(1).getNaam());
        assertEquals(1, biblioth2.leden.get(1).getID());
    }

    @Test
    public void testAddBoek()
    {
        assertEquals(true, biblioth2.addBoek("Roman Empire", "Roman"));
        assertEquals(false, biblioth2.addBoek("Roman Empire 2", "R"));
        assertEquals(false, biblioth2.addBoek("E-learning", "S"));
        assertEquals(true, biblioth2.addBoek("E-learning 2", "sTuDieBoEk"));
        assertEquals(2, biblioth2.artikelen.size());
        assertEquals("Roman Empire", biblioth2.artikelen.get(0).getTitel());
        assertEquals(BoekType.valueOf("ROMAN"), biblioth2.artikelen.get(0).getType());
        assertEquals(0, biblioth2.artikelen.get(0).getID());
        assertEquals("E-learning 2", biblioth2.artikelen.get(1).getTitel());
        assertEquals(BoekType.valueOf("STUDIEBOEK"), biblioth2.artikelen.get(1).getType());
        assertEquals(1, biblioth2.artikelen.get(1).getID());
    }
}



