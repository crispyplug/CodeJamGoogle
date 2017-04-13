/* https://code.google.com/codejam/contest/32016/dashboard */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


public class MinimumScalarProduct {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int caseN = 1;
      for(int i = 0; i < n; i++){
         int v = sc.nextInt();
         int[] a = new int[v];
         int[] b = new int[v];
         for(int j = 0; j < v; j++){
            a[j] = sc.nextInt();
         }
         for(int j = 0; j < v; j++){
            b[j] = sc.nextInt();
         }
         Arrays.sort(a);
         Arrays.sort(b);
         BigInteger total = BigInteger.valueOf(0);
         for(int j = 0; j < v; j++){
            int x = v - 1 - j;
            int y = j;
            total = total.add(BigInteger.valueOf(a[x]).multiply(BigInteger.valueOf(b[y])));
         }
         System.out.println("Case #" + caseN + ": " + total);
         caseN++;
      }
   }
}
