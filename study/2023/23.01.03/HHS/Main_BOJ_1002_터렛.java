import java.io.*;
import java.util.*;

public class Main_BOJ_1002_터렛 {

	static int T;
	static int x1, y1, r1, x2, y2, r2;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		StringTokenizer token = null;
		
		for(int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(token.nextToken());
			y1 = Integer.parseInt(token.nextToken());
			r1 = Integer.parseInt(token.nextToken());
			
			x2 = Integer.parseInt(token.nextToken());
			y2 = Integer.parseInt(token.nextToken());
			r2 = Integer.parseInt(token.nextToken());
			
			dist();
			
			bw.write(String.valueOf(answer)+"\n");
		}
		bw.close();
		
	}

	private static void dist() {

		if(x1 == x2 && y1 == y2 && r1 == r2) {
			answer = -1;
			return;
		}
		
		int c = (int) (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		int minR = (int) Math.pow(r2-r1, 2);
		int plusR = (int) Math.pow(r1+r2, 2);
		
		if(c > plusR || c < minR) {
			answer = 0;
			return;
		}
		if(c == plusR || c == minR) {
			answer = 1;
			return;
		}
		else {
			answer = 2;
			return;
		}
		
	}

}
