
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
    
    /**
     * Stelt de releasedatum van de cd in.
     */
    public void setReleasedatum(String releasedatum) 
    {
        this.releasedatum = releasedatum;
    }
}
