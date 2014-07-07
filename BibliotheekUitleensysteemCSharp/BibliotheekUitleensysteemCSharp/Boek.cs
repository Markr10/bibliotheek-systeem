
/**
 * Een klasse om boek objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Boek extends Artikel
{
    /**
     * Constructor voor objecten van de klasse boek.
     *
     * @param id    Het id van het boek.
     * @param titel De titel van het boek.
     * @param type  Het type van het boek.
     */
    public Boek(int id, String titel, BoekType type)
    {
        super(id, titel, type);
    }
}
