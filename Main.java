import java.io.*;
import java.util.*;

public class Main{
    public static String getKeyFromValue(Map<String, String>hm, String value) {
            for (String o : hm.keySet()) {
              if (hm.get(o).equals(value)) {
                return o;
              }
            }
            return null;
          }
    public static void searchSlang(Map<String, String> map, Vector<String> history){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your slang word: ");
        String Slang = myObj.nextLine();
        history.add(Slang);
        System.out.println(Slang + " meaning " + map.get(Slang));
    }

    public static void searchDefinition(Map<String, String> map, Vector<Dictionary>D){

        Vector<String> list = new Vector<String>();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your word: ");
        String word = myObj.nextLine();
        
        for(int i=0;i<D.size();i++){
            if(D.get(i).getMean().toString().contains(word)){
                String s = map.get(D.get(i).getMean());
                list.add(s);
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

    public static void addMean(Map<String, String> map){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your slang word: ");
        String Slang = myObj.nextLine();

        if(map.containsKey(Slang)){
            System.out.println("Slang word is exits <:");
            System.out.println("1. Do you want to Overwrite");
            System.out.println("2. Do you want to Duplicate");
            int userChoose = myObj.nextInt();
            if(userChoose == 1){
                System.out.println("Input your new defintion: ");
                String n = myObj.nextLine();
                String newMean = myObj.nextLine();
                map.replace(Slang, newMean);
            }
            else if(userChoose == 2){
                System.out.println("Input your second defintion: ");
                String n = myObj.nextLine();
                String newMean = myObj.nextLine();
                String oldMean = map.get(Slang);
                newMean = oldMean +  " |" + newMean;
                map.replace(Slang, newMean);
            }
        }  
        else{
            System.out.println("Enter your mean ^^ : ");
            String newMean = myObj.nextLine();
            map.put(Slang, newMean);
        }
    }

    public static void editSlang(Map<String, String> map){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input slang word to edit: ");
        String Slang = myObj.nextLine();
        System.out.println("Input your new defintion: ");
        String newMean = myObj.nextLine();
        map.replace(Slang, newMean);
    }

    public static void deleteSlang(Map<String, String> map){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input slang word to delete: ");
        String slang = myObj.nextLine();
        System.out.println("Do you really want to delete?(y/n)");
        String userChoose = myObj.nextLine();
        if(userChoose =="Y" || userChoose == "y"){
            String removeValue = (String)map.remove(slang);
        }
    }

    public static void restoreData(Map<String, String> map){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to restore original data ?(y/n)");
        String userChoose = myObj.nextLine();
        if(userChoose == "Y" || userChoose =="y"){

            map.clear();
            Vector<Dictionary> Dics = new Vector<Dictionary>();
            GetData data = new GetData();
            Dics = data.GetAll();

            for(int i=0;i<Dics.size();i++){
                map.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
                } 
            }
        else if(userChoose == "N" || userChoose =="n"){
            System.out.println("");
        }
    }

    public static void randomSlang(Map<String, String> map, Vector<Dictionary> D){
        Random rand = new Random();
        int n = rand.nextInt(7600);

        System.out.println("On this day slang word is:....");
        System.out.println(D.get(n).getSlang() + "  " +D.get(n).getMean() +"\n\n");
    }

    private static void GuestSlang(Map<String, String> map,Vector<Dictionary>D){
        Random rand = new Random();
        int n = rand.nextInt(3);

        int question = rand.nextInt(7600);
        String s = D.get(question).getSlang();
        System.out.println(s + " mean: ");

        Vector<String> id = new Vector<String>();

        id.add("A");
        id.add("B");
        id.add("C");
        id.add("D");
    
        Vector<String>ans = new Vector<String>();
        ans.add(D.get(question).getMean());
        ans.add(D.get(question+2).getMean());
        ans.add(D.get(question+4).getMean());
        ans.add(D.get(question+6).getMean());

        Collections.sort(ans);
        System.out.println("Choose the answer: ");
        for(int i=0;i<ans.size();i++){
            System.out.println("\t" + id.get(i) + ". "+ ans.get(i));
        }

        Scanner myObj = new Scanner(System.in);
        String userAns = myObj.nextLine();

        if(ans.get(id.indexOf(userAns.toUpperCase())).contains(map.get(s))){
            System.out.println("Well Done, it is correct answer ><");
        }
        else{
            System.out.println("Unlucky for you (⋟﹏⋞)");
        }
    }

    private static void GuestMean(Map<String, String> map,Vector<Dictionary>D){
        Random rand = new Random();
        int n = rand.nextInt(3);

        int question = rand.nextInt(7600);
        String s = D.get(question).getMean();
        System.out.println(s + " is: ");

        Vector<String> id = new Vector<String>();

        id.add("A");
        id.add("B");
        id.add("C");
        id.add("D");
    
        Vector<String>ans = new Vector<String>();
        ans.add(D.get(question).getSlang());
        ans.add(D.get(question+2).getSlang());
        ans.add(D.get(question+4).getSlang());
        ans.add(D.get(question+6).getSlang());

        Collections.sort(ans);
        System.out.println("Choose the answer: ");
        for(int i=0;i<ans.size();i++){
            System.out.println("\t" + id.get(i) + ". "+ ans.get(i));
        }

        Scanner myObj = new Scanner(System.in);
        String userAns = myObj.nextLine();

        if(ans.get(id.indexOf(userAns.toUpperCase())).contains(getKeyFromValue(map,s))){
            System.out.println("Well Done, it is correct answer ><");
        }
        else{
            System.out.println("Unlucky for you (⋟﹏⋞)");
        }


    }

    public static void run(){
        Vector<Dictionary> Dics = new Vector<Dictionary>();

        GetData data = new GetData();
        Dics = data.GetAll();

        Map<String, String> map  = new HashMap<>();
        Vector<String> history =  new Vector<String>();
        for(int i=0;i<Dics.size();i++){
            map.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
        } 

        Scanner myObj = new Scanner(System.in);

        randomSlang(map,Dics);

        do{
            System.out.println("1. Seach Slang Word!");
            System.out.println("2. Search Definition!");
            System.out.println("3. See History!");
            System.out.println("4. Add New Slang!");
            System.out.println("5. Edit Slang!");
            System.out.println("6. Delete Slang!");
            System.out.println("7. Restore Original Data!");
            System.out.println("8. Guest Slang!");
            System.out.println("9. Guest Mean!");

            System.out.print("Input your choose: ");
            int choose = myObj.nextInt();

            if(choose == 1){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                searchSlang(map, history);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if (choose == 2){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                searchDefinition(map, Dics);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 3){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                showHistory(history);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 4){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                addMean(map);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 5){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                editSlang(map);
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 6){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                deleteSlang(map);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 7){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                restoreData(map);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 8){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                GuestSlang(map,Dics);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            else if(choose == 9){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                GuestMean(map,Dics);
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        }while(true);

    }

    public static void main(String [] args){
        run();
    }
}