import java.io.*;
import java.util.*;

public class Main_BOJ_1946_신입사원2 {

	static int T;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			answer = 0;
			int Min = Integer.MAX_VALUE;
			PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int []>() {
				 
	            		@Override
	            		public int compare(int []o1, int [] o2) {
	                		return o1[0]-o2[0];
	            		}
	        	});
			
			for(int n = 0; n < N; n++) {
				token =  new StringTokenizer(br.readLine());
				que.offer(new int[] 
						{Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
			}
			
			while(!que.isEmpty()) {
				int [] q = que.poll();
				if(q[1] < Min) {
					Min = q[1];
					answer++;
				}
			}
			bw.write(String.valueOf(answer)+"\n");
			
		}
		bw.close();
		
		
	}

}
