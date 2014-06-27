
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Videoband extends Artikel
{
    private String titel;
    private String genre;
    private String releaseDatum;
    private int aantal_voorraad;
    private int uitgeleend_count;
    
    private String leenDatum; // Verplaatsen naar artikel of andere klasse??

    SpecialDate sd = new SpecialDate();

    /**
     * Constructor for objects of class Videoband
     */
    public Videoband(int id, String titel, String type, String releaseDatum, String genre, int aantal_voorraad, int uitgeleend_count)
    {
        super(id, titel, type, releaseDatum, genre, aantal_voorraad, uitgeleend_count);
        
        this.id = id;
        this.titel = titel;
        this.type = type;
        this.releaseDatum = releaseDatum;
        this.genre = genre;
        this.aantal_voorraad = aantal_voorraad;
        this.uitgeleend_count = uitgeleend_count;
    }

    public void kostenLenenVideo()
    {
        leenDatum = "01032014";

        int daysGeleend = sd.daysDifference(leenDatum);
        if(type.equals("A"))
        {
            // kosten 2 euro per dag
        }

        if(type.equals("B"))
        {
            if(daysGeleend <= 3)
            {
                // 3 dagen voor 2 euro

            }
            if(daysGeleend >3)
            {
                // 2 euro voor de eerste 3 dagen
                // daysGeleend - 3
                // overige dagen --> 1 euro per dag
            }
        }
    }

}
