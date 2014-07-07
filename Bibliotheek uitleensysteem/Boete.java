
/**
 * Een klasse om boete objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Boete
{
    private int id;
    private int itemID;
    private BoeteKlasseType boeteKlasseType;
    private boolean betaald;
    
    /**
     * Constructor voor objecten van de klasse Boete.
     *
     * @param id              Het ID van de boete.
     * @param itemID          Het ID van het item die bij de boete hoort.
     * @param boeteKlasseType De klasse van het item van de boete.
     * @param betaald         Of de boete betaald is.
     */
    public Boete(int id, int itemID, BoeteKlasseType boeteKlasseType, boolean betaald)
    {
        this.id = id;
        this.itemID = itemID;
        this.boeteKlasseType = boeteKlasseType;
        this.betaald = betaald;
    }
    
    /**
     * Returned het ID van de boete.
     * 
     * @return Het ID van de boete.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returned het ID van het item die bij de boete hoort.
     * 
     * @return Het ID van het item die bij de boete hoort.
     */
    public int getItemID()
    {
        return itemID;
    }
    
    /**
     * Returned de klasse van het item van de boete.
     * 
     * @return De klasse van het item van de boete.
     */
    public BoeteKlasseType getBoeteKlasseType()
    {
        return boeteKlasseType;
    }
    
    /**
     * Returned of de boete betaald is.
     * 
     * @return true als de boete betaald is, anders false
     */
    public boolean getBetaald()
    {
        return betaald;
    }
    
    /**
     * Betaald de boete indien mogelijk.
     * 
     * @return true als het betalen gelukt is, anders false
     */
    public boolean setBetaald()
    {
        // Controleer of de boete al betaald is.
        if(!betaald)
        {
            betaald = true;
            return true;
        }
        else
        {
            return false;
        }
    }
}
