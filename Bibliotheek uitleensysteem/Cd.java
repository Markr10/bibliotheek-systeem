
/**
 * Een klasse om cd objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Cd extends Artikel
{
    private String releasedatum;
    
    private int kostenNaKorting;

    /**
     * Constructor voor objecten van de klasse Cd.
     *
     * @param id           Het id van de cd.
     * @param titel        De titel van de cd.
     * @param type         Het type van de cd.
     * @param releasedatum De releasedatum van de cd.
     */
    public Cd(int id, String titel, CdType type, String releasedatum)
    {
        super(id, titel, type);
        this.releasedatum = releasedatum;
    }
    
    /**
     * Returned de releasedatum van de cd.
     * 
     * @return De releasedatum van de cd.
     */
    public String getReleasedatum() 
    {
        return releasedatum;
    }
    
    // Berekenen van korting op basis van leeftijd
    public int leeftijdCd(int kosten) 
    {
        int difference = SpecialDate.yearsDifference(releasedatum);

        // Groter dan 1 en kleiner dan 5
        if(difference < 1)
        {
            System.out.println("Geen korting! Years difference: " + difference + " Datum vandaag: " + SpecialDate.getDateToday());

        }

        if(difference >= 1 && difference < 5)
        {
            System.out.println("10% korting! Years difference: " + difference + " Datum vandaag: " + SpecialDate.getDateToday());
            kostenNaKorting = kosten - (kosten / 100 * 10);
            return kostenNaKorting;
            // Korting 10%
        } 

        if(difference >= 5)
        {
            System.out.println("50% korting! Years difference: " + difference + " Datum vandaag: " + SpecialDate.getDateToday());
            kostenNaKorting = kosten - (kosten / 100 * 50);
            return kostenNaKorting;
        }
        return kostenNaKorting;
    }
}
