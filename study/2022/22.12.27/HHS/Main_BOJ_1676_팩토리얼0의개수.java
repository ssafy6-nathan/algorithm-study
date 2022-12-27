import java.io.*;

public class Main_BOJ_1676_팩토리얼0의개수 {

	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			if(i % 5 == 0)
				count(i);
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		
	}

	private static void count(int i) {
		
		while(true) {
			if(i % 5 != 0) break;
			i /= 5;
			answer++;
		}
	}

}
