import java.io.*;
import java.util.*;

public class Main_BOJ_1138_한줄로서기 {

	static int N;
	static int [] nums;
	static int [] answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		answer = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(token.nextToken());
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(cnt == nums[i]) {
					while(answer[j]!=0)
						j++;
					answer[j] = i+1;
					break;
				}
				if(answer[j] > i+1 || answer[j] == 0) {
					cnt++;
					
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(String.valueOf(answer[i])+" ");
		}
		bw.close();
	}


}
