import java.util.*;
/**
 * Write a description of class Reserveringen here.
 * 
 * Wybren, Danny en Mark
 * 7 April 2014
 * 
 */
public class Bibliotheek
{
    private ArrayList<Lid> customers;
    private HashMap<Integer, Lid> ledenMap;
    public Lid getLid;
    // Reserveringen
    private ArrayList<Reservering> reserveringen;
    private HashMap<Integer, Reservering> reserveringMap;
    public Reservering getReservering;

    // Uitlenen
    private ArrayList<Lenen> uitleningen;
    private HashMap<Integer, Lenen> uitleenMap;
    public Lenen getUitlening;

    private ArrayList<Artikel> artikelen;
    private HashMap<Integer, Artikel> artikelMap;
    public Artikel getArtikel;

    private String releaseDatum;
    private String titel;
    private String name;
    private int aantal_voorraad;
    private int uitgeleend_count;

    private int lid_n = 0;
    private int artikel_n = 0;
    private int leen_n = 0;
    private int reservering_n = 0;
    private String type;

    /**
     * Constructor for objects of class Bibliotheek
     */
    public Bibliotheek()
    {
        customers = new ArrayList<Lid>();
        artikelen = new ArrayList<Artikel>();
        reserveringen = new ArrayList<Reservering>();
        uitleenMap = new HashMap<Integer, Lenen>();
        artikelMap = new HashMap<Integer, Artikel>();
        reserveringMap = new HashMap<Integer, Reservering>();
        ledenMap = new HashMap<Integer, Lid>();
    }

    // Nieuwe reservering
    public void addReservering(int reservering_id, int lid_id, int artikel_id, String reserverings_datum)
    {
        getReservering = (new Reservering(reserveringen.size(), lid_id, artikel_id, reserverings_datum));
        reserveringMap.put(reservering_n, getReservering);
        reservering_n++;
        System.out.println(reservering_n);
    }

    // Nieuwe uitlening
    public void artikelUitlenen(int uitleen_id, int lid_id, int artikel_id, String uitleenDatum) 
    {
        SpecialDate dateToday = new SpecialDate();
        String timeStamp = dateToday.getDateToday();
        Set<Integer> keys = artikelMap.keySet();

        for(int key : keys)
        {
            Artikel a = artikelMap.get(key);
            Lid hashLid = ledenMap.get(key);
            if(hashLid.incrementArtikelenLeenCount() == true)
            {
                if(a.getID() == artikel_id) 
                {
                    a.setUitgeleend();
                    getUitlening = new Lenen(uitleningen.size(), lid_id, artikel_id, dateToday.getDateToday());
                    uitleenMap.put(leen_n, getUitlening);
                    leen_n++;
                    System.out.println("Artikel uitgeleend");
                }
            }
            else
            {
                System.out.println(hashLid.getName() + " heeft al " + hashLid.getArtikelenLeenCount() + " artikelen te leen");
            }
        }
    }
    
    public void artikelInleveren()
    {
        SpecialDate dateToday = new SpecialDate();
        String timeStamp = dateToday.getDateToday();
        Set<Integer> keys = artikelMap.keySet();

        for(int key : keys)
        {
            Artikel a = artikelMap.get(key);
            Lid hashLid = ledenMap.get(key);
            if(hashLid.incrementArtikelenLeenCount() == true)
            {
                if(a.getID() == artikel_id) 
                {
                    a.setUitgeleend();
                    getUitlening = new Lenen(uitleningen.size(), lid_id, artikel_id, dateToday.getDateToday());
                    uitleenMap.put(leen_n, getUitlening);
                    leen_n++;
                    System.out.println("Artikel uitgeleend");
                }
            }
        }
    }

    // Add lid    
    public void addLid(String name)
    {
        getLid = (new Lid(name, customers.size()));
        ledenMap.put(lid_n, getLid);
        lid_n++;
        System.out.println(lid_n);

    }

    // Remove lid
    public void removeLid(Lid lid)
    {
        customers.remove(lid);
    }

    // Video
    public void addVideoband(String titel, String type, String releaseDatum, int aantal_voorraad, String genre)
    {
        getArtikel = (new Videoband(artikel_n, titel, type, releaseDatum, genre, aantal_voorraad, uitgeleend_count));
        artikelMap.put(artikel_n, getArtikel);
        artikel_n++;
        System.out.println(artikel_n);
    }
    // Boek
    public void addBoek(String titel, String type, String releaseDatum, String genre, int isbn, int pages)
    {
        getArtikel = (new Boek(artikel_n, titel, type, releaseDatum, genre, aantal_voorraad, uitgeleend_count, isbn, pages));
        artikelMap.put(artikel_n, getArtikel);
        artikel_n++;
        System.out.println(artikel_n);
    }
    // CD
    public void addCD(String titel, String type, String genre, String releaseDatum, String artiest)
    {
        getArtikel = (new CD(artikel_n, titel, type, releaseDatum, genre, aantal_voorraad, uitgeleend_count, artiest));
        artikelMap.put(artikel_n, getArtikel);
        artikel_n++;
        System.out.println(artikel_n);
    }

    public void showCustomers()
    {
        System.out.println("-------------Leden------------");
        Set<Integer> keys = ledenMap.keySet();
        for(int key : keys)
        {
            Lid l = ledenMap.get(key);

            System.out.println(l.getName());

        }
        System.out.println("------------------------------");
    }

    public void totaalKosten()
    {

    }

    public void showArtikelen()
    {
        System.out.println("---------Artikelen----------");
        Set<Integer> keys = artikelMap.keySet();

        for(int key : keys)
        {
            Artikel a = artikelMap.get(key);
            if(a.getType().equals("book")) 
            {
                //                 System.out.println("book!");
                System.out.println("# " + a.getID() + " Type: " + a.getType() + " Naam: " + a.getTitel() + " Releasedatum: " + a.getReleaseDate());
            }
            if(a.getType().equals("cd")) 
            {
                //                 System.out.println("cd!");
                System.out.println("# " + a.getID() + " Type: " + a.getType() + " Naam: " + a.getTitel() + " Releasedatum: " + a.getReleaseDate());
            }
            if(a.getType().equals("video")) 
            {
                //                 System.out.println("video!");
                System.out.println("# " + a.getID() + " Type: " + a.getType() + " Naam: " + a.getTitel() + " Releasedatum: " + a.getReleaseDate());
            }

        }
        System.out.println("------------------------------");
    }

    public void showReserveringen() 
    {
        System.out.println("---------Reserveringen----------");
        Set<Integer> keys = reserveringMap.keySet();
        for(int key : keys) 
        {

            Reservering x = reserveringMap.get(key);
            Set<Integer> articleKeys = artikelMap.keySet();
            for(int articleKey : articleKeys)
            {
                Artikel r = artikelMap.get(key);
                if(x.getArtikelID() == r.getID())
                {
                    System.out.println(r.getTitel());

                    //                     System.out.println(r.getReleaseDate());
                }
            }
            Lid l = ledenMap.get(key);
            Set<Integer> ledenKeys = ledenMap.keySet();
            for(int ledenKey : ledenKeys)
            {
                if(x.getLidID() == l.getID())
                {
                    System.out.println(l.getName());
                }
            }

            //int id =reservering.getArtikelID()
            //System.out.println(reservering.getArtikelID());
            //System.out.println("Titel: " + artikelen.getID().getName());            
            //System.out.println("Datum gereserveerd: " + reservering.getDatum());
        }
        System.out.println("------------------------------");
    }
}
