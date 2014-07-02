import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * De testklasse BibliotheekCLITest.
 *
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class BibliotheekCLITest
{
    private BibliotheekCLI biblioth1;

    /**
     * Default constructor for test class BibliotheekCLITest
     */
    public BibliotheekCLITest()
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
        biblioth1 = new BibliotheekCLI();
        biblioth1.addLid("Piet");
        biblioth1.addLid("Paula");
        biblioth1.addBoek("E-learning 2", "studieboek");
        biblioth1.addCd("Nederklassiek oud", "klassiek", "29021988");
        biblioth1.addVideoband("The Bandit 4", "B");
        biblioth1.addExemplaar(0);
        biblioth1.addExemplaar(1);
        biblioth1.addExemplaar(2);
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
    public void testPrintInfoArtikelen()
    {
        assertEquals(true, biblioth1.addUitlening(0, 0));
        assertEquals(true, biblioth1.addUitlening(0, 1));
        assertEquals(true, biblioth1.addUitlening(0, 2));
        assertEquals(true, biblioth1.inleverenExemplaar(0, 0));
        assertEquals(true, biblioth1.inleverenExemplaar(0, 1));
        assertEquals(true, biblioth1.inleverenExemplaar(0, 2));
        biblioth1.printInfoArtikelen();
    }
}

