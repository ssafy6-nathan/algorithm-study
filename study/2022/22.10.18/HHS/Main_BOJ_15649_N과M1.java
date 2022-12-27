import java.io.*;
import java.util.*;

public class Main_BOJ_15649_N과M1 {

	static int N, M;
	static BufferedWriter bw; 
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		Perm(0, new int[M], new boolean[N]);
		bw.close();
	}

	private static void Perm(int cnt, int[] nums, boolean[] visited) throws IOException {

		if(cnt == M) {
			for(int i = 0; i < M; i++)
				bw.write(String.valueOf(nums[i]+1) + " ");
			bw.write("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			nums[cnt] = i;
			Perm(cnt+1, nums, visited);
			visited[i] = false;

		}
	}

}
