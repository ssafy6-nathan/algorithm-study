import java.io.*;
import java.util.*;

public class Main_BOJ_2981_검문 {

	static int N;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		for(int n = 0; n < N; n++) 
			arr[n] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int min = arr[1]; //6 36 216인 경우 고려
		
		for(int i = 2; i < min; i++) {
			
			int mod = arr[0] % i;
			boolean diff = false; //나머지가 다르면 true로 바뀜
			
			for(int n = 1; n < N; n++) {
				if(mod != arr[n] % i) { 
					diff = true;
					break;
				}
			}
			
			if(!diff)
				wr.write(i + " ");
		}
		
		wr.flush();
	}

}
