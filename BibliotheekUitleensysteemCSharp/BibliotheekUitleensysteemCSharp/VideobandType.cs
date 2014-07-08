
/**
 * Enumeratie klasse VideobandType - De videoband types waaruit gekozen kan worden.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
using System;
public class VideobandType : Enum
{
    public VideobandType A, B = new VideobandType();

    public static VideobandType valueOf(Object o)
    {
        return new VideobandType();
    }
}
