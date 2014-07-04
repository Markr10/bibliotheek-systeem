import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportLeden 
{

    public static void main(String[] args) 
    {
        ImportLeden obj = new ImportLeden();
        obj.run("C:/Users/Danny/Desktop/Leden.csv");
    }

    public String run(String path) 
    {
        String csvFile = path; // "C:/Users/Danny/Desktop/Leden.csv"
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String titel, type, releasedatum;
//         ArrayList temp = new ArrayList();
        ImportValues values = new ImportValues();
        try 
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] add = line.split(cvsSplitBy);
                values.put(br);
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {   
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
        System.out.println("Done");
    }
    return values;
}