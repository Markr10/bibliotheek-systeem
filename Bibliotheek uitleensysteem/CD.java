
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class CD extends Artikel
{
    private String artiest;
    private String label; // Onder welk label is het album opgenomen?
    private String titel;
    private String genre;
    private String releaseDatum;
    private int aantal_voorraad;
    private int uitgeleend_count;

    private String leenDatum; // Verplaatsen naar artikel of andere klasse??

    SpecialDate sd = new SpecialDate();

    int kostenNaKorting;

    // Constructor for objects of class CD
    public CD(int id, String titel, String type, String releaseDatum, String genre, int aantal_voorraad, int uitgeleend_count, String artiest)
    {
        super(id, titel, type, releaseDatum, genre, aantal_voorraad, uitgeleend_count);
        
        this.id = id;
        this.titel = titel;
        this.type = type;
        this.releaseDatum = releaseDatum;
        this.genre = genre;
        this.aantal_voorraad = aantal_voorraad;
        this.uitgeleend_count = uitgeleend_count;
        this.artiest = artiest;
    }

    public void kostenLenenCD()
    {
        leenDatum = "01032014";

        int daysGeleend = sd.daysDifference(leenDatum);
        if(daysGeleend <= 10) 
        {
            System.out.println("Kleiner of gelijk aan 10 dagen");
            System.out.println("Kosten zijn 2 euro");
            // Binnen 10 dagen 
            // klassiek 2 euro
            // populair 2 euro
        }

        if(daysGeleend > 10) 
        {
            int dagenOver = (daysGeleend - 10) / 7; // Moet nog afronden naar boven... uitkomst 27 / 7 is 3.8 maar geeft 3 als resultaat
            int kosten = dagenOver * 150;
            System.out.println("Groter dan 10 dagen");
            System.out.println("Kosten zijn 2 euro plus " + dagenOver + " * 1,5 euro is: " + (dagenOver * 150) + " centen");
            System.out.println();
            System.out.println("LeeftijdCD(Kosten: " + kosten + ")");
            System.out.println("Wat blijft er over na de functie: " + leeftijdCD(kosten));

            System.out.println("Dagen over na -10 is: " + dagenOver);
            //             if(aantal_dagen na de 10 / 7 * 150 centen)
            // Na 10 dagen
            // klassiek 1,50 euro
            // populair 1,00 
        }

    }
    // Berekenen van korting op basis van leeftijd
    public int leeftijdCD(int kosten) 
    {
        int difference = sd.yearsDifference(releaseDatum);

        // Groter dan 1 en kleiner dan 5
        if(difference < 1)
        {
            System.out.println("Geen korting! Years difference: " + difference + " Datum vandaag: " + sd.getDateToday());

        }

        if(difference >= 1 && difference < 5)
        {
            System.out.println("10% korting! Years difference: " + difference + " Datum vandaag: " + sd.getDateToday());
            kostenNaKorting = kosten - (kosten / 100 * 10);
            return kostenNaKorting;
            // Korting 10%
        } 

        if(difference >= 5)
        {
            System.out.println("50% korting! Years difference: " + difference + " Datum vandaag: " + sd.getDateToday());
            kostenNaKorting = kosten - (kosten / 100 * 50);
            return kostenNaKorting;
        }
        return kostenNaKorting;
    }
}
