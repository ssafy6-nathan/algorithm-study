import java.io.*;
import java.util.*;

public class Main_BOJ_1940_주몽 {

	static int N, M;
	static int count;
	static HashSet<Integer> Armor;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		Armor = new HashSet<>();
		
		for (int i = 0; i < N; i++) {

			int cloth = Integer.parseInt(token.nextToken());
			
			if(Armor.contains(cloth)) {
				count++;
			}else {
				Armor.add(M-cloth);
			}			
		}
		
		System.out.println(count);
	}

	
}
