import java.io.*;
import java.util.*;

public class Main_BOJ_2023_신기한소수 {

	static int N;
	static int count;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		result = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		count = 0;
		Prime(count, 0);
		
		Collections.sort(result);
		for(int res : result)
			System.out.println(res);
		
		
		
	}

	private static void Prime(int cnt, int num) {
		if(cnt == N) {
			result.add(num);
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			int temp = num * 10 + i;
			if(isPrime(temp))
				Prime(cnt+1, temp);
		}
		
	}

	private static boolean isPrime(int num) {
		if(num == 1) return false;
		if(num == 2) return true;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}

}
