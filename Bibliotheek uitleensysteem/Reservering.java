
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Reservering
{
    private int reservering_id;
    private int lid_id;
    private int artikel_id;
    private int kosten; // centen omzetten naar euro's toevoegen aan klant kosten
    private int totaalKosten;
    private String reserverings_datum;
    private String status;

    /**
     * Constructor for objects of class Reservering
     */
    public Reservering(int reservering_id, int lid_id, int artikel_id, String reserverings_datum)
    {
        this.reservering_id = reservering_id;
        this.lid_id = lid_id;
        this.artikel_id = artikel_id;
        this.reserverings_datum = reserverings_datum;
        this.status = "open";
    }

    public int getReserveringID()
    {
        return reservering_id;
    }
    public int getArtikelID()
    {
        return artikel_id;
    }
    
    public int getLidID()
    {
        return lid_id;
    }
//     public String getName()
//     {
//         return name;
//     }
    public String getDatum()
    {
        return reserverings_datum;
    }
    public void setDatum(String reserverings_datum)
    {
        this.reserverings_datum = reserverings_datum;
    }

    public int nieuweReservering() 
    {
        int kosten = 30; // in centen
        berekenTotaalKosten();
        return kosten;
    }

    public void berekenTotaalKosten()
    {
        totaalKosten += kosten;
    }

    public int getTotaalKosten()
    {
        return totaalKosten;
    }
}
