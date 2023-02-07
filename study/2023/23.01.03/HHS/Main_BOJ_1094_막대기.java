import java.io.*;

public class Main_BOJ_1094_막대기 {

	static int len;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		len = Integer.parseInt(br.readLine());
		
		//이진수로 만들고 1의 개수 보면 됨
		while(len > 0) {
			answer += len % 2;
			len /= 2;
		}
		
		System.out.println(answer);
		
	}

}
