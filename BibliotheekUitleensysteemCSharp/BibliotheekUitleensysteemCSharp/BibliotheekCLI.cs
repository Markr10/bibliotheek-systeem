using java.lang;
using java.util;
using java.util.LinkedHashMap;
using System;

/**
 * Een klasse die de uitvoer van een bibliotheek object toont in de command-line.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class BibliotheekCLI : Bibliotheek
{
    /**
     * Constructor voor objecten van de klasse BibliotheekCLI.
     */
    public BibliotheekCLI() : base()
    {
        //super();
    }

    /**
     * Leent een exemplaar uit en print of het uitlenen van het exemplaar gelukt is.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     */
    public void printAndAddUitlening(int lidID, int exemplaarID)
    {
        if(addUitlening(lidID, exemplaarID))
        {
            Console.WriteLine("Exemplaar " + exemplaarID + " uitgeleend aan lid " + lidID + ".");
        }
        else
        {
            Console.WriteLine("Exemplaar " + exemplaarID + " kon niet worden uitgeleend aan lid " + lidID + ".");
        }
    }

    /**
     * Levert een exemplaar in en print of het inleveren van het exemplaar gelukt is.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     */
    public void printAndInleverenExemplaar(int lidID, int exemplaarID)
    {
        if(inleverenExemplaar(lidID, exemplaarID))
        {
            Console.WriteLine("Exemplaar " + exemplaarID + " ingeleverd.");
        }
        else
        {
            Console.WriteLine("Exemplaar " + exemplaarID + " kon niet worden ingeleverd.");
        }
    }


    /**
     * Bepaald welke leden nog reserveringsbrieven moeten krijgen en toont deze.
     */
    public void printReserveringsbrieven()
    {
        ArrayList<Integer> lijstMetInfoOverBrieven = verwerkReserveringsbrieven();
        foreach(Integer reserveringID in lijstMetInfoOverBrieven)
        {
            Console.WriteLine("----------Reservering----------");
            Console.WriteLine();
            Console.WriteLine("Betreft: klaargezette reservering");
            Console.WriteLine();
            Console.WriteLine("Beste " + leden.get(reserveringen.get(reserveringID).getLidID()) + ",");
            Console.WriteLine();
            Console.WriteLine("Het artikel " + artikelen.get(reserveringen.get(reserveringID).getArtikelID()).getTitel() +
                " die u gereserveerd heeft, is voor u klaargezet.");
            Console.WriteLine("Als u niet binnen " + MAX_AANTAL_DAGEN_RESERVERING_OPHALEN + " dagen deze reservering ophaalt, " +
                "zal deze reservering vervallen. Bovendien wordt dan een boete in rekening gebracht van € " + (((float)RESERVERING_BOETE) / 100) + ".");
            Console.WriteLine("--------------------");
        }
    }

    /**
     * Berekent het verschuldigde bedrag van leden, bepaalt of ze een of
     * meerdere waarschuwingbrieven moeten krijgen en toont deze.
     */
    public void printWaarschuwingsbrieven()
    {
        ArrayList<int[]> lijstMetInfoOverBrieven = verwerkVerschuldigdBedrag();
        foreach(int[] arrayMetInfoOverBrief in lijstMetInfoOverBrieven)
        {
            if(arrayMetInfoOverBrief.Length != 2)
            {
                Console.WriteLine("Methode printWaarschuwingsbrieven kan niet (verder) uitgevoerd worden vanwege interne conflicten.");
                return;
            }

            if(arrayMetInfoOverBrief[1] == DREMPEL_EERSTE_BRIEF) 
            {
                Console.WriteLine("----------Waarschuwing----------");
                Console.WriteLine();
                Console.WriteLine("Betreft: openstaande boetes");
                Console.WriteLine();
                Console.WriteLine("Beste " + leden.get(arrayMetInfoOverBrief[0]).getNaam() + ",");
                Console.WriteLine();
                Console.WriteLine("De boete is hoger dan 10 euro! Graag voldoen!");
                Console.WriteLine("--------------------");
            }
            else if(arrayMetInfoOverBrief[1] == DREMPEL_TWEEDE_BRIEF) 
            {
                Console.WriteLine("----------Waarschuwing----------");
                Console.WriteLine();
                Console.WriteLine("Betreft: openstaande boetes");
                Console.WriteLine();
                Console.WriteLine("Beste " + leden.get(arrayMetInfoOverBrief[0]).getNaam() + ",");
                Console.WriteLine();
                Console.WriteLine("De boete is hoger dan 100 euro!");
                Console.WriteLine("Als u niet binnen " + MAX_AANTAL_DAGEN_NA_TWEEDE_BRIEF + " dagen alle geleende items inlevert en");
                Console.WriteLine("de boete betaald dan wordt deze zaak overgedragen aan een deurwaarder.");
                Console.WriteLine("--------------------");
            }
        }
    }


    /**
     * Print de artikelen van de bibliotheek.
     */
    public void printArtikelen()
    {
        Console.WriteLine("------------Artikelen-------------");
        foreach(Artikel artikel in artikelen)
        {
            Console.Write("# " + artikel.getID() + " Type: " + artikel.toString() + " Titel: " + artikel.getTitel());
            if(artikel is Cd)
            {
                Console.Write(" Releasedatum: " + ((Cd)artikel).getReleasedatum());
            }
            Console.WriteLine();
        }
        Console.WriteLine("----------------------------------");
    }

    /**
     * Print de leden van de bibliotheek.
     */
    public void printLeden()
    {
        Console.WriteLine("-------------Leden----------------");
        foreach(Lid lid in leden)
        {
            Console.WriteLine(lid.getNaam());
        }
        Console.WriteLine("----------------------------------");
    }

    /**
     * Print de reserveringen van de bibliotheek.
     */
    public void printReserveringen() 
    {
        Console.WriteLine("---------Reserveringen------------");
        foreach(Reservering reservering in reserveringen)
        {
            Console.WriteLine("# " + reservering.getID() + " Titel: " + artikelen.get(reservering.getArtikelID()).getTitel() +
                " Datum gereserveerd: " + reservering.getReserveringsdatum() + " Door lid: " + leden.get(reservering.getLidID()).getNaam());
        }
        Console.WriteLine("----------------------------------");
    }


    /**
     * Print het overzicht van de financiën van de bibliotheek.
     */
    public void printFinanciën()
    {
        int[] berekendeInkomsten = getInkomsten();
        Console.WriteLine("------------Financiën-------------");
        Console.WriteLine("Totale inkomsten: " + berekendeInkomsten[0] + ".");
        Console.WriteLine("Totaal bedrag boetes: " + berekendeInkomsten[1] + ".");
        Console.WriteLine("----------------------------------");
    }

    /**
     * Print het overzicht van de artikelen.
     */
    public void printInfoArtikelen()
    {
        LinkedHashMap<Integer, int[]> infoLijst = getInfoArtikelen();
        Console.WriteLine("--------Artikel informatie--------");

        Set<Integer> keys = infoLijst.keySet();
        foreach(Integer key in keys) 
        {
            int[] infoRij = infoLijst.get(key);
            Console.WriteLine("# " + key + "  Aantal keer uitgeleend: " + infoRij[0] +
                "  Gemiddelde uitleentermijn: " + (infoRij[1]/infoRij[0]) + " dagen");
        }

        Console.WriteLine("----------------------------------");
    }
}
