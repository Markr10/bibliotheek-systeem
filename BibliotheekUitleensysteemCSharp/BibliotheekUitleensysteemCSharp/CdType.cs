using System.Linq;
using System.Text;
using System;

/**
 * Enumeratie klasse CdType - De cd types waaruit gekozen kan worden.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class CdType : Enum
{
    public CdType KLASSIEK, POPULAIR = new CdType();

    public static CdType valueOf(Object o)
    {
        return new CdType();
    }
}