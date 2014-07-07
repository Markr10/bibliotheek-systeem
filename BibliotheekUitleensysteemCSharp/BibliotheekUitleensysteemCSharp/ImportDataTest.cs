import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

/**
 * The test class ImportDataTest.
 *
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class ImportDataTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Default constructor for test class ImportDataTest
     */
    public ImportDataTest()
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

    @Test(expected=NullPointerException.class)
    public void testFilePathNull() throws Exception
    {
        ImportData.run(null, new String[] {"test"});
    }

    @Test(expected=FileNotFoundException.class)
    public void testNotExistingFile() throws Exception
    {
        ImportData.run("NoFile", new String[] {"test"});
    }

    @Test(expected=NullPointerException.class)
    public void testEmptyFile() throws Exception
    {
        ImportData.run("test/empty.csv", new String[] {"test"});
    }

    @Test(expected=NullPointerException.class)
    public void testColumnNameNull() throws Exception
    {
        ImportData.run("test/oneLineBase.csv", null);
    }

    @Test
    public void testColumnNameIncorrect() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("Start of CSV file is not correct! A column name must consist of one or more characters!");
        ImportData.run("test/oneBlancoLine.csv", new String[] {""});
    }

    @Test
    public void testFirstColumnNameIncorrect() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("Start of CSV file is not correct! A column name must consist of one or more characters!");
        ImportData.run("test/oneLineNoDataFirst.csv", new String[] {"", "right"});
    }

    @Test
    public void testSecondColumnNameIncorrect() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("Start of CSV file is not correct! A column name must consist of one or more characters!");
        ImportData.run("test/oneLineNoDataSecond.csv", new String[] {"left", "", "right"});
    }

    @Test
    public void testThirdColumnNameIncorrect() throws Exception
    {
        thrown.expect(IncorrectStartCsvFileException.class);
        thrown.expectMessage("Start of CSV file is not correct! A column name must consist of one or more characters!");
        ImportData.run("test/oneLineNoDataThird.csv", new String[] {"left", "middle", ""});
    }

    @Test
    public void testCsvEmptyColumn() throws Exception
    {
        thrown.expect(IncorrectStartCsvFileException.class);
        thrown.expectMessage("Start of CSV file is not correct! The expected column name \"left\" " +
            "is not equals to the founded column name \"\"");
        ImportData.run("test/oneBlancoLine.csv", new String[] {"left"});
    }

    @Test
    public void testCsvLastEmptyColumn() throws Exception
    {
        thrown.expect(IncorrectStartCsvFileException.class);
        thrown.expectMessage("Start of CSV file is not correct! The expected column name \"right\" " +
            "is not equals to the founded column name \"\"");
        ImportData.run("test/oneLineNoDataThird.csv", new String[] {"left", "middle", "right"});
    }

    @Test
    public void testCsvWrongColumn() throws Exception
    {
        thrown.expect(IncorrectStartCsvFileException.class);
        thrown.expectMessage("Start of CSV file is not correct! The expected column name \"test\" " +
            "is not equals to the founded column name \"left\"");
        ImportData.run("test/oneLineOne.csv", new String[] {"test"});
    }

    @Test
    public void testCsvMissingColumn() throws Exception
    {
        thrown.expect(IncorrectStartCsvFileException.class);
        thrown.expectMessage("Start of CSV file is not correct! The number of the columns names of the CSV file is not correct!");
        ImportData.run("test/oneLineOne.csv", new String[] {"left", "right"});
    }

    @Test
    public void testCsvExtraColumn() throws Exception
    {
        thrown.expect(IncorrectStartCsvFileException.class);
        thrown.expectMessage("Start of CSV file is not correct! The number of the columns names of the CSV file is not correct!");
        ImportData.run("test/oneLineBase.csv", new String[] {" left ", " middle "});
    }

    @Test
    public void testOneColumn() throws Exception
    {
        java.util.ArrayList<java.lang.String[]> arrayLis1 = ImportData.run("test/oneLineOne.csv", new String[] {"left"});
        assertNotNull(arrayLis1);
        assertEquals(true, arrayLis1.isEmpty());
    }

    @Test
    public void testThreeColumns() throws Exception
    {
        java.util.ArrayList<java.lang.String[]> arrayLis1 = ImportData.run("test/oneLineBase.csv", new String[] {" left ", " middle ", " right "});
        assertNotNull(arrayLis1);
        assertEquals(true, arrayLis1.isEmpty());
    }

    @Test
    public void testCsvMissingRowColumn() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("The number of the columns is not correct! Corresponding line in CSV file: \" 1 , 3 \"");
        ImportData.run("test/multiLineMissingRowColumn.csv", new String[] {" left ", " middle ", " right "});
    }

    @Test
    public void testCsvBlancoLine() throws Exception
    {
        thrown.expect(Exception.class);
        thrown.expectMessage("The number of the columns is not correct! Corresponding line in CSV file: \"\"");
        ImportData.run("test/multiLinePlusBlancoLine.csv", new String[] {" left ", " middle ", " right "});
    }

    @Test
    public void testCsvRowValuesEmpty() throws Exception
    {
        java.util.ArrayList<java.lang.String[]> arrayLis1 = ImportData.run("test/multiLineRowValuesEmpty.csv",
            new String[] {" left ", " middle ", " right "});
        assertNotNull(arrayLis1);
        assertEquals(1, arrayLis1.size());
        java.lang.String[] string1 = (java.lang.String[])arrayLis1.get(0);
        assertNotNull(string1);
        assertEquals(3, string1.length);
        assertEquals("", string1[0]);
        assertEquals("", string1[1]);
        assertEquals("", string1[2]);
    }

    @Test
    public void testCsvCorrectFile() throws Exception
    {
        java.util.ArrayList<java.lang.String[]> arrayLis1 = ImportData.run("test/multiLine.csv", new String[] {" left ", " middle ", " right "});
        assertNotNull(arrayLis1);
        assertEquals(1, arrayLis1.size());
        java.lang.String[] string1 = (java.lang.String[])arrayLis1.get(0);
        assertNotNull(string1);
        assertEquals(3, string1.length);
        assertEquals(" 1 ", string1[0]);
        assertEquals(" 2 ", string1[1]);
        assertEquals(" 3 ", string1[2]);
    }
}
