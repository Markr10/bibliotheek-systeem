import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;

/**
 * The test class SpecialDateTest.
 *
 * @author      Mark, Wybren en Danny
 * @custom.date April 7 2014
 * @version     3.00
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
     * It can fail on someday because it calculates
     * the difference (years) between the start date and today.
     * Then the expected result may be adjusted.
     */
    @Test
    public void testYearsDifference()
    {
        assertEquals(1, SpecialDate.yearsDifference("04062013"));
        assertEquals(1, SpecialDate.yearsDifference("03062013"));
        assertEquals(1, SpecialDate.yearsDifference("07112012"));
        assertEquals(3, SpecialDate.yearsDifference("16052011"));
        assertEquals(0, SpecialDate.yearsDifference("05112013"));
        assertEquals(0, SpecialDate.yearsDifference("07112013"));
    }
    
    /**
     * Test the method roundedYearsDifference.
     * It can fail on someday because it calculates
     * the difference (years) between the start date and today.
     * Then the expected result may be adjusted.
     */
    @Test
    public void testRoundedYearsDifference()
    {
        assertEquals(0, SpecialDate.roundedYearsDifference("07032014"));
        assertEquals(1, SpecialDate.roundedYearsDifference("04062013"));
        assertEquals(1, SpecialDate.roundedYearsDifference("07112012"));
        assertEquals(4, SpecialDate.roundedYearsDifference("03072011"));
        assertEquals(4, SpecialDate.roundedYearsDifference("16052011"));
        assertEquals(0, SpecialDate.roundedYearsDifference("05112013"));
        assertEquals(0, SpecialDate.roundedYearsDifference("07112013"));
    }
    
    /**
     * Test the method yearsDifference with an invalid argument.
     */
    @Test
    public void testInvalidArgumentYearsDifference()
    {
        assertEquals(-1, SpecialDate.yearsDifference("wrong"));
        assertEquals(-1, SpecialDate.yearsDifference(""));
        assertEquals(-1, SpecialDate.daysDifference("05152013"));
    }

    /**
     * Test the method dateToMilliseconds.
     */
    @Test
    public void testDateToMilliseconds()
    {
        assertEquals(1383696000000L, SpecialDate.dateToMilliseconds("06112013"));
        assertEquals(1383782400000L, SpecialDate.dateToMilliseconds("07112013"));
    }
    
    /**
     * Test the method dateToMilliseconds with an invalid argument.
     */
    @Test
    public void testInvalidDateToMilliseconds()
    {
        assertEquals(-1, SpecialDate.dateToMilliseconds("wrong"));
        assertEquals(-1, SpecialDate.dateToMilliseconds(""));
        assertEquals(-1, SpecialDate.daysDifference("05152013"));
    }

    /**
     * Test the method getDateToday.
     * It can fail on someday because it returns the date of today.
     */
    @Test
    public void testGetDateToday()
    {
        assertEquals("06072014", SpecialDate.getDateToday());
    }
    
    /**
     * Test the method daysDifference.
     * It can fail on someday because it calculates
     * the difference (days) between the start date and today.
     * Then the expected result may be adjusted.
     */
    @Test
    public void testDaysDifference()
    {
        assertEquals(0, SpecialDate.daysDifference("06072014"));
        assertEquals(605, SpecialDate.daysDifference("08112012"));
        assertEquals(1146, SpecialDate.daysDifference("17052011"));
        assertEquals(1, SpecialDate.daysDifference(SpecialDate.addDays(SpecialDate.getDateToday(), -1)));
        assertEquals(0, SpecialDate.daysDifference(SpecialDate.getDateToday()));
    }
    
    /**
     * Test the method daysDifference with an invalid argument.
     */
    @Test
    public void testInvalidArgumentDaysDifference()
    {
        assertEquals(-1, SpecialDate.daysDifference("wrong"));
        assertEquals(-1, SpecialDate.daysDifference(""));
        assertEquals(-1, SpecialDate.daysDifference("05152013"));
    }
    
    /**
     * Test the method daysDifference with two arguments.
     */
    @Test
    public void testDaysDifferenceTwoArguments()
    {
        assertEquals(564, SpecialDate.daysDifference("07112012", "25052014"));
        assertEquals(1105, SpecialDate.daysDifference("16052011", "25052014"));
        assertEquals(1, SpecialDate.daysDifference("24052014", "25052014"));
        assertEquals(0, SpecialDate.daysDifference("25052014", "25052014"));
        assertEquals(-564, SpecialDate.daysDifference("25052014", "07112012"));
        assertEquals(-1105, SpecialDate.daysDifference("25052014", "16052011"));
        assertEquals(-2, SpecialDate.daysDifference("25052014", "23052014"));
    }
    
    /**
     * Test the method daysDifference with two invalid arguments.
     */
    @Test
    public void testInvalidArgumentDaysDifferenceTwoArguments()
    {
        assertEquals(-1, SpecialDate.daysDifference("wrong", "wrong"));
        assertEquals(-1, SpecialDate.daysDifference("wrong", "25052014"));
        assertEquals(-1, SpecialDate.daysDifference("25052014", "wrong"));
        assertEquals(-1, SpecialDate.daysDifference("", ""));
        assertEquals(-1, SpecialDate.daysDifference("", "25052014"));
        assertEquals(-1, SpecialDate.daysDifference("25052014",""));
        assertEquals(-1, SpecialDate.daysDifference("05152013", "05152013"));
        assertEquals(-1, SpecialDate.daysDifference("25052014", "05152013"));
        assertEquals(-1, SpecialDate.daysDifference("05152013", "25052014"));
    }

    /**
     * Test the method checkDate.
     * It can fail on someday because it uses a date in the future.
     * Then the expected result may be adjusted.
     */
    @Test
    public void testCheckDate()
    {
        assertEquals(true, SpecialDate.checkDate(SpecialDate.getDateToday()));
        assertEquals(true, SpecialDate.checkDate("01011900"));
        assertEquals(true, SpecialDate.checkDate("29022008"));
        assertEquals(true, SpecialDate.checkDate("15052013"));
        assertEquals(false, SpecialDate.checkDate("05152013"));
        assertEquals(false, SpecialDate.checkDate("84072013"));
        assertEquals(false, SpecialDate.checkDate("05052015"));
        assertEquals(false, SpecialDate.checkDate("29022011"));
        assertEquals(false, SpecialDate.checkDate("wrong"));
        assertEquals(false, SpecialDate.checkDate(""));
    }
    
    /**
     * Test the method checkDateNowAndFuture.
     * It can fail on someday because it uses a date in the future.
     * Then the expected result may be adjusted.
     */
    @Test
    public void testCheckDateNowAndFuture()
    {
        assertEquals(true, SpecialDate.checkDateNowAndFuture(SpecialDate.getDateToday()));
        assertEquals(true, SpecialDate.checkDateNowAndFuture("05052015"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("01011900"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("29022008"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("15052013"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("05152013"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("84072013"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("29022011"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture("wrong"));
        assertEquals(false, SpecialDate.checkDateNowAndFuture(""));
    }
    
    /**
     * Test the method checkFormatDate.
     * It can fail on someday because it uses a date in the future.
     * Then the expected result may be adjusted.
     */
    @Test
    public void testCheckFormatDate()
    {
        assertEquals(true, SpecialDate.checkFormatDate(SpecialDate.getDateToday()));
        assertEquals(true, SpecialDate.checkFormatDate("01011900"));
        assertEquals(true, SpecialDate.checkFormatDate("29022008"));
        assertEquals(true, SpecialDate.checkFormatDate("15052013"));
        assertEquals(true, SpecialDate.checkFormatDate("05052015"));
        assertEquals(false, SpecialDate.checkFormatDate("05152013"));
        assertEquals(false, SpecialDate.checkFormatDate("84072013"));
        assertEquals(false, SpecialDate.checkFormatDate("29022011"));
        assertEquals(false, SpecialDate.checkFormatDate("wrong"));
        assertEquals(false, SpecialDate.checkFormatDate(""));
    }

    /**
     * Test the method addDays.
     */
    @Test
    public void testAddDays()
    {
        assertEquals(null, SpecialDate.addDays("29022013", 5));
        assertEquals("01062014", SpecialDate.addDays("26052014", 6));
        assertEquals("01012014", SpecialDate.addDays("01012013", 365));
        assertEquals("31122012", SpecialDate.addDays("01012012", 365));
        assertEquals("03032012", SpecialDate.addDays("29022012", 3));
        assertEquals("02032008", SpecialDate.addDays("28022008", 3));
        assertEquals("15042014", SpecialDate.addDays("20042014", -5));
        assertEquals("20042014", SpecialDate.addDays("20042014", 0));
    }
}
