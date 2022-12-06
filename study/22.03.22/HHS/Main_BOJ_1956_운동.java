package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_1956_운동 {

	static int V, E;
	static int [][] map;
	static int max = 987654321;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		
		//map 다 일단 맥스값으로 해놓고 값 들어올 때마다 해당 값들을 로드 값 넣어주기
		//다른 곳 들렀다 가는게 더 빠르면 그 값으로 바꿔주기
		//a-b-a 돌아올 길 있으면 사이클 있음
		
		map = new int[V+1][V+1];
		
		for (int i = 0; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				if(i != j) map[i][j] = max;
			}
		}
		
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int road = Integer.parseInt(token.nextToken());
			
			map[start][end] = road;
		}//map넣기 완료
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					
					if(i == j) continue;
					
					if(map[i][j] > map[i][k]+map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}//거쳐서 가는게 더 빠르면 바꿔주기 완료
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if(i == j) continue;
				
				if(map[i][j] < max && map[j][i] < max) {
					//왔다갔다 길이 있으면 사이클 존재함
					// 이들의 값 중 가장 작은 값 프린트
					result = Math.min(result, map[i][j]+map[j][i]);
				}
			}
		}
		
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
		
		
	}
	

}
