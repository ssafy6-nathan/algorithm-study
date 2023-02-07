import java.util.*;
import java.io.*;

public class Main_BOJ_11723_집합 {

	static int T;
	static int s;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {

			StringTokenizer token = new StringTokenizer(br.readLine());
			String str = token.nextToken();
			
			if(str.equals("add")){
				int x = Integer.parseInt(token.nextToken());
				s |= (1 << x);
				
			}else if(str.equals("remove")) {
				int x = Integer.parseInt(token.nextToken());
				s &= ~(1 << x);
				
			}else if(str.equals("check")) {
				int x = Integer.parseInt(token.nextToken());
				sb.append((s & (1 << x)) != 0 ? 1 : 0);
				sb.append("\n");
				
			}else if(str.equals("toggle")) {
				int x = Integer.parseInt(token.nextToken());
				s ^= (1 << x);
				
			}else if(str.equals("all")) {
				s = (1 << 21) -1;
			}else {
				s = 0;
			}
		}
		System.out.println(sb.toString());
		
	}

}
