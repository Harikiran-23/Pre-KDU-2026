import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class popularMerchandise{
    public static void main(String[] args){
        
        Map<String, Integer> itemCount = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("items.csv"))){
            String line = br.readLine();

            if(line!= null){
                String[] items = line.split(",");

                for(String item: items){
                    itemCount.put(item, itemCount.getOrDefault(item, 0)+1);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        List<Entry<String, Integer>> sortList = new ArrayList<>(itemCount.entrySet());
        sortList.sort((a,b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("\nTop 3 : ");
        for(int i=0; i<3; i++){
            Entry<String, Integer> entry = sortList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey());
        }
    }
}
