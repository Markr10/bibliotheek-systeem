import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportArtikelen 
{

    public static void main(String[] args) 
    {

        ImportArtikelen obj = new ImportArtikelen();
        obj.run("C:/Users/Danny/Desktop/Leden.csv");

    }

    public void run(String path) 
    {
        String csvFile = path; // "C:/Users/Danny/Desktop/Leden.csv"
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String titel, type, releasedatum;

        try 
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] add = line.split(cvsSplitBy);
                
//                 if(add[0] == "video") 
//                 {
//                     System.out.println("Video [Titel= " + add[1] + " , Achternaam= " + add[2] + "]");
//                     addVideoband(titel, type);
//                 }
//                 if(add[0] == "boek") 
//                 {
//                     System.out.println("Boek [Titel= " + add[1] + " , Achternaam= " + add[2] + "]");
//                     addBoek(titel, type);
//                 }
//                 if(add[0] == "cd") 
//                 {
//                     System.out.println("CD [Titel= " + add[1] + " , Achternaam= " + add[2] + "]");
//                     addCd(titel, type, releasedatum);
//                 }
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