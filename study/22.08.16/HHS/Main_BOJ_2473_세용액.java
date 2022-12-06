import java.io.*;
import java.util.*;

public class Main_BOJ_2473_세용액 {

	static int N;
	static int [] numbers;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(numbers);
		
		//하나씩 찍고 나머지 두개 왔다갔다하면서 0에 가까워지는 순간들 체크해놓기
		//절댓값 계산 후 해당 값이 더 작다면 갱신
		int min = 0, mid = 0, max = 0;
		long result = Long.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			int start = i+1;
			int end = N-1;
			while(start < end) {
				long sum = (long) numbers[i] + numbers[start] + numbers[end];
				long abs = Math.abs(sum);
				if(result > abs) {
					result = abs;
					min = numbers[i];
					mid = numbers[start];
					max = numbers[end];
				}
				if(sum < 0)
					start++;
				else if(sum == 0)
					break;
				else
					end--;
				
			}
		}
		System.out.println(min + " "+ mid + " " + max);
		
	}
	
}
