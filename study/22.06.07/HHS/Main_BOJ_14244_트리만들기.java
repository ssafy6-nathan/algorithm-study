import java.io.*;
import java.util.*;

public class Main_BOJ_14244_트리만들기 {

	static int N, M;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		for(int i = 0; i < M-1; i++) {
			int j = M-1;
			System.out.println(i + " "+ j);
		}
		for(int i = M-1; i < N-1; i++) {
			int j = i+1;
			System.out.println(i + " "+ j);
		}
		
	}

}
