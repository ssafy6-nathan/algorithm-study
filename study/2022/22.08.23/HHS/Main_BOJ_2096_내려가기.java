import java.io.*;
import java.util.*;

public class Main_BOJ_2096_내려가기 {

	static int N;
	static int [][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		int [][] dpMax = new int[2][3];
		int [][] dpMin = new int[2][3];
		StringTokenizer token = null;
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		for(int i = 0; i < 3; i++) {
			dpMax[0][i] = map[0][i];
			dpMin[0][i] = map[0][i];			
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					dpMax[i%2][j] = Math.max(dpMax[(i-1)%2][j], dpMax[(i-1)%2][j+1]) + map[i][j];
					dpMin[i%2][j] = Math.min(dpMin[(i-1)%2][j], dpMin[(i-1)%2][j+1]) + map[i][j];
				}else if(j == 1) {
					dpMax[i%2][j] = Math.max(Math.max(dpMax[(i-1)%2][j], dpMax[(i-1)%2][j-1]), dpMax[(i-1)%2][j+1]) + map[i][j];
					dpMin[i%2][j] = Math.min(Math.min(dpMin[(i-1)%2][j], dpMin[(i-1)%2][j-1]), dpMin[(i-1)%2][j+1]) + map[i][j];
				}else {
					dpMax[i%2][j] = Math.max(dpMax[(i-1)%2][j], dpMax[(i-1)%2][j-1]) + map[i][j];
					dpMin[i%2][j] = Math.min(dpMin[(i-1)%2][j], dpMin[(i-1)%2][j-1]) + map[i][j];
				}
					
			}
		}
		
		int Max = Math.max(dpMax[(N-1)%2][0], Math.max(dpMax[(N-1)%2][1], dpMax[(N-1)%2][2]));
		int Min = Math.min(dpMin[(N-1)%2][0], Math.min(dpMin[(N-1)%2][1], dpMin[(N-1)%2][2]));
		System.out.println(Max + " "+ Min);
	}

}
