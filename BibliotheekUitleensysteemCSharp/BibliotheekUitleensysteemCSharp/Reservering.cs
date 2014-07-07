using System;

/**
 * Een klasse om een reservering objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Reservering
{
    private int id;
    private int lidID;
    private int artikelID;
    private String reserveringsdatum;
    private Boolean reserveringskostenBetaald;
    private String datumKlaargezet;
    private int exemplaarID;
    private Boolean brief;
    private String maxOphaaldatum; // ophaaldag is tot en met deze dag

    /**
     * Constructor voor objecten van de klasse Reservering.
     * 
     * @param id        Het ID van de reservering.
     * @param lidID     Het lidID van de reservering.
     * @param artikelID Het artikelID van de reservering.
     * 
     */
    public Reservering(int id, int lidID, int artikelID)
    {
        this.id = id;
        this.lidID = lidID;
        this.artikelID = artikelID;
        
        reserveringsdatum = SpecialDate.getDateToday();
        reserveringskostenBetaald = false;
        exemplaarID = -1;
        brief = false;
        datumKlaargezet = maxOphaaldatum = null;
    }
    
    /**
     * Returned het ID van de reservering.
     * 
     * @return Het ID van de reservering.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returned het lidID van de reservering.
     * 
     * @return Het lidID van de reservering.
     */
    public int getLidID()
    {
        return lidID;
    }
    
    /**
     * Returned het artikelID van de reservering.
     * 
     * @return Het artikelID van de reservering.
     */
    public int getArtikelID()
    {
        return artikelID;
    }
    
    /**
     * Returned de reserveringsdatum van de reservering.
     * 
     * @return De reserveringsdatum van de reservering
     */
    public String getReserveringsdatum()
    {
        return reserveringsdatum;
    }
    
    /**
     * Returned of de reserveringskosten betaald zijn.
     * 
     * @return true als de reserveringskosten betaald zijn, anders false
     */
    public Boolean getReserveringskostenBetaald()
    {
        return reserveringskostenBetaald;
    }
    
    /**
     * Returned de datum waarop de reservering is klaargezet.
     * 
     * @return De datum waarop de reservering is klaargezet.
     * Wanneer dit nooit gebeurd is, wordt null gereturned.
     */
    public String getDatumKlaargezet()
    {
        return datumKlaargezet;
    }
    
    /**
     * Returned het exemplaarID van de reservering.
     * 
     * @return Het exemplaarID van de reservering.
     * @return Het exemplaarID van de reservering als
     * de reservering ooit is klaargezet, anders -1.
     */
    public int getExemplaarID()
    {
        return exemplaarID;
    }
    
    /**
     * Returned of er een brief verstuurd is met de mededeling dat de reservering klaargezet is.
     * 
     * @return true als er een brief verstuurd is, anders false
     */
    public Boolean getBrief()
    {
        return brief;
    }
    
    /**
     * Returned de maximale ophaaldatum van de reservering.
     * 
     * @return De maximale ophaaldatum van de reservering als
     * de reservering ooit is klaargezet, anders null.
     */
    public String getMaxOphaaldatum()
    {
        return maxOphaaldatum;
    }
    
    
    /**
     * Betaald de reserveringskosten indien mogelijk.
     * 
     * @return true als het betalen gelukt is, anders false
     */
    public Boolean setReserveringskostenBetaald()
    {
        // Controleer of de reserveringskosten al betaald zijn.
        if(!reserveringskostenBetaald)
        {
            reserveringskostenBetaald = true;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Geeft aan dat er een brief verstuurd is met de mededeling dat de reservering klaargezet is.
     * 
     * @return true als het instellen gelukt is, anders false
     */
    public Boolean setBrief()
    {
        // Controleer of de brief nog niet verstuurd is en of er een reservering klaargezet is.
        if(!brief && datumKlaargezet != null)
        {
            brief = true;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Zorgt ervoor dat een reservering opgehaald kan worden.
     * 
     * @param exemplaarID Het exemplaarID van de reservering.
     * @return true als het klaarzetten gelukt is, anders false
     */
    public Boolean setReserveringKlaar(int exemplaarID)
    {
        // Controleer of de datumKlaargezet ingesteld kan worden.
        // Omdat setReserveringKlaar de maximale ophaaldatum beheerd, hoeft hier niet op gecontroleerd te worden.
        if(datumKlaargezet == null)
        {
            datumKlaargezet = SpecialDate.getDateToday();
            // De datum waarop de reservering maximaal mag worden opgehaald. De datum is dus tot en met die dag en is in het formaat "ddMMyyyy".
            maxOphaaldatum = SpecialDate.addDays(SpecialDate.getDateToday(), Bibliotheek.MAX_AANTAL_DAGEN_RESERVERING_OPHALEN);
            return true;
        }
        else
        {
            return false;
        }
    }
}
