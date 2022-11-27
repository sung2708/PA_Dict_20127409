import java.util.*;

public class Dictionary{
    private String _Slang;
    private Vector<String> _Mean = new Vector<String>();

    public String getSlang(){return this._Slang;}
    public Vector<String> getMean(){return this._Mean;}

    public void setSlang(String Slang){this._Slang = Slang;}
    public void setMean(Vector<String> Mean){this._Mean = Mean;}

    public Dictionary createSlang(Dictionary d, String []tmp){
        Vector<String>mean = new Vector<String>();
        String str = tmp[1];
        str = str.replaceAll("\\s+","");
        String[] split = str.trim().split("[|]");
        d.setSlang(tmp[0]);
        for(String s:split){
            mean.add(s);
        }
        d.setMean(mean);
        return d;
    }
}