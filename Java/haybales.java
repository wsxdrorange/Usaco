import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Haybales {
	public static void main (String args []) throws Exception{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("haybales.in"));
		PrintWriter pw = new PrintWriter("haybales.out");
		int n = in.nextInt();
		int q = in.nextInt();
		int [] bales = new int [n];
		for (int i = 0; i < n;i++){
			bales[i] = in.nextInt();
		}
		Arrays.sort(bales);
		for (int i = 0; i < q; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int diff = search(b,bales) - search(a-1,bales); //Fastest way is to calculate int from 0-B - int from 0-(a-1)
			pw.println(diff);
		}
		pw.close();
	}
	public static int search(int num, int [] bales){
		if(bales[0] > num) {
			return 0;
		}
		int min = 0;
		int max = bales.length-1;
		while(min != max) {
			int mid = (min+max+1)/2;
			if(bales[mid] <= num) {
				min = mid;
			}
			else {
				max = mid-1;
			}
		}
		return min + 1;
	}
}
