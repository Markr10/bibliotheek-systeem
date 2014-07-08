using System;

/**
 * Enumeratie klasse BoekType - De boek types waaruit gekozen kan worden.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class BoekType : Enum
{
    public BoekType STUDIEBOEK, ROMAN = new BoekType();

    public static BoekType valueOf(Object o)
    {
        return new BoekType();
    }
}
