import java.util.ArrayList;
/**
 * Een abstracte klasse waarmee artikelen gemaakt kunnen worden.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public abstract class Artikel
{
    // Artikel variabelen (protected waar nodig)
    private int id;
    private String titel;
    protected Enum type;
    private boolean nietMeerInGebruik;
    
    /**
     * Constructor voor objecten van de klasse artikel.
     *
     * @param id    Het id van het artikel.
     * @param titel De titel van het artikel.
     * @param type  Het type van het artikel.
     */
    public Artikel(int id, String titel, Enum type)
    {
        this.id = id;
        this.titel = titel;
        this.type = type;
        
        nietMeerInGebruik = false;
    }
    
    /**
     * Returned het ID van het artikel.
     * 
     * @return Het ID van het artikel.
     */
    public int getID() 
    {
        return id;
    }
    
    /**
     * Returned de titel van het artikel.
     * 
     * @return De titel van het artikel.
     */
    public String getTitel() 
    {
        return titel;
    }
    
    /**
     * Returned of een artikel niet meer gebruikt mag worden.
     * 
     * @return De niet meer gebruikt status van het artikel.
     */
    public boolean getNietMeerInGebruik() 
    {
        return nietMeerInGebruik;
    }

    /**
     * Stelt in dat het artikel niet meer gebruikt mag worden.
     * 
     * @return true als het instellen gelukt is, anders false
     */
    public boolean setNietMeerInGebruik()
    {
        if(!nietMeerInGebruik)
        {
            nietMeerInGebruik = true;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Returned de titel van het artikel.
     * 
     * @return De titel van het artikel.
     */
    public String setTitel(String titel) 
    {
        this.titel = titel;
        return titel;
    }

    /**
     * Returned het type van het artikel.
     * 
     * @return Het type van het artikel.
     */
    public Enum setType(Enum type) 
    {
        this.type = type;
        return type;
    }
    
    /**
     * Method toString
     *
     * @return naam van de klasse + het type
     */
    @Override
    public String toString()
    {
        return (this.getClass().getSimpleName() + " " + type.toString());
    }
}
