
/**
 * Een klasse om een uitlening objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Uitlening
{
    private int id;
    private int lidID;
    private int exemplaarID;
    private String uitleendatum;
    private String terugbrengdatum;
    
    /**
     * Constructor voor objecten van de klasse Uitlening.
     *
     * @param id             Het id van de uitlening.
     * @param lidID          Het lidID van de uitlening.
     * @param exemplaarID    Het exemplaarID van de uitlening.
     */
    public Uitlening(int id, int lidID, int exemplaarID)
    {
        this.id = id;
        this.lidID = lidID;
        this.exemplaarID = exemplaarID;
        this.uitleendatum = SpecialDate.getDateToday();
        
        terugbrengdatum = null;
    }
    
    
    /**
     * Returned het ID van de uitlening.
     * 
     * @return Het ID van de uitlening.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returned het lidID van de uitlening.
     * 
     * @return Het lidID van de uitlening.
     */
    public int getLidID()
    {
        return lidID;
    }
    
    /**
     * Returned het exemplaarID van de uitlening.
     * 
     * @return Het exemplaarID van de uitlening.
     */
    public int getExemplaarID()
    {
        return exemplaarID;
    }
    
    /**
     * Returned de uitleendatum van de uitlening.
     * 
     * @return De uitleendatum van de uitlening.
     */
    public String getUitleendatum()
    {
        return uitleendatum;
    }
    
    /**
     * Returned de terugbrengdatum van de uitlening.
     * 
     * @return De terugbrengdatum van de uitlening als
     * de uitlening ooit is teruggebracht, anders null.
     */
    public String getTerugbrengdatum()
    {
        return terugbrengdatum;
    }
    
    
    /**
     * Stelt de terugbrengdatum van de uitlening in.
     * 
     * @return true als het instellen gelukt is, anders false
     */
    public boolean setTerugbrengdatum()
    {
        // Controleer of de uitlening teruggebracht kan worden.
        if(terugbrengdatum == null)
        {
            terugbrengdatum = SpecialDate.getDateToday();
            return true;
        }
        else
        {
            return false;
        }
    }
    
//     /** // NOTE: Waarschijnlijk overbodig
//      * Stelt de terugbrengdatum van de uitlening in.
//      * 
//      * @param datum De datum waarop de uitlening teruggebracht is.
//      * Deze datum mag niet in de toekomst liggen en
//      * moet zijn in het formaat "ddMMyyyy".
//      * @return true als het instellen gelukt is, anders false
//      */
//     public boolean setTerugbrengdatum(String datum)
//     {
//         // Controleer de datum en of de uitlening teruggebracht kan worden.
//         if(SpecialDate.checkDate(datum) && (terugbrengdatum == null))
//         {
//             terugbrengdatum = datum;
//             return true;
//         }
//         else
//         {
//             return false;
//         }
//     }
}
