import java.io.*;
import java.util.*;

public class Main_BOJ_4796_캠핑 {

	static int L, P, V;
	static int answer;
	static int T;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = 1;
		while(true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			L = Integer.parseInt(token.nextToken());
			P = Integer.parseInt(token.nextToken());
			V = Integer.parseInt(token.nextToken());
			if(L == 0) break;
			
			answer = Math.min(V % P, L) + V / P * L;
			
			bw.write("Case "+T+": "+String.valueOf(answer)+"\n");
			T++;
		}
		bw.close();
		
	}

}
