
/**
 * Een klasse om een lid objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Lid
{
    private int id;
    private String naam;
    private boolean geroyeerd;
    private boolean eersteBrief;
    private String tweedeBrief;

    /**
     * Constructor voor objecten van de klasse Lid.
     *
     * @param id   Het ID van het lid.
     * @param naam De naam van het lid.
     */    
    public Lid(int id, String naam)
    {
        this.id = id;
        this.naam = naam;
        
        geroyeerd = false;
        resetBrieven();
    }
    
    
    /**
     * Returned het ID van het lid.
     * 
     * @return Het ID van het lid.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returned de naam van het lid.
     *
     * @return De naam van het lid.
     */
    public String getNaam()
    {
        return naam;
    }
    
    /**
     * Returned of het lid geroyeerd is.
     *
     * @return true als het lid geroyeerd is, anders false
     */
    public boolean isGeroyeerd()
    {
        return geroyeerd;
    }
    
    /**
     * Returned of de eerste waarschuwingsbrief verstuurd is.
     *
     * @return true als de eerste waarschuwingsbrief verstuurd is, anders false
     */
    public boolean getEersteBrief()
    {
        return eersteBrief;
    }
    
    /**
     * Returned de datum waarop de tweede waarschuwingsbrief verstuurd is.
     *
     * @return De datum waarop de tweede waarschuwingsbrief verstuurd is, anders null
     */
    public String getTweedeBrief()
    {
        return tweedeBrief;
    }
    
    
    /**
     * Verstuurd de eerste waarschuwingsbrief.
     *
     * @return true als het versturen gelukt is, anders false
     */
    public boolean setEersteBrief()
    {
        if(!geroyeerd && !eersteBrief)
        {
            eersteBrief = true;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Verstuurd de tweede waarschuwingsbrief.
     *
     * @return true als het versturen gelukt is, anders false
     */
    public boolean setTweedeBrief()
    {
        if(!geroyeerd && eersteBrief && tweedeBrief == null)
        {
            tweedeBrief = SpecialDate.getDateToday();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Reset dat er waarschuwingsbrieven verstuurd zijn.
     *
     * @return true als het resetten gelukt is, anders false
     */
    public boolean resetBrieven()
    {
        if(!geroyeerd)
        {
            eersteBrief = false;
            tweedeBrief = null;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Stelt lid in als geroyeerd.
     *
     * @return true als het royeren gelukt is, anders false
     */
    public boolean setGeroyeerd()
    {
        if(!geroyeerd && eersteBrief && tweedeBrief != null)
        {
            geroyeerd = true;
            return true;
        }
        else
        {
            return false;
        }
    }
}
