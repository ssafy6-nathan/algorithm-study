import java.io.*;
import java.util.*;

public class Main_BOJ_2573_빙산_시간초과 {

	static int N, M;
	static int [][] map;
	static int result;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		if(!zeroCheck())
			System.out.println(0);
		
		else {
			while(true) {
			
				//두 조각 이상으로 떨어져있는지 확인
				if(seperate())
					break;
				
				//다 녹았는데도 나뉘지 않으면 0 출력
				if(!zeroCheck()) {
					result = 0;
					break;
				}
				
				//각 얼음 주위에 0의 개수 세어보고 리스트에 넣기
				LinkedList<Ice> ice = new LinkedList<Ice>();
				for(int i = 1; i < N-1; i++) {
					for(int j = 1; j < M-1; j++) {
						if(map[i][j] != 0) {
							ice.add(new Ice(i, j, count(i,j)));
						}
					}
				}
				
				//리스트에서 뽑으면서 0 개수만큼 녹이기
				for(int i = 0; i < ice.size(); i++) {
					Ice n = ice.get(i);
					if(map[n.r][n.c] >= n.zeroCount)
						map[n.r][n.c] -= n.zeroCount;
					else map[n.r][n.c] = 0;
				}
				
				//카운트 올리기
				result++;
				
				
			}
			System.out.println(result);
		}
	}
	
	
	
	
	private static boolean zeroCheck() {
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				if(map[i][j] != 0)
					return true;
			}
		}
		return false;
	}




	//해당 좌표 주변에 0의 개수 카운트
	private static int count(int r, int c) {
		int count = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr,nc))
				continue;
			if(map[nr][nc] == 0)
				count++;
		}
		
		return count;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	private static boolean seperate() {

		boolean [][] visited = new boolean[N][M];
		int num = 0;
		
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				if(num == 2)
					return true;
				if(!visited[i][j] && map[i][j] != 0) {
					//방문 안했고 빙산이면 고
					visited[i][j] = true;
					go(i,j,visited);
					num++;
				}
			}
		}

		return false;
	}




	private static void go(int r, int c, boolean [][] visited) {
		
		
		for(int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc))
				continue;
			
			if(visited[nr][nc])
				continue;
			
			if(map[nr][nc] == 0)
				continue;
			
			visited[nr][nc] = true;
			go(nr, nc, visited);
		}
		
		
	}

}
class Ice{
	int r;
	int c;
	int zeroCount;
	public Ice(int r, int c, int zeroCount) {
		super();
		this.r = r;
		this.c = c;
		this.zeroCount = zeroCount;
	}
}
