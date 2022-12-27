
import java.io.*;
import java.util.*;

public class Main_BOJ_1932_정수삼각형 {

	static int N;
	static int [][] nums;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer token = null;
		nums = new int[N][];
		for(int i = 1; i <= N; i++) {
			nums[i-1] = new int[i];
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++) {
				nums[i-1][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		//테두리는 그대로 냅두고 안에 있는 애들만 계산해주기
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i+1; j++) {
				if(j == 0)
					nums[i][j] += nums[i-1][j];
				else if(j == i)
					nums[i][j] += nums[i-1][j-1];
				else
					nums[i][j] += Math.max(nums[i-1][j-1], nums[i-1][j]);
			}
		}
		
		int answer = 0;
		for(int j = 0; j < N; j++) {
			answer = Math.max(nums[N-1][j], answer);
		}
		System.out.println(answer);
	}

}
