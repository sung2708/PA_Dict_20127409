import java.util.*;

public class Main{
    public static void main(String [] args){
        Vector<Dictionary> Dics = new Vector<Dictionary>();

        GetData data = new GetData();
        Dics = data.GetAll();

        Hash<String, String> hash = new Hash<String,String>();
        Vector<String> text =  new Vector<String>();

        for(int i=0;i<Dics.size();i++){
            hash.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
        } 

        for(int i=0;i<Dics.size();i++){
            if(Dics.get(i).getMean().contains("ry")){
               text.add(hash.getKeys(Dics.get(i).getSlang(),Dics.get(i).getMean()));
            }
        } 

        for(int i=0;i<text.size();i++){
            System.out.println(text.get(i));
        }
        
    }
}