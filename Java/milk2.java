
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: milk2
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class milk2{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner (new File ("milk2.in"));
		PrintWriter pw = new PrintWriter("milk2.out");
		int times = in.nextInt();
		boolean [] timeMilked = new boolean [9999999];
		int endPartition = 0;
		int begPartition = 9999999;
		for (int i = 0; i < times; i++){
			 int bottom = in.nextInt();
			 int top = in.nextInt();
			 if (top > endPartition){
				 endPartition = top;
			 }
			 if (bottom < begPartition){
				 begPartition = bottom;
			 }
			 for (int j = bottom; j < top; j++){
				 timeMilked[j] = true;
			 }
		}
		int max = 0;
		int maxFalse = 0;
		int count = 0;
		boolean milked = timeMilked[begPartition];
		for (int i = begPartition; i < endPartition; i++){
			if (timeMilked[i] == !milked){
				if (milked == true){
					if (count > max){
						max = count;
					}
				}
				else{
					if (count > maxFalse){
						maxFalse = count;
					}
				}
				milked = !milked;
				count = 1;
			}
			else{
				count++;
			}
		}
		if (milked == true){
			if (count > max){
				max = count;
			}
		}
		else{
			if (count > maxFalse){
				maxFalse = count;
			}
		}
		pw.println(max + " " + maxFalse);
		pw.close();
	}
}
