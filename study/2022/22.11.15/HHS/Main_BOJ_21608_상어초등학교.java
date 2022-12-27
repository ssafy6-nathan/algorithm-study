import java.io.*;
import java.util.*;

public class Main_BOJ_21608_상어초등학교 {

	static int N;
	static int [][] map;
	static boolean [][] friends;
	static int T;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		T = N*N;
		friends = new boolean[T+1][T+1];
		
		for(int t = 0; t < T; t++) {
			token = new StringTokenizer(br.readLine());
			int stu = Integer.parseInt(token.nextToken());
			for(int i = 0; i < 4; i++)
				friends[stu][Integer.parseInt(token.nextToken())] = true;
			
			ArrayList<Place> place = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != 0) continue;
					//사방탐색 후 친구와 빈칸 수 넣기
					int blank = 0;
					int friend = 0;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(!check(nr, nc)) continue;
						if(map[nr][nc] == 0) blank++;
						else if(friends[stu][map[nr][nc]]) friend++;
					}
					place.add(new Place(i, j, blank, friend));
				}
			}
			
			Collections.sort(place);
			map[place.get(0).r][place.get(0).c] = stu;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = map[i][j];
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(!check(nr, nc)) continue;
					if(friends[num][map[nr][nc]]) cnt++;
				}
				if(cnt > 0) answer += Math.pow(10, cnt-1);
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
class Place implements Comparable<Place>{
	int r;
	int c;
	int blank;
	int friend;
	public Place(int r, int c, int blank, int friend) {
		super();
		this.r = r;
		this.c = c;
		this.blank = blank;
		this.friend = friend;
	}
	@Override
	public int compareTo(Place o) {
		int f = o.friend - this.friend;
		if(f == 0) {
			int b = o.blank - this.blank;
			if(b == 0) {
				int diffR = this.r - o.r;
				if(diffR == 0)
					return this.c - o.c;
				
				else return diffR;
			}else return b;
		}else return f;
	}
}
