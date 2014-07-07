
/**
 * Een exemplaar van een bepaald artikel.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class Exemplaar
{
    private int id;
    private int artikelID;

    /**
     * Constructor voor objecten van de klasse Exemplaar.
     *
     * @param id        Het ID van het exemplaar.
     * @param artikelID Het artikelID van het exemplaar.
     */
    public Exemplaar(int id, int artikelID)
    {
        this.id = id;
        this.artikelID = artikelID;
    }
    
    /**
     * Returned het ID van het exemplaar.
     * 
     * @return Het ID van het exemplaar.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returned het artikelID van het exemplaar.
     * 
     * @return Het artikelID van het exemplaar.
     */
    public int getArtikelID()
    {
        return artikelID;
    }
}
