package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_2206_벽부수고이동하기 {

	static int N,M;
	static char [][] map;
	static int result;
	static int [] dr = {-1,0,1,0};//북 동 남 서
	static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}//map입력 끝
		
		//시작점 que에 넣고 bfs 돌리기
		//사방탐색
		//맵 나갔는지 확인
		//visited여부와 부수기 여부 같이 확인
			//현재 부순적 있으면 앞으로 계속 부술 수 없음->0으로만 가야함 --> 안된다면 큐에 안넣음
			//부순 적 없으면 상관 없음
		//마지막칸에 오면 끝
		
		bfs();
		
		System.out.println(result);
		
	}

	private static void bfs() {
		Queue<Move> que = new LinkedList<>();
		
		que.add(new Move(0,0,1,false));
		
		boolean [][][] visited = new boolean [N][M][2]; //방문여부 + 부수기여부(0->안부숨, 1->부숨)
		
		while(!que.isEmpty()) {
			Move m = que.poll();
			if(m.r == N-1 && m.c == M-1) {
				result = m.count;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = m.r + dr[d];
				int nc = m.c + dc[d];
				
				if(!check(nr,nc)) continue; //맵 범위 벗어나면 나가기
				
				int count = m.count + 1;
				
				if(map[nr][nc] == '1') {//벽이면 부순 적 없으면 부수고 아니면 그냥 나가기
					if(!m.destroy) {
						que.add(new Move(nr,nc,count,true));
						visited[nr][nc][1] = true;
					}
				}else {//벽이 아니면 부순적 있으면 1, 없으면 0으로 해서 넣기
					if(!m.destroy && !visited[nr][nc][0]) { //부순적 없고 방문 안했으면
					
						que.add(new Move(nr,nc,count,false));
						visited[nr][nc][0] = true;
					
					}else if(m.destroy && !visited[nr][nc][1]) {
						
						que.add(new Move(nr,nc,count,true));
						visited[nr][nc][1] = true;
						
					}
				}
				
			}
		}
		result = -1;
		
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	
}
class Move{
	int r;
	int c;
	int count;
	boolean destroy;
	public Move(int r, int c, int count, boolean destroy) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
		this.destroy = destroy;
	}
}
