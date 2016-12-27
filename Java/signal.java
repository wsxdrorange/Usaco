import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class signal {
	public static void main(String args []) throws Exception{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("cowsignal.in"));
		PrintWriter pw = new PrintWriter("cowsignal.out");
		int m = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();
		in.nextLine();
		String multiplied = "";
		for (int i = 0; i < m; i++){
			String s = in.next();
			for (int w = 0; w < k; w++){
				for (int j = 0; j < s.length(); j++){
					for (int l= 0; l < k; l++){
						multiplied += s.charAt(j);
					}
				}
				multiplied += " ";
			}
		}
		String [] result = multiplied.split(" ");
		for (int i = 0; i < result.length; i++){
			pw.println(result[i]);
		}
		pw.close();
	}
}
