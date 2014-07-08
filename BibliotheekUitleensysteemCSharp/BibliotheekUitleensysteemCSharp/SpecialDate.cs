using System;
using java.text.SimpleDateFormat;
using java.util;
using java.text.ParseException;
using java.util.Calendar;

/**
 * A static class that can do calculations with dates.
 * 
 * @author      Mark, Wybren en Danny
 * @custom.date April 7 2014
 * @version     3.00
 */
public class SpecialDate
{
    private readonly static SimpleDateFormat SDF;
    
    /**
     * SpecialDate constructor.
     * The constructor is private because this is a static class.
     */
    static SpecialDate()
    {
        SDF = new SimpleDateFormat("ddMMyyyy");
        SDF.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        SDF.setLenient(false);
    }
    
    /**
     * Return the date of today.
     *
     * @return The date of today in the format "ddMMyyyy".
     */
    public static String getDateToday()
    {
        // timestamp as String
        return SDF.format(Calendar.getInstance().getTime());
    }
    
    /**
     * Checks if a String is a valid date in the format "ddMMyyyy".
     * Furthermore it checks that the date is not in the future.
     * 
     * @param date The date that must be checked.
     * @return true if the String is a valid date, false otherwise
     */
    public static Boolean checkDate(String date)
    {
        if(daysDifference(date) >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Checks if a String is a valid date in the format "ddMMyyyy".
     * Furthermore it checks that the date is today or in the future.
     * 
     * @param date The date that must be checked.
     * @return true if the String is a valid date, false otherwise
     */
    public static Boolean checkDateNowAndFuture(String date)
    {
        if(daysDifference(getDateToday(), date) >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Checks if a String is a valid date in the format "ddMMyyyy".
     * 
     * @param date The date that must be checked.
     * @return true if the String is a valid date in the format "ddMMyyyy", false otherwise
     */
    public static Boolean checkFormatDate(String date)
    {
        try
        {
            SDF.parse(date);
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }
    }
    
    /**
     * Adds a number of days to a date and returns it in the format "ddMMyyyy".
     * 
     * @param date A date in the format "ddMMyyyy".
     * @param days The number of days that must be added to the date.
     * @return The date in the format "ddMMyyyy".
     */
    public static String addDays(String date, int days)
    {
        Calendar cal = Calendar.getInstance();
        try
        {
            cal.setTime(SDF.parse(date));
            cal.add(Calendar.DAY_OF_MONTH, days);
            return SDF.format(cal.getTime());
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * Calculates the difference (years) between the start date and today.
     * 
     * @param startDate A start date in the format "ddMMyyyy".
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
     * Ceil the years.
     * 
     * @param startDate A start date in the format "ddMMyyyy".
     * @return The difference in years between the start date and today.
     */
    public static int roundedYearsDifference(String startDate)
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
            else if(years > 0 && calToday.get(Calendar.MONTH) > calStart.get(Calendar.MONTH) &&
                calToday.get(Calendar.DAY_OF_MONTH) < calStart.get(Calendar.DAY_OF_MONTH))
            {
                years++;
            }
            else if(years > 0 && calToday.get(Calendar.MONTH) == calStart.get(Calendar.MONTH) &&
                calToday.get(Calendar.DAY_OF_MONTH) > calStart.get(Calendar.DAY_OF_MONTH))
            {
                years++;
            }
            return years;
        }
        catch (ParseException e)
        {
            return -1;
        }
    }
    
    /**
     * Calculates the difference (days) between the start date and today.
     * 
     * @param startDate A start date in the format "ddMMyyyy".
     * @return The difference in days between the start date and today.
     */
    public static int daysDifference(String startDate)
    {
        Calendar calStart = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();
        
        try
        {
            calStart.setTime(SDF.parse(startDate));
            
            // Convert to milliseconds
            long millisecStart = calStart.getTimeInMillis();
            long millisecEnd = calToday.getTimeInMillis();

            // Calculate the difference
            long difference = millisecEnd - millisecStart;
            
            // Convert difference to days
            return (int)(difference / (24 * 60 * 60 * 1000));
        }
        catch (ParseException e)
        {
            return -1;
        }
    }
    
    /**
     * Calculates the difference (days) between the start date and the end date.
     * 
     * @param startDate A start date in the format "ddMMyyyy".
     * @param endDate   A end date in the format "ddMMyyyy".
     * @return The difference in days between the start date and the end date.
     */
    public static int daysDifference(String startDate, String endDate)
    {
        Calendar calStart = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        
        try
        {
            calStart.setTime(SDF.parse(startDate));
            calEnd.setTime(SDF.parse(endDate));
            Calendar calToday = Calendar.getInstance();
            // Convert to milliseconds
            long millisecStart = calStart.getTimeInMillis();
            long millisecEnd = calEnd.getTimeInMillis();
            long millisecToday = Calendar.getInstance().getTimeInMillis();

            // Calculate the difference
            long difference = millisecEnd - millisecStart;
            
            // Convert difference to days
            return (int)(difference / (24 * 60 * 60 * 1000));
        }
        catch (ParseException e)
        {
            return -1;
        }
    }
    
    /**
     * Calculates a date to milliseconds.
     * 
     * @param startDate A date in the format "ddMMyyyy".
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
