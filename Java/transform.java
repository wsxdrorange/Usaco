
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: transform
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class transform{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner (new File ("transform.in"));
		PrintWriter pw = new PrintWriter("transform.out");
		int s = in.nextInt();
		char prev [][] = new char [s][s];
		char transformed [][] = new char [s][s];
		for (int i = 0; i < s; i++){
			prev[i] = in.next().toCharArray();
		}
		for (int i = 0; i < s; i++){
			transformed[i] = in.next().toCharArray();
		}
		if (checkOne(prev, transformed)){
			pw.println("1");
		}
		else if (CheckTwo(prev, transformed)){
			pw.println("2");
		}
		else if (CheckThree(prev, transformed)){
			pw.println("3");
		}
		else if (CheckFour(prev, transformed)){
			pw.println("4");
		}
		else if (CheckFive(prev, transformed)){
			pw.println("5");
		}
		else if (checkSix(prev, transformed)){
			pw.println("6");
		}
		else {
			pw.println("7");
		}
		pw.close();
	}
	public static boolean CheckFive(char [][] prev, char [][] transformed){
		prev = reflect(prev);
		char [][] test1 = prev;
		char [][] test2 = prev;
		char [][] test3 = prev;
		if (checkOne(test1, transformed)){
			return true;
		}
		else if (CheckTwo(test2, transformed)){
			return true;
		}
		else if (CheckThree(test3, transformed)){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean CheckFour(char [][] prev, char [][] transformed){
		 prev = reflect(prev);
		 if (checkSix(prev, transformed)){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
	public static char [][] reflect(char [][] arr){
		char [][] newArr = new char [arr.length][arr[0].length];
		 for (int i = 0; i < arr.length; i++){
			 for (int j = 0; j < arr.length; j++){
				 newArr[i][j] = arr[i][arr.length-j-1];
			 }
		 }
		 return newArr;

	}
	public static boolean checkSix(char [][] prev, char [][] transformed){
		for (int i = 0; i < prev.length; i++){
			for (int j = 0; j < prev[0].length; j++){
				if (prev[i][j] != transformed[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean checkOne(char [][] prev, char [][] transformed){
		prev = rotateArray(prev);
		if (checkSix(prev,transformed)){
			return true;
		}
		else{
			return false;
		}
		
	}
	public static boolean CheckTwo(char [][] prev, char [][] transformed){
		prev = rotateArray(rotateArray(prev));
		if (checkSix(prev,transformed)){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean CheckThree(char [][] prev, char [][] transformed){
		prev = rotateArray(rotateArray(rotateArray(prev)));
		if (checkSix(prev,transformed)){
			return true;
		}
		else{
			return false;
		}
	}
	public static char[][] rotateArray(char[][] arr){

		final int M = arr.length;
	    final int N = arr[0].length;
	    char[][] ret = new char[N][M];
	    for (int r = 0; r < M; r++) {
	        for (int c = 0; c < N; c++) {
	            ret[c][M-1-r] = arr[r][c];
	        }
	    }
	    return ret;
    }
}
