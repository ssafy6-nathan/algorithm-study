import java.io.*;
import java.util.*;

public class Main_BOJ_4779_칸토어집합 {

	static int N;
	static char [] answer;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = "";
		while((str = br.readLine()) != null) {
			N = Integer.parseInt(str);
			
			int len = (int) Math.pow(3, N);
			
			answer = new char[len];
			Arrays.fill(answer, ' ');
			
			dfs(0, len-1, len); //시작점, 끝점, 길이
			
			for(int i = 0; i < len; i++)
				bw.write(answer[i]);
			bw.write("\n");
			bw.flush();
			
		}
		bw.close();
		
	}
	private static void dfs(int s, int e, int size) {
		if(size == 1) {
			answer[s] = '-';
			return;
		}
		
		dfs(s, s+ size/3 -1, size/3);
		dfs(e - size/3 +1, e, size/3);
		
	}

}
