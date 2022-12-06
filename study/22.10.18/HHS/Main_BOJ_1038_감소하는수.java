import java.io.*;
import java.util.*;

public class Main_BOJ_1038_감소하는수 {

	static int N;
	static long cnt;
	static long answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		answer = -1;

		if(N <= 9) 
			answer = N;
			
		else {
			Queue<long[]> que = new LinkedList<>();
			for(int i = 1; i <= 9; i++) {
				que.offer(new long [] {i, cnt});
				cnt++;
			}
			while(!que.isEmpty()) {
				long [] q = que.poll();
				long temp = q[0];
				long count = q[1];

				if(temp > 9876543210L) 
					break;
				
				if(count == N) {
					answer = temp;
					break;
				}
				
				for(int i = 0; i <= 9; i++) {
					if(temp % 10 > i) {
						long t = temp*10 + i;
						que.offer(new long[] {t, ++cnt});
					}else break;
				}
			}
			
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
