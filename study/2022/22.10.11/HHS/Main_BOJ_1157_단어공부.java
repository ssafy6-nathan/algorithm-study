import java.io.*;

public class Main_BOJ_1157_단어공부 {

	static char answer;
	static int Max;
	static int [] alpha;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine().toUpperCase();
		alpha = new int[26];
		for(int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			alpha[a-'A']++;
			if(Max < alpha[a-'A']) {
				Max = alpha[a-'A'];
				answer = a;
			}else if(Max == alpha[a-'A'])
				answer = '?';
		}
		bw.write(answer);
		bw.flush();
		bw.close();
	}

}
