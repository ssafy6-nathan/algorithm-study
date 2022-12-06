import java.io.*;
import java.util.*;

public class Main_BOJ_3020_개똥벌레 {

	static int N, H;
	static int [] up;
	static int [] down;
	static int min;//최솟값
	static int count; //최솟값을 갖게 하는 구간들의 개수
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());
		
		up = new int[H+2];
		down = new int[H+2];
		
		for(int i = 0; i < N/2; i++) {
			int upId = Integer.parseInt(br.readLine());
			int downId = Integer.parseInt(br.readLine());
			up[upId]++;
			down[H-downId+1]++;
		}
		
		//각 높이에 대해서 누적합
		for (int i = 1; i <= H; i++) {
			up[i] += up[i-1];
		}
		
		for (int i = H; i >= 1; i--) {
			down[i] += down[i+1];
		}
		
		min = N;
		
		for(int i = 1; i <= H; i++) {

			//구간에 대한 카운트
			int upCnt = up[H]-up[i-1];
			int downCnt = down[1]-down[i+1];
			
			int totalCnt = upCnt + downCnt;
			
			if(totalCnt < min) {
				min = totalCnt;
				count = 1;
			}else if(totalCnt == min)
				count++;
			
		}
		System.out.println(min + " "+ count);
			
	}

}
