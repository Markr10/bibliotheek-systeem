

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BibliotheekTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BibliotheekTest
{
    /**
     * Default constructor for test class BibliotheekTest
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
    public void add3Artikel()
    {
        Bibliotheek biblioth1 = new Bibliotheek();
        biblioth1.addBoek("boek", "Roman", "23082012", "danny", 231472381, 201);
        biblioth1.addCD("CD", "Pop", "Nederpop", "12092006", "Pietje");
        biblioth1.addVideoband("Video", "A", "23042011", 10, "Thriller");
        biblioth1.showArtikelen();
    }
}

