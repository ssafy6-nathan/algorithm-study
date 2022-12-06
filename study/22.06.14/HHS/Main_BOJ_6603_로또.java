import java.io.*;
import java.util.*;

public class Main_BOJ_6603_로또 {

	static int K;
	static int [] S;
	
	public static void main(String[] args) throws IOException{

		//0 입력 오기전까지 계속 돌리기
		BufferedReader br = null;
		StringTokenizer token = null;
		
		K = 1;
		br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			token = new StringTokenizer(br.readLine());
			K = 1;
			K = Integer.parseInt(token.nextToken());
		
			if(K == 0) return;
			S = new int[K];
			
			for (int i = 0; i < K; i ++) {
				S[i] = Integer.parseInt(token.nextToken());
			}
			
			Comb(0,0,new boolean[K], "");
			System.out.println();
			
			
		}
		
	}

	private static void Comb(int cnt, int start, boolean[] visited, String nums) {

		if(cnt == 6) {
			System.out.println(nums);
			return;
		}
		
		for (int i = start; i < K; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			
			Comb(cnt+1, i+1, visited, nums+S[i]+" ");
			visited[i] = false;
			
		}
		
	}

}
