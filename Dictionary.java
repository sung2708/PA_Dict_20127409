import java.util.*;

public class Dictionary{
    private String _Slang;
    private String _Mean;

    public String getSlang(){return this._Slang;}
    public String getMean(){return this._Mean;}
    
    public void setSlang(String Slang){this._Slang = Slang;}
    public void setMean(String Mean){this._Mean = Mean;}

    public Dictionary createSlang(Dictionary d, String []tmp){
        d.setSlang(tmp[0]);
        d.setMean(tmp[1]);
        return d;
    }
}