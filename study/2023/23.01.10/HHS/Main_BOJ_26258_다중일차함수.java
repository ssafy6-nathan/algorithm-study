import java.io.*;
import java.util.*;

public class Main_BOJ_26258_다중일차함수 {

	static int N;
	static int Q;
	static ArrayList<int[]> val;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer token = null;
		val = new ArrayList<>();
		
		int pre_x = 0;
		int pre_y = 0;
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			
			if(i > 0) {
				if((x - pre_x) * (y - pre_y) > 0) 
					val.add(new int[] {x, 1});
				else if((x - pre_x) * (y - pre_y) < 0)
					val.add(new int[] {x, -1});
				else
					val.add(new int[] {x, 0});				
			}
			pre_x = x;
			pre_y = y;
			
		}
		
		
		Q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < Q; i++) {
			double x = Double.parseDouble(br.readLine());
			for(int j = 0; j < val.size(); j++) {
				int[] ans = val.get(j);
				if(ans[0] > x) {
					bw.write(String.valueOf(ans[1])+"\n");
					break;
				}
			}
		}
		bw.close();
		
	}

}
