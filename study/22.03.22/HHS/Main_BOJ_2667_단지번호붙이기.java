package study_Nathan;
import java.io.*;
import java.util.*;

public class Main_BOJ_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int num;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];//방문 여부
		ArrayList<Integer> total = new ArrayList<>();	
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}//map구성 완료
		
		num = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0, a =0; j < N; j++) {
				if(visited[i][j] == false && map[i][j] == 1) {//방문하지 않았고 1의 값을 가진다면 go하고 카운트 올려
					go(i,j,num);
					num = num+1;
					total.add(cnt);
					cnt = 0;
				}
			}
		}
		
		
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
			}
		}//단지 몇개인지 구하기 완료
		
		System.out.println(max-1);
		Collections.sort(total);
		for (int i = 0; i < total.size(); i++) {
			System.out.println(total.get(i));
		}
		
	}
	public static void go(int x, int y, int num) {
		map[x][y] = num;
		cnt++;
		visited[x][y] = true;
		int nx = 0;
		int ny = 0;
		for (int d = 0; d < 4; d++) {
			nx = x+ dx[d];
			ny = y+ dy[d];
			
			if(!check(nx,ny)) {
				continue;
			}
			if(map[nx][ny] != 1 || visited[nx][ny] == true) {
				continue;
			}
			
			//범위를 벗어나지 않았고 map에서의 값이 1이며, 방문한 적도 없는 좌표
			map[nx][ny] = num;
			go(nx,ny,num);
		}
		
		
	}
	public static boolean check(int x, int y) {
		return x >= 0 && y >=0 && x < N && y < N;
	}

}





