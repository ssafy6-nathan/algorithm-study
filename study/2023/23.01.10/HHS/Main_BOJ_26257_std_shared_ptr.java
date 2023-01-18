import java.io.*;
import java.util.*;

public class Main_BOJ_26257_std_shared_ptr {

	static int N, M, Q;
	static int [] val;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null; 
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		Q = Integer.parseInt(token.nextToken());
		
		val = new int[M+1];
		
		for(int i = 1; i <= M; i++) {
			int num = Integer.parseInt(br.readLine());
			val[i] = num;
		}
		
		for(int i = 0; i < Q; i++) {
			token = new StringTokenizer(br.readLine());
			String str = token.nextToken();
			if(str.equals("assign")) {
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				
				val[x] = val[y];
			}
			else if(str.equals("swap")) {
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				
				int temp = val[x];
				val[x] = val[y];
				val[y] = temp;
			}
			else {
				int x = Integer.parseInt(token.nextToken());
				val[x] = 0;
			}
		}
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 1; i <= M; i++) {
			if(val[i] != 0) 
				set.add(val[i]);
		}
		
		bw.write(String.valueOf(set.size())+"\n");
		
		for(int i = 1; i <= N; i++) {
			if(set.contains(i))
				bw.write(String.valueOf(i)+"\n");
		}
		
		bw.close();
		
		
	}

}
