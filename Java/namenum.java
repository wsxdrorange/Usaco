
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: namenum
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class namenum{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner (new File ("namenum.in"));
		PrintWriter pw = new PrintWriter("namenum.out");
		String word = in.next();
		in = new Scanner(new File("dict.txt"));
		ArrayList<String> dictionary = new ArrayList<>();
		while (in.hasNext()){
			dictionary.add(in.next());
		}
		ArrayList<String> matched = new ArrayList<>();
		for (int i = 0; i < dictionary.size(); i++){
			if (word.equals(convert(dictionary.get(i)))){
				matched.add(dictionary.get(i));
			}
		}
		if (matched.size() == 0)
		{
			pw.println("NONE");
		}
		else{
			for (String s: matched){
				pw.println(s);
			}
		}
		pw.close();
		
    }
	public static String convert(String word){
		String result = "";
		for (int i = 0; i < word.length(); i++){
			if (word.charAt(i) == 'A' || word.charAt(i) == 'B' || word.charAt(i) == 'C'){
				result += "2";
			}
			else if (word.charAt(i) == 'D' || word.charAt(i) == 'E' || word.charAt(i) == 'F'){
				result += "3";
			}
			else if (word.charAt(i) == 'G' || word.charAt(i) == 'H' || word.charAt(i) == 'I'){
				result += "4";
			}
			else if (word.charAt(i) == 'J' || word.charAt(i) == 'K' || word.charAt(i) == 'L'){
				result += "5";
			}
			else if (word.charAt(i) == 'M' || word.charAt(i) == 'N' || word.charAt(i) == 'O'){
				result += "6";
			}
			else if (word.charAt(i) == 'P' || word.charAt(i) == 'R' || word.charAt(i) == 'S'){
				result += "7";
			}
			else if (word.charAt(i) == 'T' || word.charAt(i) == 'U' || word.charAt(i) == 'V'){
				result += "8";
			}
			else if (word.charAt(i) == 'W' || word.charAt(i) == 'X' || word.charAt(i) == 'Y'){
				result += "9";
			}
		}
		return result;
	}
}
