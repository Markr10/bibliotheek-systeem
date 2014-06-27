import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;

/**
 * The test class SpecialDateTest.
 *
 * @author                             Mark Roelans
 * @custom.date                        November 12 2013
 * @version                            1.00
 */
public class SpecialDateTest
{
    /**
     * Default constructor for test class SpecialDateTest
     */
    public SpecialDateTest()
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
    
    /**
     * Test the method yearsDifference.
     */
    @Test
    public void testYearsDifference()
    {
        assertEquals(1, SpecialDate.yearsDifference("07112012"));
        assertEquals(2, SpecialDate.yearsDifference("16052011"));
        assertEquals(0, SpecialDate.yearsDifference("05112013"));
        assertEquals(0, SpecialDate.yearsDifference("07112013"));
    }
    
    /**
     * Test the method yearsDifference with an invalid argument.
     */
    @Test
    public void testInvalidArgumentYearsDifference()
    {
        assertEquals(-1, SpecialDate.yearsDifference("wrong"));
        assertEquals(-1, SpecialDate.yearsDifference(""));
    }

    /**
     * Test the method dateToMilliseconds.
     */
    @Test
    public void testDateToMilliseconds()
    {
        assertEquals(1383692400000L, SpecialDate.dateToMilliseconds("06112013"));
        assertEquals(1383778800000L, SpecialDate.dateToMilliseconds("07112013"));
    }
    
    /**
     * Test the method dateToMilliseconds with an invalid argument.
     */
    @Test
    public void testInvalidDateToMilliseconds()
    {
        assertEquals(-1, SpecialDate.dateToMilliseconds("wrong"));
        assertEquals(-1, SpecialDate.dateToMilliseconds(""));
    }
}