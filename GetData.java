import java.util.*;
import java.io.*;

public class GetData{
    public Vector<Dictionary> GetAll(){
        BufferedReader fileIn = null;
        String delimiter = "`";
        Vector<Dictionary> Dic = new Vector<Dictionary>();
        try{

            fileIn = new BufferedReader(new FileReader("slang.txt"));
            String currentLine = "";
            String [] temp;
            currentLine = fileIn.readLine();

            while ((currentLine = fileIn.readLine()) != null) {
                Dictionary currentSlang = new Dictionary();
                temp = currentLine.split(delimiter);
                currentSlang.createSlang(currentSlang,temp);
                Dic.add(currentSlang);
            }
        }
        catch (IOException e) {

            e.printStackTrace();

        }
        return Dic;
    }
}