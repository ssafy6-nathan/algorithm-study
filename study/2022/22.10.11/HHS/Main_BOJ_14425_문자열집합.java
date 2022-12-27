import java.io.*;
import java.util.*;

public class Main_BOJ_14425_문자열집합 {

	static int answer;
	static int N, M;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		HashSet<String> s = new HashSet<>();
		for(int i = 0; i < N; i++)
			s.add(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String m = br.readLine();
			if(s.contains(m))
				answer++;
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

}
