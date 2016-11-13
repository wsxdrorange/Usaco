
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: crypt1
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class crypt1{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner (new File ("crypt1.in"));
		PrintWriter pw = new PrintWriter("crypt1.out");
		int nums = in.nextInt();
		int digits [] = new int [nums];
		for (int i = 0; i < nums; i++){
			digits[i] = in.nextInt();
		}
		int count = 0;
		for (int i = 100; i < 1000; i++){
			for (int j = 10; j < 100; j++){
				int product = i*j;
				int p1 = (j%10)*i;
				int p2 = (j/10)*i;
				if (check(i,digits, false) && check(j,digits, false) && check(product,digits, false) && check(p1,digits, true) && check(p2,digits, true)){
					count++;
				}
			}
		}
		pw.println(count);
		pw.close();
    }
	public static boolean check(int a, int [] digits, boolean partialProduct){
		boolean check = true;
		boolean safe = false;
		String num = Integer.toString(a);
		if (partialProduct){
			if (num.length() != 3){
				return false;
			}
		}
		for (int i = 0; i < num.length(); i++){
			safe = false;
			for (int j = 0; j < digits.length; j++){
				if (Character.getNumericValue(num.charAt(i)) == digits[j]){
					safe = true;
				}
			}
			if (!safe){
				check = false;
				break;
			}
		}
		return check;
	}
}
