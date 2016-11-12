
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: milk
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class milk{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("milk.in"));
		PrintWriter pw = new PrintWriter("milk.out");
		int unitsNeeded = in.nextInt();
		int farmers = in.nextInt();
		int money = 0;
		int centsPerUnit [] = new int [farmers];
		int units [] = new int [farmers];
		for (int i = 0; i < farmers; i++){
			centsPerUnit[i] = in.nextInt();
			units[i] = in.nextInt();
		}
		int currentUnits = 0;
		while(currentUnits < unitsNeeded){
			int minCost = 1001	;
			int minIndex = -1;
			for (int i = 0; i < farmers; i++){
				if (centsPerUnit[i] < minCost){
					minCost = centsPerUnit[i];
					minIndex = i;
				}
			}
			if (currentUnits + (units[minIndex]) <= unitsNeeded){
				currentUnits += units[minIndex];
				money += minCost*units[minIndex];
				centsPerUnit[minIndex] = 1001;
			}
			else{
				int needed = unitsNeeded - currentUnits;
				money += minCost*needed;
				currentUnits += needed;
			}
		}
		pw.println(money);
		pw.close();
	}
}
