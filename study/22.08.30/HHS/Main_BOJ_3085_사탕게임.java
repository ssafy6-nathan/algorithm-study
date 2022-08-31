import java.io.*;
import java.util.*;

public class Main_BOJ_3085_사탕게임 {

	static int N;
	static char [][] map;
	static int count=1;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//서로 인접한 부분이 다르면 바꾸고 카운트 세어보기
		//다시 복구해놓기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) {
				if(map[i][j] != map[i][j+1]) {
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					find();
					map[i][j+1] = map[i][j];
					map[i][j] = temp;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) {
				if(map[j][i] != map[j+1][i]) {
					char temp = map[j][i];
					map[j][i] = map[j+1][i];
					map[j+1][i] = temp;
					find();
					map[j+1][i] = map[j][i];
					map[j][i] = temp;
				}
			}
		}
		System.out.println(count);
		
	}

	private static void find() {

		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N-1; j++) {
				if(map[i][j] == map[i][j+1]) {
					cnt++;
				}else {
					cnt = 1;
				}
				count = Math.max(count, cnt);
			}
		}
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N-1; j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
				}else {
					cnt = 1;
				}
				count = Math.max(count, cnt);
			}
		}

		
	}

}
