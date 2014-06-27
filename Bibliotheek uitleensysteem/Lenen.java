
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Lenen
{
    private int uitleen_id;
    private int artikel_id;
    private int lid_id;
    private String uitleendatum;
    

    /**
     * Constructor for objects of class Geleend
     */
    public Lenen(int uitleen_id, int lid_id, int artikel_id, String uitleenDatum)
    {
        this.uitleen_id = uitleen_id;
        this.lid_id = lid_id;
        this.artikel_id = artikel_id;
        this.uitleendatum = uitleendatum;
    }

}
