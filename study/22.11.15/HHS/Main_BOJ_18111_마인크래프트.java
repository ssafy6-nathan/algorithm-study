import java.io.*;
import java.util.*;

public class Main_BOJ_18111_마인크래프트 {

	static int N, M, B;
	static int [][] map;
	static int [] answer;
	static int Max, Min;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		B = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		answer = new int[2];
		answer[0] = Integer.MAX_VALUE;
		Max = Integer.MIN_VALUE;
		Min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				Max = Math.max(Max, map[i][j]);
				Min = Math.min(Min, map[i][j]);
			}
		}
		int time = Integer.MAX_VALUE;
		//높이는 최소에서 최대까지만 나올 수 있으니까 다 돌려보면서 값 계산하기
		for(int i = Min; i <= Max; i++) {
			time = cal(i);
			if(time < answer[0]) {
				answer[0] = time;
				answer[1] = i;
			}
			
			else if(answer[0] == time && i > answer[1]) {
				answer[0] = time;
				answer[1] = i;
			}
			
		}
		
		bw.write(String.valueOf(answer[0] + " "+answer[1]));
		bw.close();
	}

	private static int cal(int h) {
		int time = 0;
		int bag = B;
		//h높이로 다 맞추면 걸리는 시간
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == h) continue;
				if(map[i][j] > h) {
					//없애야함 -> 2초
					time += (map[i][j] - h)*2;
					bag += map[i][j] - h;
				}else {
					//백에서 가져와야함 -> 1초
					time += (h - map[i][j]);
					bag -= (h - map[i][j]);
				}
			}
		}
		if(bag < 0) return Integer.MAX_VALUE;
		return time;
	}

}
