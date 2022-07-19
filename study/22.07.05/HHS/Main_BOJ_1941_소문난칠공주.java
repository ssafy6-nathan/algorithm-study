import java.io.*;
import java.util.*;

public class Main_BOJ_1941_소문난칠공주 {

	static char [][] map;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Comb(0, 0, new int[7]);
		System.out.println(result);
	}

	private static void Comb(int start, int cnt, int[] nums) {

		if(cnt == 7) {
			bfs(nums);
			return;
		}
		
		for(int i = start; i < 25; i++) {
			nums[cnt] = i;
			Comb(i+1, cnt+1, nums);
		}
		
	}

	private static void bfs(int[] nums) {
		
		Queue<Integer> que = new LinkedList<>();
		
		boolean [] visited = new boolean[7];
		
		visited[0] = true;
		que.add(nums[0]);
		
		int count = 1; 
		int sCount = 0;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			int r = num / 5;
			int c = num % 5;
			
			if(map[r][c] == 'S')
				sCount++;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				for(int n = 1; n < 7; n++) {
					if(visited[n])
						continue;
					int rr = nums[n] / 5;
					int cc = nums[n] % 5;
					
					if(nr == rr && nc == cc) {
						visited[n] = true;
						count++;
						que.add(nums[n]);
					}
				}
			}
			
			
		}
		//다 이어져있고 과반수가 S이면 result올리기
		if(count == 7 && sCount >= 4)
			result++;
		
	}

}
