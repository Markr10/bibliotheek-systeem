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
     * The constructor is private because this is a static class.
     */
    private ImportData()
    {
    }

    /**
     * Import data from a CSV file and returns it as an ArrayList.
     * The CSV file must start with the column names.
     * The (column) values must be separated with a comma.
     * It throws an exception when the data could not be imported.
     *
     * @param csvFilePath The path to the CSV file.
     * @param columns The colum names of the CSV file. A column name must consist of one or
     * more characters.
     * @return Returns the import data from the CSV file.
     */
    public static ArrayList<String[]> run(String csvFilePath, String[] columnNames) throws Exception
    {
        String csvSplitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader(csvFilePath));

        // check correct start of the CSV file
        String line = br.readLine(); // throws exception when there is no line
        String[] firstSplittedLine = line.split(csvSplitBy, -1);
        if(columnNames.length != firstSplittedLine.length)
        {
                throw new IncorrectStartCsvFileException("The number of the columns names of the CSV file is not correct!");
        }
        for(int i = 0; i < columnNames.length; i++)
        {
            if(columnNames[i].isEmpty())
            {
                // column name is not correct
                throw new IncorrectStartCsvFileException("A column name must consist of one or more characters!");
            }
            if(!columnNames[i].equals(firstSplittedLine[i]))
            {
                // not correct start of the CSV file
                throw new IncorrectStartCsvFileException("The expected column name \"" + columnNames[i] + "\" " +
                    "is not equals to the founded column name \"" + firstSplittedLine[i] + "\"");
            }
        }

        // import the rows with the data
        ArrayList<String[]> importList = new ArrayList<String[]>();
        while((line = br.readLine()) != null)
        {
            // split the line into the different columns
            String[] splittedLine = line.split(csvSplitBy, -1);
            // check the number of columns
            if(splittedLine.length != columnNames.length)
            {
                throw new Exception("The number of the columns is not correct! " +
                    "Corresponding line in CSV file: \"" + line + "\"");
            }
            importList.add(splittedLine);
        }
        br.close();

        // the operation has completed successfully
        return importList;
    }
}
