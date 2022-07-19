import java.io.*;
import java.util.*;

public class Main_BOJ_10972_다음순열 {

	static int N;
	static int [] number;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		number = new int[N];
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			number[i] = Integer.parseInt(token.nextToken());
		
		//nextPermutation써서 다음 넘버 출력
		//해당 넘버가 맨 마지막이면 -1 출력
			
		if(nextPerm()) {
			for(int i = 0; i < N; i++)
				System.out.print(number[i] +  " ");
		}else
			System.out.println(-1);
		
		
	}
	public static boolean nextPerm() {
		int i = N-1;
		
		while(i > 0 && number[i-1] > number[i])
			i--;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(number[i-1] >= number[j])
			j--;
		
		int temp = number[i-1];
		number[i-1] = number[j];
		number[j] = temp;
		
		int k = N-1;
		while(i < k) {
			temp = number[i];
			number[i] = number[k];
			number[k] = temp;
			i++;
			k--;
		}
		return true;
		
	}

}
