
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: palsquare
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class palsquare{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("palsquare.in"));
		PrintWriter pw = new PrintWriter("palsquare.out");
		int base = in.nextInt();
		for (int i = 1; i <= 300; i++){
			String num = Integer.toString(i,base).toUpperCase();
			String square = Integer.toString((i*i),base).toUpperCase();
			if (isPalindrome(square)){
				pw.println(num + " " + square);
			}
		}
		pw.close();
	}
	public static boolean isPalindrome(String s){
		String reverse = "";
		for (int i = s.length()-1; i >= 0; i--){
			reverse += s.charAt(i);
		}
		return reverse.equals(s);
	}
}
