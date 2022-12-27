import java.io.*;
import java.util.*;

public class Solution_10726_이진수표현 {

	static int T, N, M;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			int cnt = 0;
			boolean check = false;
			while(cnt < N) {
				
				if(M % 2 == 0) {
					sb.append("#"+t+" OFF").append("\n");
					check = true;
					break;
				}
				M /= 2;
				cnt++;
			}
			if(!check)
				sb.append("#"+t+" ON").append("\n");
			
		}
		System.out.println(sb.toString());
		
	}

}
