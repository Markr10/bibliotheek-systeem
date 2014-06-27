
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Boek extends Artikel
{
    // instance variables - replace the example below with your own
    private int isbn;
    private String auteurs;
    private String titel;
    private String genre;
    private String releaseDatum;
    private int aantal_voorraad;
    private int uitgeleend_count;
    private int pages;
    private String uitgever;
    private String omschrijving;
    private String type;
    private String leenDatum; // Verplaatsen naar artikel of andere klasse??

    SpecialDate sd = new SpecialDate();

    public Boek(int id, String titel, String type, String releaseDatum, String genre, int aantal_voorraad, int uitgeleend_count, int isbn, int pages)
    {
        super(id, titel, type, releaseDatum, genre, aantal_voorraad, uitgeleend_count);
               
        this.id = id;
        this.titel = titel;
        this.type = type;
        this.releaseDatum = releaseDatum;
        this.genre = genre;
        this.aantal_voorraad = aantal_voorraad;
        this.uitgeleend_count = uitgeleend_count;
        this.isbn = isbn;
        this.pages = pages;
    }

    public void kostenLenenBoek()
    {
        int daysGeleend = sd.daysDifference(leenDatum);
        if(type.equals("Roman"))
        {
            if(daysGeleend <= 21)
            {
                // Gratis
            } 
            else 
            {
                // Na 21 dagen wordt 0,25 cent per dag als boete in rekening gebracht    
            }
        }
        if(type.equals("Studie"))
        {
            if(daysGeleend <= 30)
            {
                // Eerste 30 dagen gratis
            } 
            else 
            {
                // Na 30 dagen wordt 1 euro in rekening gebracht per week of een deel van een week
            }
        }
    }
}
