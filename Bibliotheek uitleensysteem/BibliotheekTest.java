import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BibliotheekTest.
 *
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class BibliotheekTest
{
    private Bibliotheek biblioth1;
    private Bibliotheek biblioth2;
    private Bibliotheek biblioth3;
    private Bibliotheek biblioth4;
    private Bibliotheek biblioth5;
    private Bibliotheek biblioth6;

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

        biblioth4 = new Bibliotheek();
        biblioth4.addLid("Piet");
        biblioth4.addLid("Paula");
        biblioth4.leden.get(1).geroyeerd = true;
        assertEquals(true, biblioth4.leden.get(1).isGeroyeerd());
        biblioth4.addBoek("E-learning 2", "studieboek");
        biblioth4.addCd("Nederklassiek oud", "klassiek", "29021988");
        biblioth4.addVideoband("The Bandit 4", "B");
        biblioth4.addExemplaar(0);
        biblioth4.addExemplaar(1);
        biblioth4.addExemplaar(2);

        biblioth5 = new Bibliotheek();
        biblioth5.addLid("Piet");
        biblioth5.addLid("Paula");
        biblioth5.addBoek("E-learning 2", "studieboek");
        biblioth5.addCd("Nederklassiek oud", "klassiek", "29021988");
        biblioth5.addVideoband("The Bandit 4", "B");
        biblioth5.addExemplaar(0);
        biblioth5.addExemplaar(1);
        biblioth5.addExemplaar(2);

        biblioth6 = new Bibliotheek();
        biblioth6.addLid("Piet");
        biblioth6.addLid("Paula");
        biblioth6.addBoek("E-learning 2", "studieboek");
        biblioth6.addCd("Nederklassiek oud", "klassiek", "29021988");
        biblioth6.addVideoband("The Bandit 4", "B");
        biblioth6.addExemplaar(0);
        biblioth6.addExemplaar(1);
        biblioth6.addExemplaar(2);
        biblioth6.addUitlening(0, 0);
        biblioth6.addUitlening(0, 1);
        biblioth6.addUitlening(0, 2);
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
    public void testAddBoek()
    {
        assertEquals(0, biblioth2.addBoek("Roman Empire", "Roman"));
        assertEquals(-1, biblioth2.addBoek("Roman Empire 2", "R"));
        assertEquals(-1, biblioth2.addBoek("E-learning", "S"));
        assertEquals(1, biblioth2.addBoek("E-learning 2", "sTuDieBoEk"));
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
        assertEquals(-1, biblioth2.addCd("Nederpop 1", "POP", "12092006"));
        assertEquals(-1, biblioth2.addCd("Nederpop 2", "POP", "test"));
        assertEquals(0, biblioth2.addCd("Nederpop 3", "POPuLaiR", "12092006"));
        assertEquals(-1, biblioth2.addCd("Nederpop 4", "POPuLaiR", "test"));
        assertEquals(-1, biblioth2.addCd("Nederpop 5", "POPuLaiR", "12092015"));
        assertEquals(1, biblioth2.addCd("Nederpop 6", "POPuLaiR", SpecialDate.getDateToday()));
        assertEquals(2, biblioth2.addCd("Nederpop oud", "POPuLaiR", "29021988"));
        assertEquals(-1, biblioth2.addCd("Nederklassiek 1", "classic", "12092006"));
        assertEquals(-1, biblioth2.addCd("Nederklassiek 2", "classic", "test"));
        assertEquals(3, biblioth2.addCd("Nederklassiek 3", "KLASSIEK", "12092006"));
        assertEquals(4, biblioth2.addCd("Nederklassiek 4", "klassiek", "12092006"));
        assertEquals(5, biblioth2.addCd("Nederklassiek 5", "klAssIek", "12092006"));
        assertEquals(6, biblioth2.addCd("Nederklassiek 6", "klAssIek", "12092006"));
        assertEquals(-1, biblioth2.addCd("Nederklassiek 7", "klAssIek", "test"));
        assertEquals(-1, biblioth2.addCd("Nederklassiek 8", "klAssIek", "12092015"));
        assertEquals(7, biblioth2.addCd("Nederklassiek 9", "klAssIek", SpecialDate.getDateToday()));
        assertEquals(8, biblioth2.addCd("Nederklassiek oud", "klAssIek", "29021988"));
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
        assertEquals(0, biblioth2.addVideoband("The Bandit", "A"));
        assertEquals(-1, biblioth2.addVideoband("The Bandit 2", "c"));
        assertEquals(-1, biblioth2.addVideoband("The Bandit 3", "test"));
        assertEquals(1, biblioth2.addVideoband("The Bandit 4", "b"));
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
        assertEquals(0, biblioth1.addExemplaar(2));
        assertEquals(1, biblioth1.addExemplaar(0));
        assertEquals(2, biblioth1.addExemplaar(1));
        assertEquals(-1, biblioth1.addExemplaar(3));
        assertEquals(3, biblioth1.exemplaren.size());
        assertEquals(0, biblioth1.exemplaren.get(0).getID());
        assertEquals(2, biblioth1.exemplaren.get(0).getArtikelID());
        assertEquals(1, biblioth1.exemplaren.get(1).getID());
        assertEquals(0, biblioth1.exemplaren.get(1).getArtikelID());
        assertEquals(2, biblioth1.exemplaren.get(2).getID());
        assertEquals(1, biblioth1.exemplaren.get(2).getArtikelID());
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
    public void testAddReservering()
    {
        assertEquals(true, biblioth4.addReservering(0, 0));
        assertEquals(false, biblioth4.addReservering(0, 3));
        assertEquals(false, biblioth4.addReservering(2, 0));
        assertEquals(false, biblioth4.addReservering(2, 3));
        assertEquals(false, biblioth4.addReservering(1, 0));
        assertEquals(false, biblioth4.addReservering(1, 3));
    }

    @Test
    public void testAddUitlening()
    {
        assertEquals(true, biblioth5.addUitlening(0, 0));
        assertEquals(true, biblioth5.addUitlening(0, 1));
        assertEquals(true, biblioth5.addUitlening(0, 2));
        assertEquals(false, biblioth5.addUitlening(0, 3));
        assertEquals(false, biblioth5.addUitlening(2, 0));
        assertEquals(false, biblioth5.addUitlening(0, -1));
        assertEquals(false, biblioth5.addUitlening(-1, 0));
    }

    @Test
    public void testInleverenExemplaar()
    {
        assertEquals(false, biblioth6.addUitlening(0, 3));
        assertEquals(false, biblioth6.addUitlening(2, 0));
        assertEquals(false, biblioth6.addUitlening(0, -1));
        assertEquals(false, biblioth6.addUitlening(-1, 0));
        assertEquals(true, biblioth6.inleverenExemplaar(0, 0));
        assertEquals(true, biblioth6.inleverenExemplaar(0, 1));
        assertEquals(true, biblioth6.inleverenExemplaar(0, 2));
    }

    @Test
    public void testImporteerLeden()
    {
        assertNull(biblioth2.importeerLeden("test/leden.csv"));
        assertEquals(2, biblioth2.leden.size());
        assertEquals("Paula", biblioth2.leden.get(0).getNaam());
        assertEquals(0, biblioth2.leden.get(0).getID());
        assertEquals("Piet", biblioth2.leden.get(1).getNaam());
        assertEquals(1, biblioth2.leden.get(1).getID());
    }

    @Test
    public void testImporteerCdsAndExemplaren()
    {
        java.lang.Exception exceptio1 = biblioth2.importeerCdsAndExemplaren("test/cds.csv");
        assertNotNull(exceptio1);
        assertEquals("Rij bevat onjuiste gegevens. Bijbehorende regel in het CSV-bestand: \"Nederklassiek 7,klAssIek,test,1\"", exceptio1.getMessage());
        assertEquals(2, biblioth2.artikelen.size());
        assertEquals("Nederpop oud", biblioth2.artikelen.get(0).getTitel());
        assertEquals(CdType.valueOf("POPULAIR"), biblioth2.artikelen.get(0).getType());
        assertEquals(0, biblioth2.artikelen.get(0).getID());
        assertEquals("29021988", ((Cd)biblioth2.artikelen.get(0)).getReleasedatum());
        assertEquals("Nederklassiek 4", biblioth2.artikelen.get(1).getTitel());
        assertEquals(CdType.valueOf("KLASSIEK"), biblioth2.artikelen.get(1).getType());
        assertEquals(1, biblioth2.artikelen.get(1).getID());
        assertEquals("12092006", ((Cd)biblioth2.artikelen.get(1)).getReleasedatum());
        assertEquals(1, biblioth2.exemplaren.size());
        assertEquals(0, biblioth2.exemplaren.get(0).getID());
        assertEquals(1, biblioth2.exemplaren.get(0).getArtikelID());
    }
}
