/*
 ID: zhang.r1
 LANG: JAVA
 PROG: gift1
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class gift1{
	public static void main (String args []) throws Exception
	{
		Scanner in = new Scanner(new File("gift1.in"));
		PrintWriter pw = new PrintWriter("gift1.out");
		int times = in.nextInt();
		String [] people = new String [times];
		int [] totalPeopleMoney = new int [times];
		for (int i = 0; i < times; i++){
			people[i] = in.next();
		}
		boolean valid = true;
		while(in.hasNext()){
			String giftGiver = in.next();
			int totalMoney = in.nextInt();
			int divisiblePeople = in.nextInt();
			if (divisiblePeople != 0){
				for (int i = 0; i < times; i++){
					if (giftGiver.equals(people[i])){
						totalPeopleMoney[i] -= totalMoney;
						totalPeopleMoney[i] += totalMoney%divisiblePeople;
					}
				}
				for (int i = 0; i < divisiblePeople; i++){
					String giftReceiver = in.next();
					for (int j = 0; j < times; j++){
						if (people[j].equals(giftReceiver)){
							totalPeopleMoney[j] += totalMoney/divisiblePeople;
						}
					}
				}
			}
			
		}
		for (int i = 0; i < times; i++){
			pw.println(people[i] + " " + totalPeopleMoney[i]);
		}
		pw.close();
	}
}
