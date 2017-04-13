/* https://code.google.com/codejam/contest/351101/dashboard*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.*;


public class StoreCredit {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      HashSet<Integer> set = new HashSet<>();
      HashMap<Integer, Integer> map = new HashMap<>();
      int n = sc.nextInt();
      Integer m;
      for(int i = 0; i < n; i++){
         Integer cost = sc.nextInt();
         Integer items = sc.nextInt();
         String empty = sc.nextLine();
         empty = sc.nextLine();
         Scanner inner = new Scanner(empty);
         int index = 1;
         for(int j = 0; j < items; j++){
            Integer current = inner.nextInt();
            Integer otherNum = cost - current;
            if(!set.contains(otherNum)){
               set.add(current);
               map.put(current, index);
            }
            else{
               otherNum = map.get(otherNum);
               System.out.println("Case #" + (i + 1) + ": " + otherNum + " " + index);
               map = new HashMap<>();
               set = new HashSet<>();
               break;
            }
            index++;
         }
      
      
      }
   }
}
