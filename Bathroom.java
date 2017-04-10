/*https://code.google.com/codejam/contest/3264486/dashboard*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
class Bathroom
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int caseNum = 1;
		for(int i = 0; i < cases; i++){
			BigInteger n = new BigInteger(sc.next());
			BigInteger k = new BigInteger(sc.next());
			Comparator<BigInteger> bicmp = new Comparator<BigInteger>(){
				public int compare(BigInteger x, BigInteger y){
					return y.compareTo(x);
				}
			};
			PriorityQueue<BigInteger> q = new PriorityQueue<BigInteger>(1000, bicmp);
			HashMap<BigInteger, BigInteger> map = new HashMap<>();
			BigInteger count = BigInteger.ZERO;
			map.put(n, BigInteger.ONE);
			q.add(n);
			BigInteger smaller = BigInteger.ZERO;
				BigInteger bigger = BigInteger.ZERO;
			while(count.compareTo(k) < 0){
				BigInteger temp = q.remove();
				BigInteger number = map.get(temp);
				//System.out.println("COUNT " + count.toString());
				//System.out.println(temp.toString());
				if(temp.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)){
					//System.out.println("ODD");
					temp = temp.subtract(BigInteger.ONE);
					smaller = temp.divide(BigInteger.valueOf(2));
					bigger = smaller;
				}
				else{
					//System.out.println("EVEN");
					bigger = temp.divide(BigInteger.valueOf(2));
					smaller = bigger.subtract(BigInteger.ONE);
				}
				if(!map.containsKey(smaller)){
					map.put(smaller, BigInteger.ZERO);
					q.add(smaller);
				}
				if(!map.containsKey(bigger)){
					map.put(bigger, BigInteger.ZERO);
					q.add(bigger);
				}
				//System.out.println(smaller.toString());
				//System.out.println(bigger.toString());
				map.put(smaller, map.get(smaller).add(number));
				map.put(bigger, map.get(bigger).add(number));
				count = count.add(number);
			}
			System.out.println("Case #" + caseNum + ": " + bigger.toString() + " " + smaller.toString());
			caseNum++;
		}
	}
}
