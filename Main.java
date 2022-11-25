import java.util.*;

public class Main{
    public static void main(String [] args){
        Vector<Dictionary> Dics = new Vector<Dictionary>();
        GetData data = new GetData();
        Dics = data.GetAll();
        Hash<String, String> hash = new Hash<String, String>();

        for(int i=0;i<Dics.size();i++){
            hash.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
        }

        System.out.println(hash.get("ZOMB"));

    }
}