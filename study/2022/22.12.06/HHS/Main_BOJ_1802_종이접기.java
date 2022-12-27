import java.io.*;

public class Main_BOJ_1802_종이접기 {

	static int T;
	static String str;
	static String answer;
	static boolean check;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			str = br.readLine();
			int N = str.length();
			check = true;
			answer = "YES";
			
			dfs(0,N-1, N); // 시작, 끝, 총 길이
				
			if(!check) answer = "NO";
			
			bw.write(answer+"\n");
		}
		bw.close();
		
		
		
	}

	private static void dfs(int s, int e, int size) {

		if(size == 1) return;
		int m = (s + e) / 2;
		int a = s;
		int b = e;
		while(a < b) {
			if(str.charAt(a) == str.charAt(b)) {
				check = false;
				break;
			}
			a++;
			b--;
		}
		if(!check) return;
		dfs(s, m-1, size/2);
		dfs(m+1, e, size/2);
		
	}

}
