
/**
 * Een klasse om videoband objecten te creëren.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Videoband extends Artikel
{
    /**
     * Constructor voor objecten van de klasse videoband.
     *
     * @param id             Het id van de videoband.
     * @param titel          De titel van de videoband.
     * @param type           Het type van de videoband.
     */
    public Videoband(int id, String titel, VideobandType type)
    {
        super(id, titel, type);
    }
}
