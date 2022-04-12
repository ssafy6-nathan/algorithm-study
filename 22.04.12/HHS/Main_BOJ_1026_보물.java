package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_1026_보물 {

	static int N;
	static int [] A;
	static int [] B;
	static int result;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token;
		
		N = Integer.parseInt(br.readLine());
		
		A = new int [N];
		B = new int [N];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(token.nextToken());
		}//A, B 입력완료
		
		//A는 재배열이 가능하고 B는 재배열이 불가하다고 되어있으나 연산 규칙은 같음
		//결론적으로 봤을 때는 둘다 재배열을 해도 무방
		
		//A는 오름차순 재배열, B는 내림차순 재배열
		
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0; i < N/2; i++) {
			int temp = B[i];
			B[i] = B[N-i-1];
			B[N-i-1] = temp;
		}
		
		for (int i = 0; i < N; i++) {
			int multiply = 0;
			multiply = A[i] * B[i];
			result += multiply;
		}
		
		System.out.println(result);
	}

}
