package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_16954_움직이는미로탈출 {

	static char [][] map;
	static int [] dr = {-1, -1, -1, 0, 0, 0};
	static int [] dc = {-1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		map = new char[8][8];
		
		for(int i = 0; i < 8; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < arr.length; j++) {
				map[i][j] = arr[j];
			}
		}
		
		bfs();
		
	}

	private static void bfs() {

		Queue<Wookjae> que = new LinkedList<Wookjae>();
		
		boolean flag = false; //bfs 끝났는지 판별
		
		que.add(new Wookjae(7,0,1));
		
		while(!que.isEmpty()) {
			
			Wookjae w = que.poll();
			int r = w.r;
			int c = w.c;
			int count = w.count;
			
			//목적지 도착하면 바로 1 출력하기
			if(r == 0 && c == 7) { 
				System.out.println(1);
				flag = true;
				break;
			}
			

			for (int d = 0; d < 6; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				//map 벗어나면 나가기
				if(!check(nr,nc)) continue;
				
				//다음이 벽이면 나가기
				if(map[nr][nc] == '#') continue;
				
								
				
				//한칸씩 위로 올라가기(밑으로 한칸씩 내려오는 것과 동일할 듯) -> (8-카운트)번째 r에 있는 애들은 모두 .으로 처리
				if(check(nr-1, nc)) {//올라갈 곳이 있으면 올라가기
					//올라갔는데 벽이면 나가기
					if(map[nr-1][nc] == '#') continue;
					que.add(new Wookjae(nr-1,nc, count++));
				}
				else {
					que.add(new Wookjae(nr,nc, count++));
				}

				//올라갈 곳이 없거나 올라간 곳이 벽이 아닌 경우 일단 (8-count번째) r에 있는 애들 모두 .로 하기
				if(8-count >= 0) {
					for(int i = 0; i < 8; i++) {
						map[8-count][i] = '.';
					}
				}
				
			}
			
			
		}
		if(!flag) System.out.println(0);
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < 8 && c >= 0 && c < 8;
	}

	
}

class Wookjae{
	int r;
	int c;
	int count;
	public Wookjae(int r, int c, int count) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
	}
	
}
