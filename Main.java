import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main{
    public static String getKeyFromValue(Map<String, String>hm, String value) {
            for (String o : hm.keySet()) {
              if (hm.get(o).equals(value)) {
                return o;
              }
            }
            return null;
          }
    public static void searchSlang(Map<String, String> map, Vector<Dictionary> history){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your slang word: ");
        String Slang = myObj.nextLine();
        do{
            if(map.get(Slang)==null){
                System.out.println("Slang is not exits, pls enter again!");
                System.out.print("Enter your slang word: ");
                Slang = myObj.nextLine();
            }
        }while(map.get(Slang)==null);
        Dictionary h = new Dictionary();
        h.setSlang(Slang);
        h.setMean(map.get(Slang));
        history.add(h);
        System.out.println("-> " + "| "+ Slang + " | is " + map.get(Slang));
    }

    public static void searchDefinition(Map<String, String> map, Vector<Dictionary>D){

        Vector<String> list = new Vector<String>();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your word: ");
        String word = myObj.nextLine();
        
        for(int i=0;i<D.size();i++){
            if(D.get(i).getMean().toString().contains(word)){
                String s = getKeyFromValue(map,D.get(i).getMean());
                list.add(s);
            }
        }
        if(list.size()== 0){
            System.out.println("\t -> No keywords were found !!");
        }else{
        System.out.println("All slang contain key word: ");
            for(int i = 0;i<list.size();i++){
                System.out.println("\t -> " + list.get(i));
            }
        }
    }

    public static void showHistory(Vector<Dictionary>s){
        System.out.print("History: \n");
        for(int i = 0;i<s.size();i++){
            System.out.println(s.get(i).getSlang()+" -> " + s.get(i).getMean());
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
                newMean = oldMean +  "| " + newMean;
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
        String Slang = " ";
        do{
            if(getKeyFromValue(map,Slang)!=null){
            System.out.println("Slang is not exits, pls enter again!");
            System.out.print("Enter your slang word: ");
            Slang = myObj.nextLine();
            }
        }while(getKeyFromValue(map,Slang)!=null);
        System.out.println("Input your new defintion: ");
        String newMean = myObj.nextLine();
        map.replace(Slang, newMean);
        System.out.println("Edit success!");
    }

    public static void deleteSlang(Map<String, String> map){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input slang word to delete: ");
        String Slang = " ";
        do{
            if(map.get(Slang)==null){
                System.out.println("Slang is not exits, pls enter again!");
                System.out.print("Enter your slang word: ");
                Slang = myObj.nextLine();
            }
        }while(getKeyFromValue(map,Slang)!=null);
        System.out.println("Do you really want to delete?(0/1)");

        int userChoose = myObj.nextInt();

        if(userChoose == 1){
            map.remove(Slang);
            System.out.println("Successful delete!") ; 
            }
        else if (userChoose == 0){
             System.out.println("This word has not been deleted!");      
        }
    }

    public static void restoreData(Map<String, String> map, Vector<Dictionary> olDic){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to restore original data ?(0/1)");
        int userChoose = myObj.nextInt();
        if(userChoose == 1){
            GetData data = new GetData();
            olDic = data.GetAll();
            for(int i=0;i<olDic.size();i++){
                map.put(olDic.get(i).getSlang(), olDic.get(i).getMean());
            } 
            System.out.println("Restore original data success!");
        }
        else if(userChoose == 0){
            System.out.println("Restore original data failed!");
        }
    }

    public static void randomSlang(Map<String, String> map, Vector<Dictionary> D){
        Random rand = new Random();
        int n = rand.nextInt(7600);

        System.out.println("\t\tSlang for today is:..");
        System.out.println("\t  | " + D.get(n).getSlang() + " | it meaning: " +D.get(n).getMean());
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
        for(int i=0;i<ans.size();i++){
            System.out.println("\t" + id.get(i) + ". "+ ans.get(i));
        }

        Scanner myObj = new Scanner(System.in);
        System.out.print("\nChoose the answer: ");
        String userAns = myObj.nextLine();

        if(ans.get(id.indexOf(userAns.toUpperCase())).contains(map.get(s))){
            System.out.println("Well Done, it is correct answer ><");
        }
        else{
            System.out.println("Unlucky for you (ToT)");
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
        for(int i=0;i<ans.size();i++){
            System.out.println("\t" + id.get(i) + ". "+ ans.get(i));
        }

        Scanner myObj = new Scanner(System.in);
        System.out.print("\nChoose the answer: ");
        String userAns = myObj.nextLine();

        if(ans.get(id.indexOf(userAns.toUpperCase())).contains(getKeyFromValue(map,s))){
            System.out.println("Well Done, it is correct answer ><");
        }
        else{
            System.out.println("Unlucky for you (ToT)");
        }


    }

    public static void run(){
        Vector<Dictionary> Dics = new Vector<Dictionary>();

        GetData data = new GetData();
        Dics = data.GetAll();

        Map<String, String> map  = new HashMap<>();
        Vector<Dictionary> history =  new Vector<Dictionary>();
        for(int i=0;i<Dics.size();i++){
            map.put(Dics.get(i).getSlang(), Dics.get(i).getMean());
        } 

        Scanner myObj = new Scanner(System.in);

        do{ 
            randomSlang(map,Dics);
            System.out.println("\t-----------------------------------");
            System.out.println("\t|\t1. Seach Slang Word!      |\t");
            System.out.println("\t|\t2. Search Definition!     |\t");
            System.out.println("\t|\t3. See History!           |\t");
            System.out.println("\t|\t4. Add New Slang!         |\t");
            System.out.println("\t|\t5. Edit Slang!            |\t");
            System.out.println("\t|\t6. Delete Slang!          |\t");
            System.out.println("\t|\t7. Restore Original Data! |\t");
            System.out.println("\t|\t8. Guest Slang!           |\t");
            System.out.println("\t|\t9. Guest Mean!            |\t");
            System.out.println("\t|\t0. Exit!                  |\t");
            System.out.println("\t-----------------------------------\t\n");
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
                System.out.println("Press \"ENTER\" to continue...");
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
                map.clear();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                restoreData(map,Dics);
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
            else if(choose == 0){
                System.exit(0);
            }
        }while(true);

    }

    public static void main(String [] args){
        run();
    }
}