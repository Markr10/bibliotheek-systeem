import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class ImportLeden 
{
 
  public static void main(String[] args) 
  {
 
    ImportLeden obj = new ImportLeden();
    obj.run();
 
  }
 
  public void run() 
  {
    String csvFile = "C:/Users/Danny/Desktop/Leden.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
 
    try 
    {
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) 
        {
            // use comma as separator
            String[] lid = line.split(cvsSplitBy);
 
            System.out.println("Lid [Voornaam= " + lid[1] + " , Achternaam= " + lid[2] + "]");
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
 
}