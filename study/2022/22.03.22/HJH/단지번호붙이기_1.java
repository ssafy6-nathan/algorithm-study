import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	static int N, map[][];
	static int[] dr= {-1, 1, 0, 0};
	static int[] dc = {0,0,-1,1};
	static int count = 1;
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(input[j]);
			}
		}
		
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count-1);
		int result[] = new int[count];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
					if(map[i][j] != 0)
						result[map[i][j]]++;
	    	}
	    }
		Arrays.sort(result);
        for(int i=1; i<result.length; i++) {
            System.out.println(result[i]);
        }
	}

	public static void dfs(int r, int c) {
		map[r][c] = count; //방문한 집 표시
		visit[r][c] = true;
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if(map[nr][nc] == 1 && !visit[nr][nc]) { // 집이 있으면서 방문하지 않은 곳
                    dfs(nr, nc); // 연결 되어있는 단지 탐색
                }
            }
        }
	}

}
