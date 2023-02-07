import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ_15652_N과M4 {

	static int N, M;
	static BufferedWriter bw; 
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		Comb(0, 0, new int[M]);
		bw.close();
	}

	private static void Comb(int cnt, int start, int[] nums) throws IOException {

		if(cnt == M) {
			for(int i = 0; i < M; i++)
				bw.write(String.valueOf(nums[i]+1) + " ");
			bw.write("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			
			nums[cnt] = i;
			Comb(cnt+1, i, nums);

		}
	}

}
