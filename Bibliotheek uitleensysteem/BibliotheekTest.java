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
    private Bibliotheek biblioth3;

    
    

    
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
        biblioth1.addCd("Nederpop", "populair", "12092006");
        biblioth1.addVideoband("The Bandit", "A");
        biblioth2 = new Bibliotheek();
        biblioth3 = new Bibliotheek();
        biblioth3.addLid("Piet");
        biblioth3.addLid("Paula");
        biblioth3.addBoek("E-learning 2", "studieboek");
        biblioth3.addCd("Nederklassiek oud", "klassiek", "29021988");
        biblioth3.addVideoband("The Bandit 4", "B");
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

    @Test
    public void testAddCd()
    {
        assertEquals(false, biblioth2.addCd("Nederpop 1", "POP", "12092006"));
        assertEquals(false, biblioth2.addCd("Nederpop 2", "POP", "test"));
        assertEquals(true, biblioth2.addCd("Nederpop 3", "POPuLaiR", "12092006"));
        assertEquals(false, biblioth2.addCd("Nederpop 4", "POPuLaiR", "test"));
        assertEquals(false, biblioth2.addCd("Nederpop 5", "POPuLaiR", "12092015"));
        assertEquals(true, biblioth2.addCd("Nederpop 6", "POPuLaiR", SpecialDate.getDateToday()));
        assertEquals(true, biblioth2.addCd("Nederpop oud", "POPuLaiR", "29021988"));
        assertEquals(false, biblioth2.addCd("Nederklassiek 1", "classic", "12092006"));
        assertEquals(false, biblioth2.addCd("Nederklassiek 2", "classic", "test"));
        assertEquals(true, biblioth2.addCd("Nederklassiek 3", "KLASSIEK", "12092006"));
        assertEquals(true, biblioth2.addCd("Nederklassiek 4", "klassiek", "12092006"));
        assertEquals(true, biblioth2.addCd("Nederklassiek 5", "klAssIek", "12092006"));
        assertEquals(true, biblioth2.addCd("Nederklassiek 6", "klAssIek", "12092006"));
        assertEquals(false, biblioth2.addCd("Nederklassiek 7", "klAssIek", "test"));
        assertEquals(false, biblioth2.addCd("Nederklassiek 8", "klAssIek", "12092015"));
        assertEquals(true, biblioth2.addCd("Nederklassiek 9", "klAssIek", SpecialDate.getDateToday()));
        assertEquals(true, biblioth2.addCd("Nederklassiek oud", "klAssIek", "29021988"));
        assertEquals(9, biblioth2.artikelen.size());
        assertEquals("Nederpop 3", biblioth2.artikelen.get(0).getTitel());
        assertEquals(CdType.valueOf("POPULAIR"), biblioth2.artikelen.get(0).getType());
        assertEquals(0, biblioth2.artikelen.get(0).getID());
        assertEquals("12092006", ((Cd)biblioth2.artikelen.get(0)).getReleasedatum());
        assertEquals("Nederklassiek oud", biblioth2.artikelen.get(8).getTitel());
        assertEquals(CdType.valueOf("KLASSIEK"), biblioth2.artikelen.get(8).getType());
        assertEquals(8, biblioth2.artikelen.get(8).getID());
        assertEquals("29021988", ((Cd)biblioth2.artikelen.get(8)).getReleasedatum());
    }
    
    @Test
    public void testAddVideoband()
    {
        assertEquals(true, biblioth2.addVideoband("The Bandit", "A"));
        assertEquals(false, biblioth2.addVideoband("The Bandit 2", "c"));
        assertEquals(false, biblioth2.addVideoband("The Bandit 3", "test"));
        assertEquals(true, biblioth2.addVideoband("The Bandit 4", "b"));
        assertEquals(2, biblioth2.artikelen.size());
        assertEquals("The Bandit", biblioth2.artikelen.get(0).getTitel());
        assertEquals(VideobandType.valueOf("A"), biblioth2.artikelen.get(0).getType());
        assertEquals(0, biblioth2.artikelen.get(0).getID());
        assertEquals("The Bandit 4", biblioth2.artikelen.get(1).getTitel());
        assertEquals(VideobandType.valueOf("B"), biblioth2.artikelen.get(1).getType());
        assertEquals(1, biblioth2.artikelen.get(1).getID());
    }

    @Test
    public void testAddExemplaar()
    {
        assertEquals(true, biblioth1.addExemplaar(2));
        assertEquals(true, biblioth1.addExemplaar(0));
        assertEquals(true, biblioth1.addExemplaar(1));
        assertEquals(false, biblioth1.addExemplaar(3));
        assertEquals(3, biblioth1.exemplaren.size());
        assertEquals(0, biblioth1.exemplaren.get(0).getID());
        assertEquals(2, biblioth1.exemplaren.get(0).getArtikelID());
        assertEquals(1, biblioth1.exemplaren.get(1).getID());
        assertEquals(0, biblioth1.exemplaren.get(1).getArtikelID());
        assertEquals(2, biblioth1.exemplaren.get(2).getID());
        assertEquals(1, biblioth1.exemplaren.get(2).getArtikelID());
    }

    @Test
    public void testAddReservering()
    {
        assertEquals(true, biblioth3.leden.get(1).setEersteBrief());
        biblioth3.leden.get(1).tweedeBrief = SpecialDate.addDays(SpecialDate.getDateToday(), (-Bibliotheek.MAX_AANTAL_DAGEN_NA_TWEEDE_BRIEF - 1));
        assertEquals(true, biblioth3.leden.get(1).setGeroyeerd());
        assertEquals(true, biblioth3.leden.get(1).isGeroyeerd());
        assertEquals(true, biblioth3.addReservering(0, 0));
        assertEquals(false, biblioth3.addReservering(0, 3));
        assertEquals(false, biblioth3.addReservering(2, 0));
        assertEquals(false, biblioth3.addReservering(2, 3));
        assertEquals(false, biblioth3.addReservering(1, 0));
        assertEquals(false, biblioth3.addReservering(1, 3));
    }
}






