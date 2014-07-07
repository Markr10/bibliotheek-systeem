import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * De testklasse ExemplaarTest.
 *
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class ExemplaarTest
{
    private Exemplaar exemplaa1;

    /**
     * Default constructor for test class ExemplaarTest
     */
    public ExemplaarTest()
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
        exemplaa1 = new Exemplaar(3, 4);
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
    public void testGetID()
    {
        assertEquals(3, exemplaa1.getID());
    }

    @Test
    public void testGetArtikelID()
    {
        assertEquals(4, exemplaa1.getArtikelID());
    }
}
