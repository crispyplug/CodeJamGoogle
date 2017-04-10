import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

/* https://code.google.com/codejam/contest/3264486/dashboard#s=p1*/
class Tidy
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int caseNum = 1;
		for(int i = 0; i < cases; i++){
			BigInteger n = new BigInteger(sc.next());
			String result = findLess(n);
			BigInteger x = new BigInteger(result);
			System.out.println("Case #" + caseNum + ": " + x.toString());
			caseNum++;
		}
	}
	public static String findLess(BigInteger n){
		String temp = n.toString();
		boolean found = true;

		if(temp.length() > 1){
			StringBuilder backup = new StringBuilder();
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for(i = 0; i < temp.length() -1; i++){
				int digit = Integer.parseInt(Character.toString(temp.charAt(i)));
				int second = Integer.parseInt(Character.toString(temp.charAt(i + 1)));

				if(second < digit){
					int omg = digit -1;
					sb.append(omg);
					found = false;
					break;
				}
				else if( second == digit){
					backup.append(digit);
				} 
				else{
					if(backup.length() > 0){
						sb.append(backup.toString());
						backup = new StringBuilder();
					}
					sb.append(temp.charAt(i) + "");
				}

			}
			for(int j = sb.toString().length(); j < temp.length(); j++){
				sb.append("9");
			}
			if(!found){
				return sb.toString();
			}
			return n.toString();
		}
		else{
			return n.toString();
		}
	}
}
