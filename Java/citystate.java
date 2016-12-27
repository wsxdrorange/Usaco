import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CityState {
	public static void main (String args []) throws Exception{
		//canner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("citystate.in"));
		PrintWriter pw = new PrintWriter("citystate.out");
		int n = in.nextInt();
		int count = 0;
		Map<String,Integer> combos = new HashMap<>();
		for (int i = 0; i < n; i++){
			String a = in.next();
			String state = in.next().substring(0,2);
			String city = a.substring(0,2);
			if (!city.equals(state)){
				String temp = city+state;
				if (combos.containsKey(temp)){
					combos.put(temp, combos.get(temp)+1);
				}
				else{
					combos.put(temp, 1);
				}
			}
		}
		for (String key: combos.keySet()){
			String specialKey = key.substring(2)+key.substring(0,2);
			if (combos.containsKey(specialKey)){
				count += combos.get(key)*combos.get(specialKey);
			}
		}
		pw.println(count/2);
		pw.close();
	}
}
