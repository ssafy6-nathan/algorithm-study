import java.io.*;
import java.util.*;

public class Main_BOJ_1052_물병 {

	static int N, K;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		int init = N;
		
		//1씩 더하면서 X%2 == 1 들의 개수 <= K이면 멈추기
		while(true) {
			
			int count = 0;
			
			//일단 2로 나누며 나머지 1인 애들의 개수 알아보기
			int temp = N;
			while(temp > 0) {
				if(temp % 2 == 1)
					count++;
				temp /= 2;
			}
			
			if(count <= K)
				break;
			
			N++;
		}
		System.out.println(N-init);
	}

}
