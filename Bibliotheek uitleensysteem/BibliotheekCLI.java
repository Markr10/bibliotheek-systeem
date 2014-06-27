import java.util.ArrayList;

/**
 * Een klasse die de uitvoer van een bibliotheek object toont in de command-line.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class BibliotheekCLI extends Bibliotheek
{
    /**
     * Constructor voor objecten van de klasse BibliotheekCLI.
     */
    public BibliotheekCLI()
    {
        super();
    }
    
    /**
     * Leent een exemplaar uit.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het uitlenen van het exemplaar gelukt is, anders false
     */
    public void printAndAddUitlening(int lidID, int exemplaarID)
    {
        if(super.addUitlening(lidID, exemplaarID))
        {
            System.out.println("Exemplaar " + exemplaarID + " uitgeleend aan lid " + lidID + ".");
        }
        else
        {
            System.out.println("Exemplaar " + exemplaarID + " kon niet worden uitgeleend aan lid " + lidID + ".");
        }
    }
    
    /**
     * Levert een exemplaar in.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het inleveren van het exemplaar gelukt is, anders false
     */
    public void printAndInleverenExemplaar(int lidID, int exemplaarID)
    {
        if(super.inleverenExemplaar(lidID, exemplaarID))
        {
            System.out.println("Exemplaar " + exemplaarID + " ingeleverd.");
        }
        else
        {
            System.out.println("Exemplaar " + exemplaarID + " kon niet worden ingeleverd.");
        }
    }
    
    
    /**
     * Berekent het verschuldigde bedrag van leden, bepaalt of ze een of
     * meerdere waarschuwingbrieven moeten krijgen en toont deze.
     * 
     */
    public void printWaarschuwingsbrieven()
    {
        ArrayList<int[]> lijstMetInfoOverBrieven = super.verwerkVerschuldigdBedrag();
        for(int[] arrayMetInfoOverBrief : lijstMetInfoOverBrieven)
        {
            if(arrayMetInfoOverBrief.length != 2)
            {
                System.out.println("Methode printWaarschuwingsbrieven kan niet (verder) uitgevoerd worden vanwege interne conflicten.");
                return;
            }
            
            if(arrayMetInfoOverBrief[1] == DREMPEL_EERSTE_BRIEF) 
            {
                System.out.println("----------Waarschuwing----------");
                System.out.println();
                System.out.println("Beste " + leden.get(arrayMetInfoOverBrief[0]) + ",");
                System.out.println();
                System.out.println("Betreft de openstaande boetes");
                System.out.println();
                System.out.println("De boete is hoger dan 10 euro! Graag voldoen!");
                System.out.println("--------------------");
            }
            else if(arrayMetInfoOverBrief[1] == DREMPEL_TWEEDE_BRIEF) 
            {
                System.out.println("----------Waarschuwing----------");
                System.out.println();
                System.out.println("Beste " + leden.get(arrayMetInfoOverBrief[0]) + ",");
                System.out.println();
                System.out.println("Betreft de openstaande boetes");
                System.out.println();
                System.out.println("De boete is hoger dan 100 euro!");
                System.out.println("Als u niet binnen " + MAX_AANTAL_DAGEN_NA_TWEEDE_BRIEF + " dagen alle geleende items inlevert en");
                System.out.println("de boete betaald dan wordt deze zaak overgedragen aan een deurwaarder.");
                System.out.println("--------------------");
            }
        }
    }
    
    
    /**
     * Print de leden van de bibliotheek.
     *
     */
    public void printLeden()
    {
        System.out.println("-------------Leden------------");
        for(Lid lid : leden)
        {
            System.out.println(lid.getNaam());
        }
        System.out.println("------------------------------");
    }

    /**
     * Print de artikelen van de bibliotheek.
     *
     */
    public void printArtikelen()
    {
        System.out.println("---------Artikelen----------");
        for(Artikel artikel : artikelen)
        {
            System.out.print("# " + artikel.getID() + " Type: " + artikel.toString() + " Titel: " + artikel.getTitel());
            if(artikel instanceof Cd)
            {
                System.out.print(" Releasedatum: " + ((Cd)artikel).getReleasedatum());
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    /**
     * Print de reserveringen van de bibliotheek.
     *
     */
    public void printReserveringen() 
    {
        System.out.println("---------Reserveringen----------");
        for(Reservering reservering : reserveringen)
        {
            System.out.println("# " + reservering.getID() + " Titel: " + artikelen.get(reservering.getArtikelID()).getTitel() +
                " Datum gereserveerd: " + reservering.getReserveringsdatum() + " Door lid: " + leden.get(reservering.getLidID()).getNaam());
        }
        System.out.println("------------------------------");
    }
}
