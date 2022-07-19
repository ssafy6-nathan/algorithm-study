import java.io.*;
import java.util.*;

public class Main_BOJ_2003_수들의합2 {

	static int N, M;
	static int [] num;
	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		num = new int[N];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(token.nextToken());
		}
		//더했을 때 작으면 계속 더해
		//더했을 때 크면 앞에꺼 빼보기
		//더했을 때 같으면 결과값 올리기
		
		//끝에 왔을 때 더한게 M보다 작으면 가망없음
		//M보다 더 크면 앞에 계속 빼주면서 비교하면 됨
		int sum = 0;
		int start = 0;
		int end = 0;
		while(true) {
			if(end == N && sum < M) {
				break;
			}else if(sum < M) {
				sum += num[end];
				end++;
			}else if(sum >= M) {
				sum -= num[start];
				start++;
			}
			if(sum == M) {
				result++;
				sum -= num[start];
				start++;
			}
		}
		
		System.out.println(result);
		
		
	}

}
