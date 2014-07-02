import java.util.ArrayList;
import java.util.LinkedHashMap;
/**
 * Bibliotheek klasse welke verschillende onderdelen van een bibliotheek beheert.
 * Hierbij moet gedacht worden aan leden, artikelen, boetes, reserveringen, uitlenen en innemen.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 * 
 */
public class Bibliotheek
{
    public static final short MAX_AANTAL_DAGEN_RESERVERING_OPHALEN = 7;
    private static final short MAX_AANTAL_ARTIKELEN = 6;
    private static final short RESERVERINGSKOSTEN = 30; // in centen
    private static final short RESERVERING_BOETE = 200; // in centen
    public static final short MAX_AANTAL_DAGEN_NA_TWEEDE_BRIEF = 14;
    protected static final int DREMPEL_EERSTE_BRIEF = 1000; // in centen
    protected static final int DREMPEL_TWEEDE_BRIEF = 10000; // in centen

    protected ArrayList<Lid> leden;   // Leden
    protected ArrayList<Reservering> reserveringen; // Reserveringen
    private ArrayList<Uitlening> uitleningen; // Uitleningen
    protected ArrayList<Artikel> artikelen; // Artikelen
    private ArrayList<Exemplaar> exemplaren; // Exemplaren
    private ArrayList<Boete> boetes; // Exemplaren

    
    /**
     * Constructor voor objecten van de klasse Bibliotheek.
     */
    public Bibliotheek()
    {
        leden = new ArrayList<Lid>();
        reserveringen = new ArrayList<Reservering>();
        uitleningen = new ArrayList<Uitlening>();
        artikelen = new ArrayList<Artikel>();
        exemplaren = new ArrayList<Exemplaar>();
    }   

    
    /**
     * Controleert of een ID van een lid geldig is.
     *
     * @param id Het ID van het lid.
     * @return true als het ID geldig is, anders false
     */
    private boolean checkLidID(int id)
    {
        if(id >= 0 && id <= (leden.size() - 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Controleert of een ID van een reservering geldig is.
     *
     * @param id Het ID van het reservering.
     * @return true als het ID geldig is, anders false
     */
    private boolean checkReserveringID(int id)
    {
        if(id >= 0 && id <= (reserveringen.size() - 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Controleert of een ID van een uitlening geldig is.
     *
     * @param id Het ID van de uitlening.
     * @return true als het ID geldig is, anders false
     */
    private boolean checkUitleningID(int id)
    {
        if(id >= 0 && id <= (uitleningen.size() - 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Controleert of een ID van een artikel geldig is.
     *
     * @param id Het ID van het artikel.
     * @return true als het ID geldig is, anders false
     */
    private boolean checkArtikelID(int id)
    {
        if(id >= 0 && id <= (artikelen.size() - 1) && !artikelen.get(id).getNietMeerInGebruik())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Controleert of een ID van een exemplaar geldig is.
     *
     * @param id Het ID van het exemplaar.
     * @return true als het ID geldig is, anders false
     */
    private boolean checkExemplaarID(int id)
    {
        if(id >= 0 && id <= (exemplaren.size() - 1) && !artikelen.get(exemplaren.get(id).getArtikelID()).getNietMeerInGebruik())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Controleert of een ID van een boete geldig is.
     *
     * @param id Het ID van de boete.
     * @return true als het ID geldig is, anders false
     */
    private boolean checkBoeteID(int id)
    {
        if(id >= 0 && id <= (boetes.size() - 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    /**
     * Returned de uitleen status van een exemplaar.
     *
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het exemplaar uitgeleend is, anders false
     */
    public boolean getUitgeleend(int exemplaarID)
    {        
        // Controleert geldigheid parameter
        if(checkExemplaarID(exemplaarID))
        {
            // Controleert, indien beschikbaar, de laatste uitlening van het exemplaar.
            for(int i = (uitleningen.size() - 1); i >= 0; i--)
            {
                if(uitleningen.get(i).getExemplaarID() == exemplaarID)
                {
                    // Dit is het geval wanneer een lid het exemplaar te leen heeft.
                    if(uitleningen.get(i).getTerugbrengdatum() == null)
                    {
                        return true;
                    }
                    break;
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan is het exemplaar niet uitgeleend.
        return false;
    }

    /**
     * Returned of de reservering opgehaald/uitgeleend is.
     * 
     * @param reservering De reservering die gecontroleerd moet worden.
     * @return true als het reservering opgehaald/uitgeleend is, anders false
     */
    public boolean getReserveringUitgeleend(Reservering reservering)
    {
        // Controleert geldigheid parameter en of de reservering klaargezet is.
        // Omdat Reservering.setReserveringKlaar het exemplaarID en de maximale ophaaldatum beheerd, hoeft hier niet op gecontroleerd te worden.
        if(checkReserveringID(reservering.getID()) && reservering.getDatumKlaargezet() != null)
        {
            // Loopt van eerste naar laatste uitlening omdat eerste keer uitlenen tijdens ophaaltermijn de juiste is.
            for(int i = 0, length = (uitleningen.size() - 1); i <= length; i++)
            {
                Uitlening uitlening = uitleningen.get(i);
                // Controleert, indien beschikbaar, of het lid het exemplaar van de reservering binnen de datum van klaarzetten en de maximale ophaaldatum geleend heeft.
                if(uitlening.getLidID() == reservering.getLidID() && uitlening.getExemplaarID() == reservering.getExemplaarID() &&
                SpecialDate.daysDifference(uitlening.getUitleendatum(), reservering.getDatumKlaargezet()) >= 0 &&
                SpecialDate.daysDifference(reservering.getMaxOphaaldatum(), uitlening.getUitleendatum()) >= 0)
                {
                    return true;
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan is het exemplaar niet uitgeleend.
        return false;
    }

    /**
     * Returned of een lener een artikel mag lenen of reserveren.
     *
     * @param lidID     Het ID van het lid.
     * @param artikelID Het ID van het artikel.
     * @return true als een lener een artikel mag lenen of reserveren, anders false
     */
    public boolean lidMagArtikelLenenOfReserveren(int lidID, int artikelID)
    {
        /*
         * Dit is het geval als het lid niet geroyaleerd is, wanneer een lid het artikel niet te leen heeft, wannneer
         * een lid het artikel niet gereserveerd heeft en of een lid nog ruimte heeft om een artikel te reserveren of te lenen.
         */

        // Controleert geldigheid parameters en of het lid niet geroyaleerd is.
        if(checkLidID(lidID) && checkArtikelID(artikelID) && !leden.get(lidID).isGeroyeerd())
        {
            int artikelenLeenCount = 0;

            // Controleert, indien beschikbaar, de laatste uitlening van een exemplaar van het artikel en
            // hoeveel artikelen een lener geleend heeft.
            for(int i = (uitleningen.size() -1); i >= 0; i--)
            {
                if(uitleningen.get(i).getLidID() == lidID && uitleningen.get(i).getTerugbrengdatum() == null)
                {
                    artikelenLeenCount++;

                    // Controleert of lid artikel te leen heeft.
                    // Alle uitleningen hebben een geldig exemplaarID.
                    if(exemplaren.get(uitleningen.get(i).getExemplaarID()).getArtikelID() == artikelID)
                    {
                        return false;
                    }
                    else if(artikelenLeenCount >= Bibliotheek.MAX_AANTAL_ARTIKELEN) // checkt artikelenLeenCount
                    {
                        return false;
                    }
                }
            }

            // Controleert, indien beschikbaar, op hoeveel openstaande reserveringen een lener heeft en
            // of deze reserveringen exemplaren zijn van het artikel.
            // Onder openstaande reserveringen vallen reserveringen zonder exemplaar en reserveringen die
            // nog beschikbaar zijn en nog niet zijn uitgeleend.
            for(int i = (reserveringen.size() -1); i >= 0; i--)
            {
                Reservering reservering = reserveringen.get(i);
                if(reservering.getLidID() == lidID && (reservering.getMaxOphaaldatum() == null ||
                    (SpecialDate.checkDateNowAndFuture(reservering.getMaxOphaaldatum()) && !getReserveringUitgeleend(reservering))))
                {
                    artikelenLeenCount++;

                    // Controleert of lid artikel gereserveerd heeft.
                    // Hierbij wordt ervan uitgegaan dat alle reserveringen een geldig artikelID hebben.
                    if(reserveringen.get(i).getArtikelID() == artikelID)
                    {
                        return false;
                    }
                    else if(artikelenLeenCount >= Bibliotheek.MAX_AANTAL_ARTIKELEN) // checkt artikelenLeenCount
                    {
                        return false;
                    }
                }
            }

            // Een lener mag een artikel lenen of reserveren.
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returned het eerste openstaande reservering object wanneer er een openstaande reservering is voor een bepaald artikel en
     * het lid deze reservering toegewezen mag krijgen.
     * 
     * @param artikelID Het ID van het artikel.
     * @return Het openstaande reservering object, anders null.
     */
    public Reservering getOpenReservering(int artikelID)
    {
        // Controleert geldigheid parameter.
        if(checkArtikelID(artikelID))
        {
            // Loopt van de eerste naar laatste reservering omdat de langste openstaande reservering een exemplaar van een artikel moet krijgen.
            for(int i = 0, length = (reserveringen.size() - 1); i <= length; i++)
            {
                Reservering reservering = reserveringen.get(i);
                if(reservering.getDatumKlaargezet() == null && reservering.getArtikelID() == artikelID &&
                    !leden.get(reservering.getLidID()).isGeroyeerd())
                {
                    return reservering;
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan bestaat er geen open reservering voor dat artikel.
        return null;
    }
    
    /**
     * Returned of een exemplaar gereserveerd is.
     *     
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het exemplaar gereserveerd is, anders false
     */
    public boolean getGereserveerdExemplaar(int exemplaarID)
    {
        // Controleert geldigheid parameter
        if(checkExemplaarID(exemplaarID))
        {
            // Controleert, indien beschikbaar, de laatste reservering van het exemplaar.
            for(int i = (reserveringen.size() - 1); i >= 0; i--)
            {
                Reservering reservering = reserveringen.get(i);
                // Controleert of een exemplaar voor een lid gereserveerd is.
                if(reservering.getExemplaarID() == exemplaarID)
                {
                    // Controleert of de reservering nog opgehaald kan worden.
                    if(!getReserveringUitgeleend(reservering) && SpecialDate.checkDateNowAndFuture(reservering.getMaxOphaaldatum()))
                    {
                        return true;
                    }
                    break;
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan is het exemplaar niet voor een lid gereserveerd.
        return false;
    }
    
    /**
     * Returned of een exemplaar voor een lid gereserveerd is.
     *     
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het exemplaar gereserveerd is voor het lid, anders false
     */
    public boolean getGereserveerdVoorLid(int lidID, int exemplaarID)
    {
        // Controleert geldigheid parameters
        if(checkLidID(lidID) && checkExemplaarID(exemplaarID))
        {
            // Controleert, indien beschikbaar, de laatste reservering van het exemplaar.
            for(int i = (reserveringen.size() - 1); i >= 0; i--)
            {
                Reservering reservering = reserveringen.get(i);
                // Controleert of een exemplaar voor een lid gereserveerd is.
                if(reservering.getLidID() == lidID && reservering.getExemplaarID() == exemplaarID)
                {
                    // Controleert of de reservering nog opgehaald kan worden.
                    if(!getReserveringUitgeleend(reservering) && SpecialDate.checkDateNowAndFuture(reservering.getMaxOphaaldatum()))
                    {
                        return true;
                    }
                    break;
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan is het exemplaar niet voor een lid gereserveerd.
        return false;
    }

    /**
     * Returned het uitlening object als een exemplaar is uitgeleend en als dat exemplaar is uitgeleend aan een bepaald lid.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     * @return Het laaste uitlening object van het exemplaar dat is uitgeleend aan het lid, bij incorrecte status null.
     */
    public Uitlening checkAndGetUitgeleendEnAanLid(int lidID, int exemplaarID)
    {
        // Controleert geldigheid parameters
        if(checkLidID(lidID) && checkExemplaarID(exemplaarID))
        {
            // Controleert, indien beschikbaar, de laatste uitlening van het exemplaar.
            for(int i = (uitleningen.size() - 1); i >= 0; i--)
            {
                Uitlening uitlening = uitleningen.get(i);
                if(uitlening.getExemplaarID() == exemplaarID)
                {
                    // Controleert of het exemplaar uitgeleend is aan het lid.
                    if(uitlening.getTerugbrengdatum() == null && uitlening.getLidID() == lidID)
                    {
                        return uitlening;
                    }
                    break;
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan is het exemplaar niet uitgeleend.
        return null;
    }
    
    /**
     * Returned het verschuldigde bedrag van een lid aan de bibliotheek.
     * Hieronder vallen openstaande boetes van een lid in centen en niet betaalde reserveringen van een lid.
     *     
     * @param lidID       Het ID van het lid.
     * @return Het verschuldigde bedrag van een lid aan de bibliotheek.
     */
    public int getVerschuldigdBedragLid(int lidID)
    {
        int totaalVerschuldigd = 0;
        // Controleert geldigheid parameters
        if(checkLidID(lidID))
        {
            // Controleert de boetes.
            for(int i = (boetes.size() - 1); i >= 0; i--)
            {
                // Controleert de boete in de juiste ArrayList.
                switch(boetes.get(i).getBoeteKlasseType())
                {
                    case RESERVERING:
                    {
                        Reservering reservering = reserveringen.get(boetes.get(i).getItemID());
                        // Controleert of een boete van het lid is en openstaat.
                        if(reservering.getLidID() == lidID && !boetes.get(i).getBetaald())
                        {
                            totaalVerschuldigd += RESERVERING_BOETE;
                        }
                        break;
                    }
                    case UITLENING:
                    {
                        Uitlening uitlening = uitleningen.get(boetes.get(i).getItemID());
                        // Controleert of een boete van het lid is en openstaat.
                        if(uitlening.getLidID() == lidID && !boetes.get(i).getBetaald())
                        {
                            // Berekent kosten boete en telt deze op bij het totaal.
                            totaalVerschuldigd += getVerschuldigdBedragUitlening(uitlening);
                        }
                        break;
                    }
                }
            }

            // Controleert de reserveringen.
            for(int i = (reserveringen.size() - 1); i >= 0; i--)
            {
                Reservering reservering = reserveringen.get(i);
                // Controleert of het lid een reservering heeft die niet betaald is.
                if(reservering.getLidID() == lidID && !reservering.getReserveringskostenBetaald())
                {
                    // Haalt de kosten van de reservering op en telt deze op bij het totaal.
                    totaalVerschuldigd += RESERVERINGSKOSTEN;
                }
            }
        }
        return totaalVerschuldigd;
    }

    /**
     * Returned het op dit moment verschuldigde bedrag voor een uitlening.
     *
     * @param uitlening De uitlening waarvoor het op dit moment verschuldigde bedrag uitgerekend moet worden.
     * @return Het verschuldigde bedrag voor de uitlening in centen.
     * @return Het verschuldigde bedrag voor de uitlening als de uitlening correct is, anders -1
     */
    public int getVerschuldigdBedragUitlening(Uitlening uitlening)
    {
        // Controleer of de uitlening teruggebracht is.
        if(checkUitleningID(uitlening.getID()) && uitlening.getTerugbrengdatum() != null)
        {
            double dagen, weken, leeftijd;
            dagen = weken = leeftijd = 0;
            double boetePrijs = 0;
            double leenPrijs = 0;
            double totaalPrijs = 0;
            double bedragBoete = 0;
            final short PRIJS_CD_KLASSIEK = 2; // in euro's
            final short PRIJS_CD_POPULAIR = 1; // in euro's
            final short PRIJS_VIDEO_A = 2; // in euro's
            final short PRIJS_VIDEO_B = 2; // in euro's
            final short PRIJS_BOEK_ROMAN = 0; // in euro's
            final short PRIJS_BOEK_STUDIE = 0; // in euro's

            int verschilDagen = SpecialDate.daysDifference(uitlening.getUitleendatum(), uitlening.getTerugbrengdatum());

            // Berekent het verschuldigde bedrag aan de hand van het artikel signature.
            switch(artikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID()).toString())
            {
                //Voor populaire Cd’s zijn deze bedragen respectievelijk € 1,00 en € 2,00
                //Deze korting wordt gegeven op het totale leengeld voor de betreffende CD
                //en bedraagt:
                //als 1 jaar < leeftijd <= 5 jaar : 10%
                //als 5 jaar < leeftijd           : 50 %

                case "Cd POPULAIR": 
                {
                    leeftijd = SpecialDate.roundedYearsDifference(((Cd)artikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID())).getReleasedatum());
                    if(leeftijd < 1)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = PRIJS_CD_POPULAIR;
                            boetePrijs = 0;
                            totaalPrijs = leenPrijs + boetePrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = PRIJS_CD_POPULAIR;
                            boetePrijs = 2.00; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd >= 1 && leeftijd <= 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 90;
                            boetePrijs = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 90;
                            boetePrijs = 2.00; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd > 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 50;
                            boetePrijs = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 50;
                            boetePrijs = 2.00; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                }
                break;
                case "Cd KLASSIEK": 
                {
                    leeftijd = SpecialDate.roundedYearsDifference(((Cd)artikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID())).getReleasedatum());
                    System.out.println(leeftijd);
                    if(leeftijd < 1)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = PRIJS_CD_KLASSIEK;
                            boetePrijs = 0;
                            totaalPrijs = leenPrijs + boetePrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = PRIJS_CD_KLASSIEK;
                            boetePrijs = 1.50; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd >= 1 && leeftijd <= 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 90;
                            boetePrijs = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 90;
                            boetePrijs = 1.50; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd > 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 50;
                            boetePrijs = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 50;
                            boetePrijs = 1.50; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                }
                break;
                case "Videoband A":
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = PRIJS_VIDEO_A;
                    boetePrijs = 0;
                    totaalPrijs = leenPrijs * dagen + boetePrijs;
                }
                break;
                case "Videoband B":
                {
                    if(verschilDagen <= 3)
                    {
                        dagen = verschilDagen;
                        if(dagen == 0)
                        {
                            dagen++;
                        }
                        leenPrijs = PRIJS_VIDEO_B;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                    else
                    {
                        dagen = verschilDagen - 3;
                        leenPrijs = PRIJS_VIDEO_B;
                        boetePrijs = dagen * 1.00; // na 3 dagen
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                }
                break;
                
                case "Boek ROMAN":
                {
                    if(verschilDagen <= 21)
                    {
                        dagen = verschilDagen;
                        if(dagen == 0)
                        {
                            dagen++;
                        }
                        leenPrijs = dagen * PRIJS_BOEK_ROMAN;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                    else
                    {
                        dagen = verschilDagen - 21;
                        leenPrijs = PRIJS_BOEK_ROMAN;
                        boetePrijs = dagen * 0.25; // na 21 dagen
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                }
                break;
                
                case "Boek STUDIEBOEK":
                {
                    if(verschilDagen <= 30)
                    {
                        dagen = verschilDagen;
                        if(dagen == 0)
                        {
                            dagen++;
                        }
                        leenPrijs = dagen * PRIJS_BOEK_STUDIE;
                        boetePrijs = 0;
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                    else
                    {
                        weken = verschilDagen - 30;// eerste 30 gratis
                        dagen = Math.ceil(weken / 7.0);
                        leenPrijs = PRIJS_BOEK_STUDIE;
                        boetePrijs = dagen * 1.00; // na 30 dagen
                        totaalPrijs = leenPrijs + boetePrijs;
                    }
                }
                break;
                default:
                {
                    // stopt methode, dus geen break nodig
                    return -1;
                }
            }
            return (int)(totaalPrijs*100);
        }
        else
        {
            return -1;
        }
    }

    /**
     * Returned het op dit moment boete bedrag voor een uitlening.
     *
     * @param uitlening De uitlening waarvoor het op dit moment boete bedrag uitgerekend moet worden.
     * @return Het boete bedrag voor de uitlening in centen.
     * @return Het boete bedrag voor de uitlening als de uitlening correct is, anders -1
     */
    public int getBoeteBedragUitlening(Uitlening uitlening)
    {
        // Controleer of de uitlening teruggebracht is.
        if(checkUitleningID(uitlening.getID()) && uitlening.getTerugbrengdatum() != null)
        {
            double dagen, weken, leeftijd;
            dagen = weken = leeftijd = 0;
            double boetePrijs = 0;
            double leenPrijs = 0;
            double totaalPrijs = 0;
            double bedragBoete = 0;
            final short PRIJS_CD_KLASSIEK = 2; // in euro's
            final short PRIJS_CD_POPULAIR = 1; // in euro's
            final short PRIJS_VIDEO_A = 2; // in euro's
            final short PRIJS_VIDEO_B = 2; // in euro's
            final short PRIJS_BOEK_ROMAN = 0; // in euro's
            final short PRIJS_BOEK_STUDIE = 0; // in euro's

            int verschilDagen = SpecialDate.daysDifference(uitlening.getUitleendatum(), uitlening.getTerugbrengdatum());

            // Berekent het verschuldigde bedrag aan de hand van het artikel signature.
            switch(artikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID()).toString())
            {
                //Voor populaire Cd’s zijn deze bedragen respectievelijk € 1,00 en € 2,00
                //Deze korting wordt gegeven op het totale leengeld voor de betreffende CD
                //en bedraagt:
                //als 1 jaar < leeftijd <= 5 jaar : 10%
                //als 5 jaar < leeftijd           : 50 %

                case "Cd POPULAIR": 
                {
                    leeftijd = SpecialDate.roundedYearsDifference(((Cd)artikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID())).getReleasedatum());
                    if(leeftijd < 1)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = PRIJS_CD_POPULAIR;
                            bedragBoete = 0;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = PRIJS_CD_POPULAIR;
                            boetePrijs = 2.00; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd >= 1 && leeftijd <= 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 90;
                            bedragBoete = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 90;
                            boetePrijs = 2.00; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd > 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 50;
                            bedragBoete = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_POPULAIR / 100) * 50;
                            boetePrijs = 2.00; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                }
                break;
                case "Cd KLASSIEK": 
                {
                    leeftijd = SpecialDate.roundedYearsDifference(((Cd)artikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID())).getReleasedatum());
                    System.out.println(leeftijd);
                    if(leeftijd < 1)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = PRIJS_CD_KLASSIEK;
                            bedragBoete = 0;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = PRIJS_CD_KLASSIEK;
                            boetePrijs = 1.50; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd >= 1 && leeftijd <= 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 90;
                            bedragBoete = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 90;
                            boetePrijs = 1.50; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                    if(leeftijd > 5)
                    {
                        if(verschilDagen <= 10)
                        {
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 50;
                            bedragBoete = 0;
                            totaalPrijs = leenPrijs;
                        }
                        else
                        {
                            weken = verschilDagen - 10; // eerste week gratis
                            dagen = (int) Math.ceil(weken / 7);
                            leenPrijs = (PRIJS_CD_KLASSIEK / 100) * 50;
                            boetePrijs = 1.50; // per week
                            bedragBoete = boetePrijs * dagen;
                            totaalPrijs = leenPrijs + bedragBoete;
                        }
                    }
                }
                break;
                case "Videoband A":
                {
                    dagen = verschilDagen;
                    if(dagen == 0)
                    {
                        dagen++;
                    }
                    leenPrijs = PRIJS_VIDEO_A;
                    bedragBoete = 0;
                    totaalPrijs = leenPrijs * dagen + bedragBoete;
                }
                break;
                case "Videoband B":
                {
                    if(verschilDagen <= 3)
                    {
                        dagen = verschilDagen;
                        if(dagen == 0)
                        {
                            dagen++;
                        }
                        leenPrijs = PRIJS_VIDEO_B;
                        bedragBoete = 0;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                    else
                    {
                        dagen = verschilDagen - 3;
                        leenPrijs = PRIJS_VIDEO_B;
                        bedragBoete = dagen * 1.00; // na 3 dagen
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                break;
                
                case "Boek ROMAN":
                {
                    if(verschilDagen <= 21)
                    {
                        dagen = verschilDagen;
                        if(dagen == 0)
                        {
                            dagen++;
                        }
                        leenPrijs = dagen * PRIJS_BOEK_ROMAN;
                        bedragBoete = 0;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                    else
                    {
                        dagen = verschilDagen - 21;
                        leenPrijs = PRIJS_BOEK_ROMAN;
                        bedragBoete = dagen * 0.25; // na 21 dagen
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                break;
                
                case "Boek STUDIEBOEK":
                {
                    if(verschilDagen <= 30)
                    {
                        dagen = verschilDagen;
                        if(dagen == 0)
                        {
                            dagen++;
                        }
                        leenPrijs = dagen * PRIJS_BOEK_STUDIE;
                        bedragBoete = 0;
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                    else
                    {
                        weken = verschilDagen - 30;// eerste 30 gratis
                        dagen = Math.ceil(weken / 7.0);
                        leenPrijs = PRIJS_BOEK_STUDIE;
                        bedragBoete = dagen * 1.00; // na 30 dagen
                        totaalPrijs = leenPrijs + bedragBoete;
                    }
                }
                break;
                default:
                {
                    // stopt methode, dus geen break nodig
                    return -1;
                }
            }
            return (int)(bedragBoete*100);
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * Controleer of exemplaren van een artikel uitgeleend of gereserveerd zijn.
     * 
     * @param artikelID Het ID van het artikel.
     * @return true als exemplaren van het artikel zijn uitgeleend of gereserveerd, anders false
     */
    public boolean getArtikelExemplarenUigeleendOfGereserveerd(int artikelID)
    {
        if(checkLidID(artikelID))
        {
            // Controleert, indien beschikbaar, of de exemplaren van het artikel uitgeleend of gereserveerd zijn
            for(int i = (exemplaren.size() - 1); i >= 0; i--)
            {
                Exemplaar exemplaar = exemplaren.get(i);
                if(exemplaar.getArtikelID() == artikelID)
                {
                    // Controleert of het exemplaar is uitgeleend of gereserveerd.
                    if(getUitgeleend(exemplaar.getID()) || getGereserveerdExemplaar(exemplaar.getID()))
                    {
                        return true;
                    }
                }
            }
        }
        // Wanneer bovenstaande testen niet slagen, dan zijn de mogelijke exemplaren van het artikel niet uitgeleend of gereserveerd
        return false;
    }
    
    
    /**
     * Voegt een nieuw lid toe.
     *
     * @param naam De naam van het lid.
     */
    public void addLid(String naam)
    {
        // Genereert lidID aan hand van lengte ArrayList.
        leden.add(new Lid(leden.size(), naam));
    }

    /**
     * Voegt een nieuw boek toe.
     *
     * @param titel De titel van het boek.
     * @param type  Het type van het boek. Het type is niet hoofdletter gevoelig.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean addBoek(String titel, String type)
    {
        // Zorgt voor een correct type.
        try
        {
            // Genereert ID/artikelID aan hand van lengte ArrayList.
            artikelen.add(new Boek(artikelen.size(), titel, BoekType.valueOf(type.toUpperCase())));
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    /**
     * Voegt een nieuwe cd toe.
     *
     * @param titel        De titel van de cd.
     * @param type         Het type van de cd. Het type is niet hoofdletter gevoelig.
     * @param releasedatum De releasedatum van de cd.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean addCd(String titel, String type, String releasedatum)
    {
        // Controleert geldigheid releasedatum parameter
        if(SpecialDate.checkDate(releasedatum))
        {
            // Zorgt voor een correct type.
            try
            {
                // Genereert ID/artikelID aan hand van lengte ArrayList.
                artikelen.add(new Cd(artikelen.size(), titel, CdType.valueOf(type.toUpperCase()), releasedatum));
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Voegt een nieuwe videoband toe.
     *
     * @param titel De titel van de videoband.
     * @param type  Het type van de videoband. Het type is niet hoofdletter gevoelig.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean addVideoband(String titel, String type)
    {
        try
        {
            // Genereert ID/artikelID aan hand van lengte ArrayList.
            artikelen.add(new Videoband(artikelen.size(), titel, VideobandType.valueOf(type.toUpperCase())));
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    /**
     * Voegt een exemplaar van een artikel toe.
     * 
     * @param artikelID Het artikelID van het exemplaar.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean addExemplaar(int artikelID)
    {
        if(checkArtikelID(artikelID))
        {
            exemplaren.add(new Exemplaar(exemplaren.size(), artikelID));
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Wijzigt een CD artikel.
     * 
     * @param artikelID Het ID van het artikel.
     * @param titel        De titel van de cd.
     * @param type         Het type van de cd. Het type is niet hoofdletter gevoelig.
     * @param releasedatum De releasedatum van de cd.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean wijzigCD(int artikelID, String titel, String type, String releasedatum)
    {
        // Controleert geldigheid releasedatum en artikelID parameters
        if(SpecialDate.checkDate(releasedatum) && checkArtikelID(artikelID))
        {
            // Zorgt voor een correct type.
            try
            {
                artikelen.get(artikelID).setTitel(titel);                
                artikelen.get(artikelID).setType(CdType.valueOf(type.toUpperCase()));
                ((Cd)artikelen.get(artikelID)).setReleasedatum(releasedatum);
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Wijzigt een boek artikel.
     * 
     * @param artikelID Het ID van het artikel.
     * @param titel        De titel van de boek.
     * @param type         Het type van de boek. Het type is niet hoofdletter gevoelig.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean wijzigBoek(int artikelID, String titel, String type)
    {
        // Controleert geldigheid artikelID parameter
        if(checkArtikelID(artikelID))
        {
            // Zorgt voor een correct type.
            try
            {
                artikelen.get(artikelID).setTitel(titel);                
                artikelen.get(artikelID).setType(BoekType.valueOf(type.toUpperCase()));
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Wijzigt een videoband artikel.
     * 
     * @param artikelID Het ID van het artikel.
     * @param titel        De titel van de boek.
     * @param type         Het type van de boek. Het type is niet hoofdletter gevoelig.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean wijzigVideoband(int artikelID, String titel, String type)
    {
        // Controleert geldigheid artikelID parameter
        if(checkArtikelID(artikelID))
        {
            // Zorgt voor een correct type.
            try
            {
                artikelen.get(artikelID).setTitel(titel);                
                artikelen.get(artikelID).setType(VideobandType.valueOf(type.toUpperCase()));
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Voegt een nieuwe reservering toe.
     *
     * @param lidID     Het ID van het lid.
     * @param artikelID Het ID van het artikel.
     * @return true als het toevoegen gelukt is, anders false
     */
    public boolean addReservering(int lidID, int artikelID)
    {
        // Controleert geldigheid parameters en kijk of lid het artikel mag reserveren
        if(checkLidID(lidID) && checkArtikelID(artikelID) && lidMagArtikelLenenOfReserveren(lidID, artikelID))
        {
            // Genereert reserveringID aan hand van lengte ArrayList.
            reserveringen.add(new Reservering(reserveringen.size(), lidID, artikelID));
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Leent een exemplaar uit.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het uitlenen van het exemplaar gelukt is, anders false
     */
    public boolean addUitlening(int lidID, int exemplaarID)
    {
        // Controleert geldigheid parameters, controleert of het exemplaar niet uigeleend is,
        // controleert of lid zo'n artikel mag lenen, controleert of als het een gereserveerd exemplaar is en
        // zo ja deze voor het lid gereserveerd is.
        if(checkLidID(lidID) && checkExemplaarID(exemplaarID) && !getUitgeleend(exemplaarID) &&
        lidMagArtikelLenenOfReserveren(lidID, exemplaren.get(exemplaarID).getArtikelID()) && getGereserveerdVoorLid(lidID, exemplaarID))
        {
            uitleningen.add(new Uitlening(uitleningen.size(), lidID, exemplaarID));
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /**
     * Stelt in dat het artikel niet meer gebruikt mag worden.
     *
     * @param artikelID Het ID van het artikel.
     * @return true als het inleveren van het exemplaar gelukt is, anders false
     */
    public boolean verwijderArtikel(int artikelID)
    {
        if(checkArtikelID(artikelID) && artikelen.get(artikelID).setNietMeerInGebruik() && !getArtikelExemplarenUigeleendOfGereserveerd(artikelID))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /**
     * Levert een exemplaar in.
     *
     * @param lidID       Het ID van het lid.
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het inleveren van het exemplaar gelukt is, anders false
     */
    public boolean inleverenExemplaar(int lidID, int exemplaarID)
    {
        if(checkLidID(lidID) && checkExemplaarID(exemplaarID) && !leden.get(lidID).isGeroyeerd())
        {
            Uitlening uitlening = checkAndGetUitgeleendEnAanLid(lidID, exemplaarID);
            // Ga verder als (gevonden) uitlening object correct is, stelt terugbrengdatum uitlening object in.
            if(uitlening != null && uitlening.setTerugbrengdatum())
            {
                getVerschuldigdBedragUitlening(uitlening);
                controleerAndSetReservering(exemplaarID);
                
                return true;
            }
        }
        // In alle andere gevallen
        return false;
    }
    
    /**
     * Controleert of de uitleningen een boete hebben en
     * maakt, indien nodig, de desbetreffende boete items aan.
     */
    public void setBoetes()
    {
        for(int i = (uitleningen.size() - 1); i >= 0; i--)
        {
            Uitlening uitlening = uitleningen.get(i);
            if(getVerschuldigdBedragUitlening(uitlening) > 0 && !getBoeteUitlening(uitlening.getID()))
            {
                boetes.add(new Boete(boetes.size(), uitlening.getID(), BoeteKlasseType.valueOf("UITLENING"), false));
            }
        }
    }
    
    /**
     * Verwerkt verlopen reserveringen.
     * Geeft een boete aan het lid en reserveert, indien er openstaande reserveringen zijn,
     * het exemplaar voor een ander lid.
     * 
     */
    public void verwerkVerlopenReserveringen()
    {
        for(int i = (reserveringen.size() - 1); i >= 0; i--)
        {
            Reservering reservering = reserveringen.get(i);
            if(!getReserveringUitgeleend(reservering) && !SpecialDate.checkDateNowAndFuture(reservering.getMaxOphaaldatum()) &&
                !getBoeteReservering(reservering.getID()))
            {
                boetes.add(new Boete(boetes.size(), reservering.getID(), BoeteKlasseType.valueOf("RESERVERING"), false));
                Reservering openReservering = getOpenReservering(reservering.getArtikelID());
                if(openReservering != null)
                {
                    openReservering.setReserveringKlaar(reservering.getExemplaarID());
                }
            }
        }
    }
    
    /**
     * Controleert of er voor de uitlening een boete bestaat.
     * 
     * @param uitleningID Het ID van de uitlening.
     * @return true als er voor de uitlening een boete bestaat, anders false
     */
    public boolean getBoeteUitlening(int uitleningID)
    {
        for(int i = (boetes.size() - 1); i >= 0; i--)
        {
            Boete boete = boetes.get(i);
            if(boete.getItemID() == uitleningID && boete.getBoeteKlasseType().equals(BoeteKlasseType.valueOf("UITLENING")))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Controleert of er voor de reservering een boete bestaat.
     * 
     * @param reserveringID Het ID van de reservering.
     * @return true als er voor de reservering een boete bestaat, anders false
     */
    public boolean getBoeteReservering(int reserveringID)
    {
        for(int i = (boetes.size() - 1); i >= 0; i--)
        {
            Boete boete = boetes.get(i);
            if(boete.getItemID() == reserveringID && boete.getBoeteKlasseType().equals(BoeteKlasseType.valueOf("RESERVERING")))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Berekent de inkomsten van de bibliotheek.
     * 
     * @return een array met het totaal aan inkomsten en het totaal aan boetes hiervan
     */
    public int[] berekenInkomsten()
    {
        int totaal = 0;
        int totaalBoetes = 0;
        // Doorloop de boetes.
        for(int i = (boetes.size() - 1); i >= 0; i--)
        {
            if(!boetes.get(i).getBetaald())
            {
                continue;
            }
            // Controleert de boete in de juiste ArrayList.
            switch(boetes.get(i).getBoeteKlasseType())
            {
                case RESERVERING:
                {
                    Reservering reservering = reserveringen.get(boetes.get(i).getItemID());
                    totaal += RESERVERING_BOETE;
                }
                break;
                case UITLENING:
                {
                    Uitlening uitlening = uitleningen.get(boetes.get(i).getItemID());
                    totaal += getVerschuldigdBedragUitlening(uitlening);
                    totaalBoetes += getBoeteBedragUitlening(uitlening);
                }
                break;
            }
        }
        return new int[] {totaal, totaalBoetes};
    }

    /**
     * Controleert of er openstaande reserveringen zijn voor het artikel van een ingeleverd exemplaar en
     * kent aan de eerste open reservering het exemplaar toe.
     * 
     * @param exemplaarID Het ID van het exemplaar.
     * @return true als het vinden van een openstaande reservering en het toekennen van het exemplaar gelukt is, anders false
     */
    public boolean controleerAndSetReservering(int exemplaarID)
    {
        // Controleert geldigheid parameter en kijkt of het exemplaar niet uitgeleend is. 
        if(checkExemplaarID(exemplaarID) && !getUitgeleend(exemplaarID))
        {
            // Zoekt openstaande reservering op en zet deze klaar.
            Reservering reservering = getOpenReservering(exemplaren.get(exemplaarID).getArtikelID());
            if(reservering != null && reservering.setReserveringKlaar(exemplaarID))
            {
                return true;
            }
        }
        // In alle andere gevallen
        return false;
    }
    
    /**
     * Betaalt de openstaande boetes van een lid.
     * 
     * @param lidID Het ID van het lid.
     * @return true als het betalen gelukt is, anders false
     */
    public boolean betaalBoetesLid(int lidID)
    {
        // Controleert geldigheid parameters
        if(checkLidID(lidID) && !leden.get(lidID).isGeroyeerd())
        {
            // Doorloop de boetes.
            for(int i = (boetes.size() - 1); i >= 0; i--)
            {
                // Controleert de boete in de juiste ArrayList.
                switch(boetes.get(i).getBoeteKlasseType())
                {
                    case RESERVERING:
                    {
                        Reservering reservering = reserveringen.get(boetes.get(i).getItemID());
                        // Controleert of een boete van het lid is en openstaat en
                        // of het betalen niet gelukt is.
                        if(reservering.getLidID() == lidID && !boetes.get(i).getBetaald() &&
                            !boetes.get(i).setBetaald())
                        {
                            return false;
                        }
                        break;
                    }
                    case UITLENING:
                    {
                        Uitlening uitlening = uitleningen.get(boetes.get(i).getItemID());
                        // Controleert of een boete van het lid is en openstaat en
                        // of het betalen niet gelukt is.
                        if(uitlening.getLidID() == lidID && !boetes.get(i).getBetaald() &&
                            !boetes.get(i).setBetaald())
                        {
                            return false;
                        }
                        break;
                    }
                }
            }

            // Doorloop de reserveringen.
            for(int i = (reserveringen.size() - 1); i >= 0; i--)
            {
                Reservering reservering = reserveringen.get(i);
                // Controleert of het lid een reservering heeft die niet betaald is en
                // of het betalen niet gelukt is.
                if(reservering.getLidID() == lidID && !reservering.getReserveringskostenBetaald() &&
                    !reservering.setReserveringskostenBetaald())
                {
                    return false;
                }
            }
            
            // Het betalen is gelukt.
            return true;
        }
        // Lid kan/mag niet betalen.
        return false;
    }
    
    /**
     * Berekend het verschuldigde bedrag van leden en
     * bepaald of ze een of meerdere waarschuwingbrieven moeten krijgen.
     * Elke rij in de ArrayList stelt een waarschuwingsbrief voor zodat
     * het makkelijk is welke waarschuwingsbrieven verstuurd moeten worden.
     * 
     * @return Een ArrayList met de leden die een waarschuwingsbrief moeten krijgen.
     */
    public ArrayList<int[]> verwerkVerschuldigdBedrag()
    {
        // Opbouw rijen van de ArrayList: lidID en de drempel waarde van de waarschuwingsbrief.
        ArrayList<int[]> waarschuwingsbrieven = new ArrayList<int[]>();
        for(Lid lid : leden)
        {
            // Controleer of lid eerste waarschuwingsbrief moet krijgen en probeer dan
            // eerste waarschuwingsbrief naar lid te versturen.
            if(!lid.isGeroyeerd() && getVerschuldigdBedragLid(lid.getID()) > DREMPEL_EERSTE_BRIEF &&
                !lid.getEersteBrief() && lid.setEersteBrief())
            {
                waarschuwingsbrieven.add(new int[] {lid.getID(), DREMPEL_EERSTE_BRIEF});
            }
            // Controleer of lid tweede waarschuwingsbrief moet krijgen en probeer dan
            // tweede waarschuwingsbrief naar lid te versturen.
            if(!lid.isGeroyeerd() && getVerschuldigdBedragLid(lid.getID()) > DREMPEL_TWEEDE_BRIEF &&
                lid.getTweedeBrief() == null && lid.setTweedeBrief())
            {
                waarschuwingsbrieven.add(new int[] {lid.getID(), DREMPEL_TWEEDE_BRIEF});
            }
        }
    
        return waarschuwingsbrieven;
    }
    
    /**
     * Haalt alle geldige artikelen op, voegt hier informatie
     * met betrekking tot het aantal keer dat een artikel is uitgeleend en
     * de totale uitgeleende tijd in dagen aan toe. En returned
     * het geheel.
     * De key van de LinkedHashMap is het id van het artikel.
     * De bijbehorende value is een int-array met het
     * aantal keer dat een artikel is uitgeleend en
     * de totale uitgeleende tijd in dagen.
     * 
     * @return Een LinkedHashMap met informatie over alle geldige artikelen.
     */
    public LinkedHashMap<Integer, int[]> getInfoOverArtikelen()
    {
        LinkedHashMap<Integer, int[]> infoOverArtikelen = new LinkedHashMap<Integer, int[]>();
        
        // Vul de LinkedHashMap met geldige artikelen
        for(Artikel artikel : artikelen)
        {
            if(checkArtikelID(artikel.getID()))
            {
                infoOverArtikelen.put(artikel.getID(), new int[] {0, 0});
            }
        }
        
        // Vul de LinkedHashMap met de informatie over de artikelen
        for(Uitlening uitlening : uitleningen)
        {
            int[] artikelRij = infoOverArtikelen.get(exemplaren.get(uitlening.getExemplaarID()).getArtikelID());
            // Ga voor elke uitlening na of deze teruggebracht is en of het bijbehorende artikel nog geldig is
            if(uitlening.getTerugbrengdatum() != null && artikelRij != null)
            {
                artikelRij[0] += 1; // aantal keer uitgeleend
                artikelRij[1] += SpecialDate.daysDifference(uitlening.getUitleendatum(), uitlening.getTerugbrengdatum()); // totale uitgeleende tijd in dagen
            }
        }
        
        return infoOverArtikelen;
    }
}