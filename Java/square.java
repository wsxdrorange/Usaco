import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class square {

	public static void main(String[] args) throws Exception {

		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("square.in"));
		PrintWriter pw = new PrintWriter("square.out");
		int oldx1 = in.nextInt();
		int oldy1 = in.nextInt();
		int oldx2 = in.nextInt();
		int oldy2 = in.nextInt();
		int old2x1 = in.nextInt();
		int old2y1 = in.nextInt();
		int old2x2 = in.nextInt();
		int old2y2 = in.nextInt();
		int newLeftCornerx, newLeftCornery;
		if (oldx1 < old2x1){
			newLeftCornerx = oldx1;
		}
		else
		{
			newLeftCornerx = old2x1;
		}
		if (oldy1 < old2y1){
			newLeftCornery = oldy1;
		}
		else
		{
			newLeftCornery = old2y1;
		}
		int maxHeight, maxWidth;
		if (oldy2 > old2y2){
			maxHeight = oldy2;
		}
		else
		{
			maxHeight = old2y2;
		}
		if (oldx2 > old2x2){
			maxWidth = oldx2;
		}
		else
		{
			maxWidth = old2x2;
		}
		int maxArea;
		if (maxWidth-newLeftCornerx > maxHeight-newLeftCornery){
			maxArea = maxWidth-newLeftCornerx;
			maxArea *= maxArea;
		}
		else
		{
			maxArea = maxHeight-newLeftCornery;
			maxArea *= maxArea;
		}
		pw.println(maxArea);
		pw.close();
	}

}
