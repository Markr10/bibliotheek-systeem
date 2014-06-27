import java.util.*;
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public abstract class Artikel
{
    // Artikel variabelen (Globaal)
    public int id;
    private String titel;
    public String type;
    private String releaseDatum;
    public String genre;
    private int uitgeleend_count;
    private int aantal_voorraad;

//     // CD Variabelen
//     private String artiest;
//     private int aantal_cds;
//     private int tracks;
//     public int afspeelDuur;
//             // Genre via Artikel
//             
//     // Book Variabelen
//     private String titel;
//     private String auteurs;
//     public int isbn;
//     public int pages;
//             // Genre via Artikel
// 
//     // Video Variabelen
//     //private String titel;
//     private String acteurs;
//             // Genre via Artikel

    
    public Artikel(int id, String titel, String type, String releaseDatum, String genre, int aantal_voorraad, int uitgeleend_count)
    {
        this.id = id;
        this.titel = titel;
        this.type = type;
        this.releaseDatum = releaseDatum;
        this.genre = genre;
        this.aantal_voorraad = aantal_voorraad;
        this.uitgeleend_count = uitgeleend_count;
    }

    // Getting id
    public int getID() 
    {
        return id;
    }
    
    // Getting Titel
    public String getTitel() 
    {
        return titel;
    }

    public String getType() 
    {
        return type;
    }
    
    public String getReleaseDate() 
    {
        return releaseDatum;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public int getVoorraad()
    {
        return aantal_voorraad;
    }
    
    public int getUitgeleend()
    {
        return uitgeleend_count;
    }
    
    public void setUitgeleend()
    {
        uitgeleend_count++;
    }
}
