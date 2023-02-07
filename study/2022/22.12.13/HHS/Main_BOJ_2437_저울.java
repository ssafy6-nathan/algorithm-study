import java.io.*;
import java.util.*;

public class Main_BOJ_2437_저울 {

	static int N;
	static int answer;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			if(arr[i] > answer + 1)
				break;
			answer += arr[i];
		}
		
		bw.write(String.valueOf(answer + 1));
		bw.close();
		
	}

}
