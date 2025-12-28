import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ticketCategories {
    public static void main(String[] args){

        Scanner myScanner = new Scanner(System.in);

        List<String> arrayList = new ArrayList<>();
        Set<String> uniqueCategories = new HashSet<>();
        Map<String, Integer> catCount = new HashMap<>();


        for(int i=0; i<10; i++){
            System.out.print("Enter your preference : ");
            String cur = myScanner.nextLine();

            arrayList.add(cur);
            uniqueCategories.add(cur);
            catCount.put(cur, catCount.getOrDefault(cur, 0) + 1);
            // Print Collections
        }
        
        System.out.println("\n Array List : ");
        System.out.println(arrayList);

        System.out.println("\n HashSet : ");
        System.out.println(uniqueCategories);

        System.out.println("\n HashMap : ");
        System.out.println(catCount);
        

        myScanner.close();
    }    
}
