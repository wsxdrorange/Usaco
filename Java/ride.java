/*
 ID: zhang.r1
 LANG: JAVA
 PROG: ride
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class ride {
	public static void main (String args []) throws Exception
	{
		Scanner in = new Scanner(new File("ride.in"));
		PrintWriter pw = new PrintWriter("ride.out");
		String temp;
		int saved = 0;
		temp = in.nextLine();
		int total = 1;
		for (int i = 0; i < temp.length(); i++){
			total *= (((int)temp.charAt(i))-64);	
		}
		saved = total%47;
		temp = in.nextLine();
		total = 1;
		for (int i = 0; i < temp.length(); i++){
			total *= (((int)temp.charAt(i))-64);	
		}
		if (total%47 == saved){
			pw.println("GO");
		}
		else{
			pw.println("STAY");
		}
		pw.close();
	}
}
