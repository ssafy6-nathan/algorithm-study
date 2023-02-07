import java.io.*;
import java.util.*;

public class Main_BOJ_2502_떡먹는호랑이 {

	static int D;
	static int K;
	static int []A;
	static int []B;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		A = new int[D+1];
		B = new int[D+1];
		A[1] = 1;
		A[2] = 0;

		B[2] = 1;
		
		for (int i = 3; i <= D; i++) {
			A[i] = A[i-1] + A[i-2];
			B[i] = B[i-1] + B[i-2];
		}
		
		int a = 0;
		int b = 0;
		
		for (int i = 1; i <= K; i++) {
			int temp = K - (i * A[D]);
			//0으로 나누어떨어지면 b에 넣고 끝
			if(temp % B[D] == 0) {
				b = temp / B[D];
				a = i;
				break;
			}			
		}
		
		System.out.println(a);
		System.out.println(b);
		
	}

}
