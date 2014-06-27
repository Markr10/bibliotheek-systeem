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
}

