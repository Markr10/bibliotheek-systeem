
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Lid
{
    private String name;
    private String address;
    private int artikelenLeenCount = 0;
    private int id = 0;
    private int boete_open;
    private int boete_betaald;
    private int boete_totaal;

    /**
     * Constructor for objects of class Lid
     */
    public Lid(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
    // Get Name 
    public String getName()
    {
        return name;
    }
    
    // Set Name
    public void setName(String name) 
    {
        this.name = name;
    }
    
    // Get Address 
    public String getAddress()
    {
        return address;
    }
    
    // Set Adress
    public void setAdres(String address) 
    {
        this.address = address;
    }
    
    public int getArtikelenLeenCount()
    {
        return artikelenLeenCount;
    }
    
    public boolean incrementArtikelenLeenCount()
    {
        if(artikelenLeenCount < 6)
        {
            artikelenLeenCount++;
            return true;
        }
        else
        {
            return false;
        }
    }
}
