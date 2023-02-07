import java.io.*;
import java.util.*;

public class Main_BOJ_14712_넴모넴모 {

	static int answer;
	static int N, M;
	static boolean [] v;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		
		v = new boolean[N*M];

		find(0);
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

	private static void find(int num) {
		if(num == N*M) {
			for(int i = 0; i < N-1; i++) {
				for(int j = 0; j < M-1; j++) {
					if(v[i*M +j] && v[i*M + j + 1] && v[i*M + j + M] && v[i*M +j + M + 1])
						return;
				}
			}
			
			answer++;
			return;
		}
		
		v[num] = true;
		find(num+1);
		v[num] = false;
		find(num+1);
	}

}
