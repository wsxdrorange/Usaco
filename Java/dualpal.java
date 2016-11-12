
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: dualpal
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class dualpal{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("dualpal.in"));
		PrintWriter pw = new PrintWriter("dualpal.out");
		int n = in.nextInt();
		int s = in.nextInt();
		int count = 0;
		for (int j = s+1; j < Integer.MAX_VALUE; j++){
			if (isDualPaly(j)){
				pw.println(j);
				count++;
				if (count == n){
					break;
				}
			}
		}
		pw.close();
	}
	public static boolean isDualPaly(int j){
		int count = 0;
		for (int base = 2; base <= 10; base++){
			String num = Integer.toString(j,base);
			if (isPalindrome(num)){
				count++;
				if (count == 2){
					break;
				}
			}
		}
		return (count >= 2);
	}
	public static boolean isPalindrome(String s){
		String reverse = "";
		for (int i = s.length()-1; i >= 0; i--){
			reverse += s.charAt(i);
		}
		return reverse.equals(s);
	}
}
