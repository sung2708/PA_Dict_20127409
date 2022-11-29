import java.io.*;
import java.util.*;

public class Main{

    public void showHistory(Vector<String>s){
        for(int i = 0;i<s.size();i++){
            System.out.println(s.get(i));
        }
    }

    public addMean(Hash<String, String> hash){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your slang word ^^ : ")
        String newSlang = myObj.nextLine();

        if(hash.containsKey(newSlang)){
            System.out.println("Slang word is exits :<")
            System.out.println("1. Do you want to Overwrite");
            System.out.println("2. Do you want to Duplicate");
            int userChoosee = myObj.nextInt();
            if(userChoosee == 1){
                System.out.println("Input your new slang: ");
                String newSlang = myObj.nextLine();
                System.out.println("Input your new defintion: ");
                String newMean = myObj.nextLine();
                hash.replaceKey(newSlang, newMean);
            }
            else if(userChoosee == 2){
                System.out.println("Input your second defintion: ");
                String newMean = myObj.nextLine();
                hash.duplicate(newMean)
            }
        }  
        else{
            System.out.println("Enter your mean ^^ : ")
            String newMean = myObj.nextLine();
            hash.put(newSlang, newMean);
        }
    }

public editSlang(Hash<String, String> hash){
    Scanner myObj = new Scanner(System.in);
    System.out.println("Input slang word to edit: ");
    String newSlang = myObj.nextLine();
    System.out.println("Input your new defintion: ");
    String newMean = myObj.nextLine();
    hash.replaceKey(newSlang, newMean);
}

    public static void main(String [] args){
        
    }
}