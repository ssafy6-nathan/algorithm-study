import java.io.*;
import java.util.*;

public class Main_BOJ_4948_베르트랑공준 {

	static int N;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0)
				return;
			
			int count = 0;
			if(N == 1) count = 1;
			else {
				for(int i = N+1; i < 2*N; i++) {
					if(isPrime(i))
						count++;
				}
			}
			System.out.println(count);
			
		}
		
	}

	private static boolean isPrime(int num) {
		if(num == 2) return true;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
		
	}

}
