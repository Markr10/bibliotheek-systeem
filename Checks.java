
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
    private static final double PRIJS_CD_KLASSIEK = 2;
    private static final double PRIJS_CD_POPULAIR = 1;
    private static final short PRIJS_VIDEO_A = 2;
    private static final short PRIJS_VIDEO_B = 2;
    private static final short PRIJS_BOEK_ROMAN = 0;
    private static final short PRIJS_BOEK_STUDIE = 0;
    private static double leenPrijs = 0;
    private static double totaalPrijs = 0;
    private static double boetePrijs = 0;
    private static double bedragBoete = 0;
    private static double verschilDagen;
    private static double dagen;
    private static double weken;
    private static int leeftijd;
    
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
     * @return -1 als het artikel string niet bestaat
     */
    public static double Boetes(Artikel artikel, String datumUitlenen, String datumInleveren)
    {
        verschilDagen = SpecialDate.daysDifference(datumUitlenen, datumInleveren);
        switch(artikel.toString())
        {
            //Voor populaire Cd’s zijn deze bedragen respectievelijk € 1,00 en € 2,00
            //Deze korting wordt gegeven op het totale leengeld voor de betreffende CD
            //en bedraagt:
            //als 1 jaar < leeftijd <= 5 jaar : 10%
            //als 5 jaar < leeftijd           : 50 %

            case "Cd POPULAIR": 
            {
                leeftijd = SpecialDate.roundedYearsDifference(((Cd)artikel).getReleasedatum());
                System.out.println(leeftijd);
                if(leeftijd < 1)
                {
                    if(verschilDagen <= 10)
                    {
                        leenPrijs = PRIJS_CD_POPULAIR;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 10; // eerste week gratis
                        dagen = (int) Math.ceil(weken / 7);
                        leenPrijs = PRIJS_CD_POPULAIR;
                        boetePrijs = 2.00; // per week
                        bedragBoete = boetePrijs * dagen;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                if(leeftijd >= 1 && leeftijd <= 5)
                {
                    if(verschilDagen <= 10)
                    {
                        leenPrijs = (PRIJS_CD_POPULAIR / 100) * 90;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 10; // eerste week gratis
                        dagen = (int) Math.ceil(weken / 7);
                        leenPrijs = (PRIJS_CD_POPULAIR / 100) * 90;
                        boetePrijs = 2.00; // per week
                        bedragBoete = boetePrijs * dagen;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                if(leeftijd > 5)
                {
                    if(verschilDagen <= 10)
                    {
                        leenPrijs = (PRIJS_CD_POPULAIR / 100) * 50;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 10; // eerste week gratis
                        dagen = (int) Math.ceil(weken / 7);
                        leenPrijs = (PRIJS_CD_POPULAIR / 100) * 50;
                        boetePrijs = 2.00; // per week
                        bedragBoete = boetePrijs * dagen;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
            }
            break;
            case "Cd KLASSIEK": 
            {
                leeftijd = SpecialDate.roundedYearsDifference(((Cd)artikel).getReleasedatum());
                System.out.println(leeftijd);
                if(leeftijd < 1)
                {
                    if(verschilDagen <= 10)
                    {
                        leenPrijs = PRIJS_CD_KLASSIEK;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 10; // eerste week gratis
                        dagen = (int) Math.ceil(weken / 7);
                        leenPrijs = PRIJS_CD_KLASSIEK;
                        boetePrijs = 1.50; // per week
                        bedragBoete = boetePrijs * dagen;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                if(leeftijd >= 1 && leeftijd <= 5)
                {
                    if(verschilDagen <= 10)
                    {
                        leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 90;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 10; // eerste week gratis
                        dagen = (int) Math.ceil(weken / 7);
                        leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 90;
                        boetePrijs = 1.50; // per week
                        bedragBoete = boetePrijs * dagen;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                if(leeftijd > 5)
                {
                    if(verschilDagen <= 10)
                    {
                        leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 50;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 10; // eerste week gratis
                        dagen = (int) Math.ceil(weken / 7);
                        leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 50;
                        boetePrijs = 1.50; // per week
                        bedragBoete = boetePrijs * dagen;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
            }
            break;
            case "Videoband A":
            {
                dagen = verschilDagen;
                if(dagen == 0)
                {
                    dagen++;
                }
                leenPrijs = PRIJS_VIDEO_A;
                boetePrijs = 0;
                totaalPrijs = leenPrijs * dagen + boetePrijs;
            }
            break;
            case "Videoband B":
            {
                if(verschilDagen <= 3)
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = PRIJS_VIDEO_B;
                    boetePrijs = 0;
                    totaalPrijs = leenPrijs + boetePrijs;
                }
                else
                {
                    dagen = verschilDagen - 3;
                    leenPrijs = PRIJS_VIDEO_B;
                    boetePrijs = dagen * 1.00; // na 3 dagen
                    totaalPrijs = leenPrijs + boetePrijs;
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
                    totaalPrijs = leenPrijs + boetePrijs;
                }
                else
                {
                    dagen = verschilDagen - 21;
                    leenPrijs = PRIJS_BOEK_ROMAN;
                    boetePrijs = dagen * 0.25; // na 21 dagen
                    totaalPrijs = leenPrijs + boetePrijs;
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
                    totaalPrijs = leenPrijs + boetePrijs;
                }
                else
                {
                    weken = verschilDagen - 30;// eerste 30 gratis
                    dagen = Math.ceil(weken / 7.0);
                    leenPrijs = PRIJS_BOEK_STUDIE;
                    boetePrijs = dagen * 1.00; // na 30 dagen
                    totaalPrijs = leenPrijs + boetePrijs;
                }
            }
            break;
            default:
            {
                // stopt methode, dus geen break nodig
                return -1;
            }
        }
        
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
        
        
        return totaalPrijs;
    }   
}
