import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class blocks {
	public static void main(String args []) throws Exception{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("blocks.in"));
		PrintWriter pw = new PrintWriter("blocks.out");
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int [] counter = new int [26];
		int n = in.nextInt();
		List <Character> result = new ArrayList<>();
		for (int i = 0; i < n; i++){
			List <Character> s1 = new ArrayList<>();
			List <Character> s2 = new ArrayList<>();
			String s = in.next();
			for (int j = 0; j < s.length(); j++){
				s1.add(s.charAt(j));
			}
			s = in.next();
			for (int j = 0; j < s.length(); j++){
				s2.add(s.charAt(j));
			}
			for (int j = 0; j < s1.size(); j++){
				if (s1.isEmpty() || s2.isEmpty()){
					break;
				}
				else{
					if (s2.contains(s1.get(j))){
						result.add(s1.get(j));
						s2.remove(s1.get(j));
						s1.remove(j);
						j--;
					}
				}
			}
			for (int j = 0; j < s1.size(); j++){
				result.add(s1.get(j));
			}
			for (int j = 0; j < s2.size(); j++){
				result.add(s2.get(j));
			}
		}
		for (int i = 0; i < result.size(); i++){
			for (int j = 0; j < 26; j++){
				if (result.get(i) == alphabet[j]){
					counter[j]++;
				}
			}
			
		}
		for (int i = 0; i < 26; i++){
			pw.println(counter[i]);
		}
		pw.close();
	}
	public static void GeneratePermutations(List<List<String>> Lists, List<String> result, int depth, String current)
	{
	    if(depth == Lists.size())
	    {
	       result.add(current);
	       return;
	     }

	    for(int i = 0; i < Lists.get(depth).size(); ++i)
	    {
	        GeneratePermutations(Lists, result, depth + 1, current + Lists.get(depth).get(i));
	    }
	}

}
