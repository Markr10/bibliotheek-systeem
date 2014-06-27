import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChecksTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ChecksTest
{
    private Boek boekRoman;
    private Boek boekStudieboek;
    private Videoband videobandA;
    private Videoband videobandB;
    private Cd cdPopulair;
    private Cd cdKlassiek;
    private Cd cdPopulair1jaar;
    private Cd cdKlassiek1jaar;
    private Cd cdPopulair1jaar1dag;
    private Cd cdKlassiek1jaar1dag;
    private Cd cdPopulair3jaar;
    private Cd cdKlassiek3jaar;
    private Cd cdPopulair5jaar;
    private Cd cdKlassiek5jaar;
    private Cd cdPopulair5jaar1dag;
    private Cd cdKlassiek5jaar1dag;
    private Cd cdPopulair10jaar;
    private Cd cdKlassiek10jaar;

    /**
     * Default constructor for test class ChecksTest
     */
    public ChecksTest()
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
        boekRoman = new Boek(3, "Roman Empire", BoekType.ROMAN);
        boekStudieboek = new Boek(4, "Java", BoekType.STUDIEBOEK);
        videobandA = new Videoband(10, "The Bandit", VideobandType.A);
        videobandB = new Videoband(11, "After the fox", VideobandType.B);
        cdPopulair = new Cd(1, "Nederpop 2014", CdType.POPULAIR, "06032014");
        cdKlassiek = new Cd(2, "Aangenaam Klassiek 2014", CdType.KLASSIEK, "04102014");
        cdPopulair1jaar = new Cd(3, "Nederpop 2013", CdType.POPULAIR, "02062013");
        cdKlassiek1jaar = new Cd(4, "Aangenaam Klassiek 2013", CdType.KLASSIEK, "02062013");
        cdPopulair1jaar1dag = new Cd(5, "The best of Nederpop 2012", CdType.POPULAIR, "01062013");
        cdKlassiek1jaar1dag = new Cd(6, "The best of Aangenaam Klassiek 2012", CdType.KLASSIEK, "01062013");
        cdPopulair3jaar = new Cd(7, "Nederpop 2011", CdType.POPULAIR, "02062011");
        cdKlassiek3jaar = new Cd(8, "Aangenaam Klassiek 2011", CdType.KLASSIEK, "02062011");
        cdPopulair5jaar = new Cd(9, "Nederpop 2009", CdType.POPULAIR, "02062009");
        cdKlassiek5jaar = new Cd(10, "Aangenaam Klassiek 2009", CdType.KLASSIEK, "02062009");
        cdPopulair5jaar1dag = new Cd(11, "The best of Nederpop 2008", CdType.POPULAIR, "01062009");
        cdKlassiek5jaar1dag = new Cd(12, "The best of Aangenaam Klassiek 2008", CdType.KLASSIEK, "01062009");
        cdPopulair10jaar = new Cd(11, "Nederpop 2004", CdType.POPULAIR, "04102004");
        cdKlassiek10jaar = new Cd(12, "Aangenaam Klassiek 2004", CdType.KLASSIEK, "04102004");
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
    public void testBoekRoman()
    {
        assertEquals(0.00, Checks.Boetes(boekRoman, "01012014", "01012014"), 0);
        assertEquals(0.00, Checks.Boetes(boekRoman, "01012014", "02012014"), 0);
        assertEquals(0.00, Checks.Boetes(boekRoman, "01012014", "22012014"), 0);
        assertEquals(0.25, Checks.Boetes(boekRoman, "01012014", "23012014"), 0);
        assertEquals(2.50, Checks.Boetes(boekRoman, "01012014", "01022014"), 0);
        assertEquals(4.00, Checks.Boetes(boekRoman, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testBoekStudieboek()
    {
        assertEquals(0.00, Checks.Boetes(boekStudieboek, "01012014", "01012014"), 0);
        assertEquals(0.00, Checks.Boetes(boekStudieboek, "01012014", "02012014"), 0);
        assertEquals(0.00, Checks.Boetes(boekStudieboek, "01012014", "31012014"), 0);
        assertEquals(1.00, Checks.Boetes(boekStudieboek, "01012014", "01022014"), 0);
        assertEquals(1.00, Checks.Boetes(boekStudieboek, "01012014", "04022014"), 0);
        assertEquals(1.00, Checks.Boetes(boekStudieboek, "01012014", "07022014"), 0);
        assertEquals(2.00, Checks.Boetes(boekStudieboek, "01012014", "08022014"), 0);
        assertEquals(4.00, Checks.Boetes(boekStudieboek, "01012014", "25022014"), 0);
    }
    
    @Test
    public void testVideobandA()
    {
        assertEquals(2.00, Checks.Boetes(videobandA, "01012014", "01012014"), 0);
        assertEquals(2.00, Checks.Boetes(videobandA, "01012014", "02012014"), 0);
        assertEquals(4.00, Checks.Boetes(videobandA, "01012014", "03012014"), 0);
        assertEquals(6.00, Checks.Boetes(videobandA, "01012014", "04012014"), 0);
        assertEquals(8.00, Checks.Boetes(videobandA, "01012014", "05012014"), 0);
        assertEquals(34.00, Checks.Boetes(videobandA, "01012014", "18012014"), 0);
        assertEquals(62.00, Checks.Boetes(videobandA, "01012014", "01022014"), 0);
        assertEquals(74.00, Checks.Boetes(videobandA, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testVideobandB()
    {
        assertEquals(2.00, Checks.Boetes(videobandB, "01012014", "01012014"), 0);
        assertEquals(2.00, Checks.Boetes(videobandB, "01012014", "02012014"), 0);
        assertEquals(2.00, Checks.Boetes(videobandB, "01012014", "03012014"), 0);
        assertEquals(2.00, Checks.Boetes(videobandB, "01012014", "04012014"), 0);
        assertEquals(3.00, Checks.Boetes(videobandB, "01012014", "05012014"), 0);
        assertEquals(5.00, Checks.Boetes(videobandB, "01012014", "07012014"), 0);
        assertEquals(6.00, Checks.Boetes(videobandB, "01012014", "08012014"), 0);
        assertEquals(16.00, Checks.Boetes(videobandB, "01012014", "18012014"), 0);
        assertEquals(30.00, Checks.Boetes(videobandB, "01012014", "01022014"), 0);
        assertEquals(36.00, Checks.Boetes(videobandB, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testCdKlassiek()
    {
        assertEquals(2.00, Checks.Boetes(cdKlassiek, "01012014", "01012014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek, "01012014", "02012014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek, "01012014", "10012014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek, "01012014", "11012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdKlassiek, "01012014", "12012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdKlassiek, "01012014", "17012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdKlassiek, "01012014", "18012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek, "01012014", "19012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek, "01012014", "20012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek, "01012014", "21012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek, "01012014", "24012014"), 0);
        assertEquals(6.50, Checks.Boetes(cdKlassiek, "01012014", "25012014"), 0);
        assertEquals(8.00, Checks.Boetes(cdKlassiek, "01012014", "07022014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "01012014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "02012014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "10012014"), 0);
        assertEquals(2.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "11012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdKlassiek1jaar, "01012014", "12012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdKlassiek1jaar, "01012014", "17012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdKlassiek1jaar, "01012014", "18012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "19012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "20012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "21012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "24012014"), 0);
        assertEquals(6.50, Checks.Boetes(cdKlassiek1jaar, "01012014", "25012014"), 0);
        assertEquals(8.00, Checks.Boetes(cdKlassiek1jaar, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testCdKlassiekOudere()
    {
        assertEquals(1.80, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "01012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "02012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "10012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "11012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "12012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "17012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "18012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "19012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "20012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "21012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "24012014"), 0);
        assertEquals(5.85, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "25012014"), 0);
        assertEquals(7.20, Checks.Boetes(cdKlassiek1jaar1dag, "01012014", "07022014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek3jaar, "01012014", "01012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek3jaar, "01012014", "02012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek3jaar, "01012014", "10012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek3jaar, "01012014", "11012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek3jaar, "01012014", "12012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek3jaar, "01012014", "17012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek3jaar, "01012014", "18012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek3jaar, "01012014", "19012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek3jaar, "01012014", "20012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek3jaar, "01012014", "21012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek3jaar, "01012014", "24012014"), 0);
        assertEquals(5.85, Checks.Boetes(cdKlassiek3jaar, "01012014", "25012014"), 0);
        assertEquals(7.20, Checks.Boetes(cdKlassiek3jaar, "01012014", "07022014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek5jaar, "01012014", "01012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek5jaar, "01012014", "02012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek5jaar, "01012014", "10012014"), 0);
        assertEquals(1.80, Checks.Boetes(cdKlassiek5jaar, "01012014", "11012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek5jaar, "01012014", "12012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek5jaar, "01012014", "17012014"), 0);
        assertEquals(3.15, Checks.Boetes(cdKlassiek5jaar, "01012014", "18012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek5jaar, "01012014", "19012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek5jaar, "01012014", "20012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek5jaar, "01012014", "21012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdKlassiek5jaar, "01012014", "24012014"), 0);
        assertEquals(5.85, Checks.Boetes(cdKlassiek5jaar, "01012014", "25012014"), 0);
        assertEquals(7.20, Checks.Boetes(cdKlassiek5jaar, "01012014", "07022014"), 0);
    }

    @Test
    public void testCdKlassiekOud()
    {
        assertEquals(1.00, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "01012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "02012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "10012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "11012014"), 0);
        assertEquals(1.75, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "12012014"), 0);
        assertEquals(1.75, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "17012014"), 0);
        assertEquals(1.75, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "18012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "19012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "20012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "21012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "24012014"), 0);
        assertEquals(3.25, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "25012014"), 0);
        assertEquals(4.00, Checks.Boetes(cdKlassiek5jaar1dag, "01012014", "07022014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek10jaar, "01012014", "01012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek10jaar, "01012014", "02012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek10jaar, "01012014", "10012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdKlassiek10jaar, "01012014", "11012014"), 0);
        assertEquals(1.75, Checks.Boetes(cdKlassiek10jaar, "01012014", "12012014"), 0);
        assertEquals(1.75, Checks.Boetes(cdKlassiek10jaar, "01012014", "17012014"), 0);
        assertEquals(1.75, Checks.Boetes(cdKlassiek10jaar, "01012014", "18012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek10jaar, "01012014", "19012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek10jaar, "01012014", "20012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek10jaar, "01012014", "21012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdKlassiek10jaar, "01012014", "24012014"), 0);
        assertEquals(3.25, Checks.Boetes(cdKlassiek10jaar, "01012014", "25012014"), 0);
        assertEquals(4.00, Checks.Boetes(cdKlassiek10jaar, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testCdPopulair()
    {
        assertEquals(1.00, Checks.Boetes(cdPopulair, "01012014", "01012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair, "01012014", "02012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair, "01012014", "10012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair, "01012014", "11012014"), 0);
        assertEquals(3.00, Checks.Boetes(cdPopulair, "01012014", "12012014"), 0);
        assertEquals(3.00, Checks.Boetes(cdPopulair, "01012014", "17012014"), 0);
        assertEquals(3.00, Checks.Boetes(cdPopulair, "01012014", "18012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair, "01012014", "19012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair, "01012014", "20012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair, "01012014", "21012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair, "01012014", "24012014"), 0);
        assertEquals(7.00, Checks.Boetes(cdPopulair, "01012014", "25012014"), 0);
        assertEquals(9.00, Checks.Boetes(cdPopulair, "01012014", "07022014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair1jaar, "01012014", "01012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair1jaar, "01012014", "02012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair1jaar, "01012014", "10012014"), 0);
        assertEquals(1.00, Checks.Boetes(cdPopulair1jaar, "01012014", "11012014"), 0);
        assertEquals(3.00, Checks.Boetes(cdPopulair1jaar, "01012014", "12012014"), 0);
        assertEquals(3.00, Checks.Boetes(cdPopulair1jaar, "01012014", "17012014"), 0);
        assertEquals(3.00, Checks.Boetes(cdPopulair1jaar, "01012014", "18012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair1jaar, "01012014", "19012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair1jaar, "01012014", "20012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair1jaar, "01012014", "21012014"), 0);
        assertEquals(5.00, Checks.Boetes(cdPopulair1jaar, "01012014", "24012014"), 0);
        assertEquals(7.00, Checks.Boetes(cdPopulair1jaar, "01012014", "25012014"), 0);
        assertEquals(9.00, Checks.Boetes(cdPopulair1jaar, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testCdPopulairOudere()
    {
        assertEquals(0.90, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "01012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "02012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "10012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "11012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "12012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "17012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "18012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "19012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "20012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "21012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "24012014"), 0);
        assertEquals(6.30, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "25012014"), 0);
        assertEquals(8.10, Checks.Boetes(cdPopulair1jaar1dag, "01012014", "07022014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair3jaar, "01012014", "01012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair3jaar, "01012014", "02012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair3jaar, "01012014", "10012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair3jaar, "01012014", "11012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair3jaar, "01012014", "12012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair3jaar, "01012014", "17012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair3jaar, "01012014", "18012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair3jaar, "01012014", "19012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair3jaar, "01012014", "20012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair3jaar, "01012014", "21012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair3jaar, "01012014", "24012014"), 0);
        assertEquals(6.30, Checks.Boetes(cdPopulair3jaar, "01012014", "25012014"), 0);
        assertEquals(8.10, Checks.Boetes(cdPopulair3jaar, "01012014", "07022014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair5jaar, "01012014", "01012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair5jaar, "01012014", "02012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair5jaar, "01012014", "10012014"), 0);
        assertEquals(0.90, Checks.Boetes(cdPopulair5jaar, "01012014", "11012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair5jaar, "01012014", "12012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair5jaar, "01012014", "17012014"), 0);
        assertEquals(2.70, Checks.Boetes(cdPopulair5jaar, "01012014", "18012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair5jaar, "01012014", "19012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair5jaar, "01012014", "20012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair5jaar, "01012014", "21012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair5jaar, "01012014", "24012014"), 0);
        assertEquals(6.30, Checks.Boetes(cdPopulair5jaar, "01012014", "25012014"), 0);
        assertEquals(8.10, Checks.Boetes(cdPopulair5jaar, "01012014", "07022014"), 0);
    }
    
    @Test
    public void testCdPopulairOud()
    {
        assertEquals(0.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "01012014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "02012014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "10012014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "11012014"), 0);
        assertEquals(1.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "12012014"), 0);
        assertEquals(1.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "17012014"), 0);
        assertEquals(1.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "18012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "19012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "20012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "21012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "24012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "25012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair5jaar1dag, "01012014", "07022014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair10jaar, "01012014", "01012014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair10jaar, "01012014", "02012014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair10jaar, "01012014", "10012014"), 0);
        assertEquals(0.50, Checks.Boetes(cdPopulair10jaar, "01012014", "11012014"), 0);
        assertEquals(1.50, Checks.Boetes(cdPopulair10jaar, "01012014", "12012014"), 0);
        assertEquals(1.50, Checks.Boetes(cdPopulair10jaar, "01012014", "17012014"), 0);
        assertEquals(1.50, Checks.Boetes(cdPopulair10jaar, "01012014", "18012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair10jaar, "01012014", "19012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair10jaar, "01012014", "20012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair10jaar, "01012014", "21012014"), 0);
        assertEquals(2.50, Checks.Boetes(cdPopulair10jaar, "01012014", "24012014"), 0);
        assertEquals(3.50, Checks.Boetes(cdPopulair10jaar, "01012014", "25012014"), 0);
        assertEquals(4.50, Checks.Boetes(cdPopulair10jaar, "01012014", "07022014"), 0);
    }
}


