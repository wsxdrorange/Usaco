import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class paint {
	public static void main (String args []) throws Exception{
		//Scanner in = new Scanner (System.in);
		Scanner in = new Scanner(new File("paint.in"));
		PrintWriter pw = new PrintWriter(new File("paint.out"));
		int range1 = in.nextInt();
		int range2 = in.nextInt();
		int count = 0;
		boolean [] arr = new boolean [100];
		for (int i = range1; i < range2; i++){
			arr[i] = true;
		}
		range1 = in.nextInt();
		range2 = in.nextInt();
		for (int i = range1; i < range2; i++){
			arr[i] = true;
		}
		for (int i = 0; i < arr.length; i++){
			if (arr[i]){
				count++;
			}
		}
		pw.println(count);
		pw.close();
	}
}
