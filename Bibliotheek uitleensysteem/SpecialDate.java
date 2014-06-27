import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.*;

/**
 * A static class that can do calculations with dates.
 * 
 * @author                             Mark Roelans
 * @custom.date                        November 12 2013
 * @version                            1.00
 */
public class SpecialDate
{
    // Timestamp als String
    String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
    
    private final static SimpleDateFormat SDF = new SimpleDateFormat("ddMMyyyy");
    
    /**
     * Constructor SpecialDate.
     */
    public SpecialDate()
    {
        
    }
    
    public String getDateToday() {
        return timeStamp;
    }
    
    /**
     * Calculates the difference (years) between the start date and today.
     * 
     * @return The difference in years between the start date and today.
     */
    public static int yearsDifference(String startDate)
    {
        Calendar calStart = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();
        
        try
        {
            calStart.setTime(SDF.parse(startDate));
            int years = calToday.get(Calendar.YEAR) - calStart.get(Calendar.YEAR);
            if(calToday.get(Calendar.MONTH) < calStart.get(Calendar.MONTH))
            {
                years--;
            }
            else if(calToday.get(Calendar.MONTH) == calStart.get(Calendar.MONTH) &&
                calToday.get(Calendar.DAY_OF_MONTH) < calStart.get(Calendar.DAY_OF_MONTH))
            {
                years--;
            }
            return years;
        }
        catch (ParseException e)
        {
            return -1;
        }
    }
    
    /**
     * Calculates the difference (years) between the start date and today.
     * 
     * @return The difference in years between the start date and today.
     */
    public static int daysDifference(String startDate)
    {
        Calendar calStart = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();
        
        int aantalDagen = 0;
        
        try
        {
            calStart.setTime(SDF.parse(startDate));
            // Omzetten naar miliseconden
            long millisecStart = calStart.getTimeInMillis();
            long millisecEind = calToday.getTimeInMillis();
        
            //Omrekenen naar milisec
            long difference = millisecEind - millisecStart;
            
            aantalDagen += difference / (24 * 60 * 60 * 1000);
        
     
            return aantalDagen;
        }
        catch (ParseException e)
        {
            return -1;
        }
    }
    
    /**
     * Calculates a date to milliseconds.
     * 
     * @return The date in milliseconds.
     */
    public static long dateToMilliseconds(String date)
    {
        Calendar cal = Calendar.getInstance();
        try
        {
            cal.setTime(SDF.parse(date));
            return cal.getTimeInMillis();
        }
        catch (ParseException e)
        {
            return -1;
        }
    }
}
