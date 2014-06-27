
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Checks
{
    private static Artikel artikel;
    private static String datumInleveren;
    private static String datumUitlenen;
    private static final short PRIJS_CD_KLASSIEK = 2;
    private static final short PRIJS_CD_POPULAIR = 1;
    private static final short PRIJS_VIDEO_A = 2;
    private static final short PRIJS_VIDEO_B = 2;
    private static final short PRIJS_BOEK_ROMAN = 0;
    private static final short PRIJS_BOEK_STUDIE = 0;
    private static double leenPrijs = 0;
    private static double totaalPrijs = 0;
    private static double boetePrijs;
    private static double bedragBoete;
    private static int verschilDagen;
    private static int dagen;
    private static int weken;
    
    /**
     * Checks Constructor
     *
     * @param artikel A parameter
     * @param datumInleveren A parameter
     * @param datumUitlenen A parameter
     */
    public Checks()
    {
    }    
    
    /**
     * Method Boetes
     * Vraagt eerst het aantal dagen op van SpecialDate
     * Daarna wordt, aan de hand van het artikel, de boete berekend.
     * 
     * @param artikel A parameter
     * @param datumUitlenen A parameter
     * @param datumInleveren A parameter
     */
    public static double Boetes(Artikel artikel, String datumUitlenen, String datumInleveren) 
    {
        verschilDagen = SpecialDate.daysDifference(datumUitlenen, datumInleveren);
        switch(artikel.toString())
        {
            case "Cd POPULAIR": 
            {
                if(verschilDagen <= 7)
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = dagen * PRIJS_CD_POPULAIR;
                    boetePrijs = 0;
                }
                else
                {
                    weken = verschilDagen - 7; // eerste week gratis
                    dagen = (int) Math.ceil(weken / 7);
                    leenPrijs = dagen * PRIJS_CD_POPULAIR;
                    boetePrijs = 1.50; // per week
                }
            }
            break;
            case "Cd KLASSIEK": 
            {
                if(verschilDagen <= 7)
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    
                    leenPrijs = dagen * PRIJS_CD_KLASSIEK;
                    boetePrijs = 0;
                }
                else
                {
                    weken = verschilDagen - 7; // eerste week gratis
                    dagen = (int)Math.ceil(weken / 7);
                    leenPrijs = dagen * PRIJS_CD_KLASSIEK;
                    boetePrijs = 2.00; // per week
                }
            }
            break;
            case "Video A":
            {
                dagen = verschilDagen;
                if(dagen == 0)
                {
                    dagen++;
                }
                leenPrijs = dagen * PRIJS_VIDEO_A;
                boetePrijs = 0;
            }
            break;
            case "Video B":
            {
                if(verschilDagen <= 3)
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = dagen * PRIJS_VIDEO_B;
                    boetePrijs = 0;
                }
                else
                {
                    dagen = verschilDagen - 3;
                    leenPrijs = dagen * PRIJS_VIDEO_B;
                    boetePrijs = 1.00; // na 3 dagen
                }
            }
            break;
            case "Boek ROMAN":
            {
                if(verschilDagen <= 21)
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = dagen * PRIJS_BOEK_ROMAN;
                    boetePrijs = 0;
                }
                else
                {
                    dagen = verschilDagen - 21;
                    leenPrijs = dagen * PRIJS_BOEK_ROMAN;
                    boetePrijs = 0.25; // na 21 dagen
                }
            }
            break;
            case "Boek STUDIEBOEK":
            {
                if(verschilDagen <= 30)
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = dagen * PRIJS_BOEK_STUDIE;
                    boetePrijs = 0;
                }
                else
                {
                    dagen = verschilDagen - 30;
                    leenPrijs = dagen * PRIJS_BOEK_STUDIE;
                    boetePrijs = 1.00; // na 30 dagen
                }
            }
        }
        
        bedragBoete = boetePrijs * dagen;
        
        if(bedragBoete >= 10) 
        {
            System.out.println("----------Waarschuwing----------");
            System.out.println();
            System.out.println("Beste <naam>,");
            System.out.println();
            System.out.println("Betreft de openstaande boetes");
            System.out.println("");
            System.out.println("De boete is hoger dan 10 euro! Graag voldoen!");
            System.out.println("--------------------");
        }
        
        if(bedragBoete >= 100) 
        {
            System.out.println("----------Waarschuwing----------");
            System.out.println();
            System.out.println("Beste <naam>,");
            System.out.println();
            System.out.println("Betreft de openstaande boetes");
            System.out.println("");
            System.out.println("De boete is hoger dan 100 euro!");
            System.out.println("Deze zaak wordt overgedragen aan een deurwaarder.");
            System.out.println("--------------------");
        }
        
        totaalPrijs = leenPrijs + bedragBoete;
        return totaalPrijs;
    }   
}
