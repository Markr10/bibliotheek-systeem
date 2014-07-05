import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * A static class for importing data from a CSV file.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */

public class ImportData 
{
    /**
     * ImportData constructor
     */
    public ImportData() {}

    /**
     * Import data from a CSV file and returns it as an ArrayList.
     * The CSV file must start with the column names.
     * The values must be separated with a comma.
     *
     * @param csvFilePath The path to the CSV file.
     * @param columns The colum name of the CSV file.
     * @return Returns the import data from the CSV file. It returns null when the data could not be imported.
     */
    public static ArrayList<String[]> run(String csvFilePath, String[] columnNames) 
    {
        String csvSplitBy = ",";
        
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath));

            // check correct start of the CSV file
            String line = br.readLine(); // throws exception when there is no line
            String[] firstSplittedLine = line.split(csvSplitBy);
            for(int i = 0; i < firstSplittedLine.length; i++)
            {
                if(firstSplittedLine[i] != columnNames[i])
                {
                    // not correct start of the CSV file
                    throw new Exception("Start of CSV file is not correct!");
                }
            }

            // import the rows with the data
            ArrayList<String[]> importList = new ArrayList<String[]>();
            while((line = br.readLine()) != null)
            {
                // split the line into the different columns
                String[] splittedLine = line.split(csvSplitBy);
                // check the number of columns
                if(splittedLine.length != columnNames.length)
                {
                    throw new Exception("The number of the columns is not correct!\n" +
                        "Corresponding line in CSV file: " + line);
                }
                importList.add(splittedLine);
            }
            br.close();

            // the operation has completed successfully
            return importList;
        }
        catch (Exception e) 
        {
            e.printStackTrace();

            // the operation could not be successfully completed because there was an exception
            return null;
        }
    }
}
