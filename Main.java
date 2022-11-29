import java.io.*;
import java.util.*;

public class Main{

    public static void searchSlang(Hash<String, String> hash, Vector<String> history){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your slang word: ");
        String Slang = myObj.nextLine();
        history.add(Slang);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println(Slang + " meaning " + hash.getValue(Slang));
    }

    public static void searchDefinition(Hash<String, String> hash, Vector<String>text, Vector<Dictionary>D){

        Vector<String> list = new Vector<String>();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your word: ");
        String word = myObj.nextLine();
        
        for(int i = 0;i<text.size();i++){
            if(text.get(i).contains(word)){
                list.add(D.get(i).getSlang());
            }
        }

        System.out.println("All slang contain key word: ");
            for(int i = 0;i<list.size();i++){
                System.out.println(list.get(i));
        }
    }

    public static void showHistory(Vector<String>s){
        for(int i = 0;i<s.size();i++){
            System.out.println(s.get(i));
        }
    }

    public static void addMean(Hash<String, String> hash){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your slang word: ");
        String Slang = myObj.nextLine();

        if(hash.containsKey(Slang)){
            System.out.println("Slang word is exits :<");
            System.out.println("1. Do you want to Overwrite");
            System.out.println("2. Do you want to Duplicate");
            int userChoose = myObj.nextInt();
            if(userChoose == 1){
                System.out.println("Input your new defintion: ");
                String newMean = myObj.nextLine();
                hash.replaceKey(Slang, newMean);
            }
            else if(userChoose == 2){
                System.out.println("Input your second defintion: ");
                String newMean = myObj.nextLine();
                hash.duplicate(Slang, newMean);
            }
        }  
        else{
            System.out.println("Enter your mean ^^ : ");
            String newMean = myObj.nextLine();
            hash.put(Slang, newMean);
        }
    }

    public static void editSlang(Hash<String, String> hash){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input slang word to edit: ");
        String newSlang = myObj.nextLine();
        System.out.println("Input your new defintion: ");
        String newMean = myObj.nextLine();
        hash.replaceKey(newSlang, newMean);
    }

    public static void deleteSlang(Hash<String, String> hash){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input slang word to delete: ");
        String slang = myObj.nextLine();
        System.out.println("Do you really want to delete?(y/n)");
        String userChoose = myObj.nextLine();
        if(userChoose =="Y" || userChoose == "y"){
            hash.remove(slang);
        }
    }

    public static void restoreData(Hash<String, String> hash){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to restore original data ?(y/n)");
        String userChoose = myObj.nextLine();
        if(userChoose == "Y" || userChoose =="y"){

            hash.clear();
            Vector<Dictionary> Dics = new Vector<Dictionary>();
            GetData data = new GetData();
            Dics = data.GetAll();

            for(int i=0;i<Dics.size();i++){
                hash.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
                } 
            }
        else if(userChoose == "N" || userChoose =="n"){
            System.out.println("");
        }
    }

    public static void randomSlang(Hash<String, String> hash, Vector<Dictionary> D){
        Random rand = new Random();
        int n = rand.nextInt(7600);

        System.out.println("On this day slang word is:....");
        System.out.println(D.get(n).getSlang() + "---" +D.get(n).getMean());
    }

    public static void run(){
        Vector<Dictionary> Dics = new Vector<Dictionary>();

        GetData data = new GetData();
        Dics = data.GetAll();

        Hash<String, String> hash = new Hash<String,String>();
        Vector<String> text =  new Vector<String>();
        Vector<String> history =  new Vector<String>();
        for(int i=0;i<Dics.size();i++){
            hash.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
        } 

        for(int i = 0;i<Dics.size();i++){
            text.add(Dics.get(i).getMean().toString());
        }

        Scanner myObj = new Scanner(System.in);

        do{
            System.out.println("1. Seach Slang Word!");
            System.out.println("2. Search Definition!");
            System.out.println("3. See History!");
            System.out.println("4. Add New Slang!");
            System.out.println("5. Edit Slang!");
            System.out.println("6. Delete Slang!");
            System.out.println("7. Restore Original Data!");

            System.out.println("Input your choose: ");
            int choose = myObj.nextInt();

            if(choose == 1){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                searchSlang(hash, history);
            }
            else if (choose == 2){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                searchDefinition(hash, text,Dics);
            }
            else if(choose == 3){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                showHistory(history);
            }
            else if(choose == 4){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                addMean(hash);
            }
            else if(choose == 5){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                editSlang(hash);
            }
            else if(choose == 6){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                deleteSlang(hash);
            }
            else if(choose == 7){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                restoreData(hash);
            }
        }while(true);

    }

    public static void main(String [] args){
        run();
    }
}