import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class speeding {
	public static void main (String args []) throws Exception{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner(new File("speeding.in"));
		PrintWriter pw = new PrintWriter(new File("speeding.out"));
		int n = in.nextInt();
		int m = in.nextInt();
		int saved = 0;
		int max = 0;
		int speeds [] = new int [100];
		for (int i = 0; i < n; i++){
			int range = in.nextInt();
			int speed = in.nextInt();
			for (int j = saved; j < saved+range; j++){
				speeds[j] = speed;
			}
			saved += range;
		}
		saved = 0;
		for (int i = 0; i < m; i++){
			int range = in.nextInt();
			int speed = in.nextInt();
			for (int j = saved; j < saved+range; j++){
				if (speed > speeds[j]){
					int difference = speed-speeds[j];
					if (difference > max){
						max = difference;
					}
				}
			}
			saved += range;
		}
		//System.out.println(max);
		pw.println(max);
		pw.close();
	}
}
