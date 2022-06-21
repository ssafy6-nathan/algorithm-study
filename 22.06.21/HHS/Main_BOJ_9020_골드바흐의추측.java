import java.io.*;
import java.util.*;

public class Main_BOJ_9020_골드바흐의추측 {

	static int T;
	static int num;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			num = Integer.parseInt(br.readLine());
			
			for(int i = num/2; i >= 2; i--) {
				int j = num-i;
				if(gold(i) && gold(j)) {
					System.out.println(i + " "+ j);
					break;
				}
			}
			
		}
		
	}

	//소수인지 판별 -> 해당 값의 루트씌운 것까지 돌리며 나눠지는지 확인
	private static boolean gold(int number) {
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0 && number != i) return false;
		}
		
		return true;
	}

}
