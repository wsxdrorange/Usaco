
/*
 ID: zhang.r1
 LANG: JAVA
 PROG: combo
 */

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class UVATemp{
	public static void main (String args []) throws Exception
	{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner (new File ("combo.in"));
		PrintWriter pw = new PrintWriter("combo.out");
		int max = in.nextInt();
		int lock [] = new int [max];
		int farmerLock [] = new int[3];
		int masterLock [] = new int [3];
		for (int i = 0; i < max; i++){
			lock[i] = i+1;
		}
		for (int i = 0; i < 3; i++){
			farmerLock[i] = in.nextInt();
		}
		for (int i = 0; i < 3; i++){
			masterLock[i] = in.nextInt();
		}
		HashSet<String> possibleCombos = new HashSet<>();
		for (int i = 1; i <= max; i++){
			for (int j = 1; j <= max; j++){
				for (int k = 1; k <= max; k++){
					String temp = i + " " + j + " " + k;
					if (check(temp,farmerLock, max) || check(temp,masterLock, max)){
						possibleCombos.add(temp);
					}
				}
			}
		}
		pw.println(possibleCombos.size());
		pw.close();
    }
	public static boolean check(String temp,int [] combo, int max){
		String [] currentCombocc = temp.split(" ");
		int [] currentCombo = new int [3];
		for (int i = 0; i < 3; i++){
			currentCombo[i] = Integer.parseInt(currentCombocc[i]);
		}
		boolean pass = true;
		for (int i = 0; i < 3; i++){
			if (currentCombo[i] == 1){
				if (combo[i] != 1 && combo[i] != max-1 && combo[i] != max && combo[i] != 2 && combo[i] != 3){
					pass = false;
					break;
				}
			}
			else if (currentCombo[i] == 2){
				if (combo[i] != 2 && combo[i] != max && combo[i] != 1 && combo[i] != 4 && combo[i] != 3){
					pass = false;
					break;
				}
			}
			else if (currentCombo[i] == max){
				if (combo[i] != max && combo[i] != max-1 && combo[i] != max-2 && combo[i] != 1 && combo[i] != 2){
					pass = false;
					break;
				}
			}
			else if (currentCombo[i] == max-1){
				if (combo[i] != max-1 && combo[i] != max-2 && combo[i] != max-3 && combo[i] != max && combo[i] != 1){
					pass = false;
					break;
				}
			}
			else{
				if (Math.abs(combo[i]-currentCombo[i]) > 2){
					pass = false;
					break;
				}
			}
		}
		return pass;
	}
}
