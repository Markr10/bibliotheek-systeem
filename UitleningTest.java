import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * De testklasse UitleningTest.
 *
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class UitleningTest
{
    private Uitlening uitlenin1;

    /**
     * Default constructor for test class UitleningTest.
     */
    public UitleningTest()
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
        uitlenin1 = new Uitlening(3, 7, 5);
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
        assertEquals(3, uitlenin1.getID());
    }

    @Test
    public void testGetLidID()
    {
        assertEquals(7, uitlenin1.getLidID());
    }

    @Test
    public void testGetExemplaarID()
    {
        assertEquals(5, uitlenin1.getExemplaarID());
    }

    @Test
    public void testGetUitleendatum()
    {
        assertEquals(SpecialDate.getDateToday(), uitlenin1.getUitleendatum());
    }
    
    @Test
    public void testGetTerugbrengdatum()
    {
        assertNull(uitlenin1.getTerugbrengdatum());
        assertEquals(true, uitlenin1.setTerugbrengdatum());
        assertEquals(SpecialDate.getDateToday(), uitlenin1.getTerugbrengdatum());
    }

    /**
     * Method TestSetTerugbrengdatum
     * It can fail on someday because it uses a date in the future.
     * Then the expected result may be adjusted.
     */
    @Test
    public void TestSetTerugbrengdatum()
    {
        assertNull(uitlenin1.getTerugbrengdatum());
        assertEquals(true, uitlenin1.setTerugbrengdatum());
        assertEquals(SpecialDate.getDateToday(), uitlenin1.getTerugbrengdatum());
        assertEquals(false, uitlenin1.setTerugbrengdatum());
        assertEquals(SpecialDate.getDateToday(), uitlenin1.getTerugbrengdatum());
    }
    
//     @Test // NOTE: Waarschijnlijk overbodig
//     public void testGetTerugbrengdatumOneArgument()
//     {
//         assertNull(uitlenin1.getTerugbrengdatum());
//         assertEquals(true, uitlenin1.setTerugbrengdatum("08042014"));
//         assertEquals("08042014", uitlenin1.getTerugbrengdatum());
//     }
// 
//     /**
//      * Method TestSetTerugbrengdatum
//      * It can fail on someday because it uses a date in the future.
//      * Then the expected result may be adjusted.
//      */
//     @Test
//     public void TestSetTerugbrengdatumOneArgument()
//     {
//         assertEquals(false, uitlenin1.setTerugbrengdatum("wrong"));
//         assertEquals(null, uitlenin1.getTerugbrengdatum());
//         assertEquals(false, uitlenin1.setTerugbrengdatum("07042016"));
//         assertNull(uitlenin1.getTerugbrengdatum());
//         assertEquals(true, uitlenin1.setTerugbrengdatum("06042014"));
//         assertEquals("06042014", uitlenin1.getTerugbrengdatum());
//         assertEquals(false, uitlenin1.setTerugbrengdatum("05042014"));
//         assertEquals("06042014", uitlenin1.getTerugbrengdatum());
//         assertEquals(false, uitlenin1.setTerugbrengdatum("07042014"));
//         assertEquals("06042014", uitlenin1.getTerugbrengdatum());
//     }
}
