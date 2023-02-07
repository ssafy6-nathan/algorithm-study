
import java.io.*;
import java.util.*;

public class Main_BOJ_17074_정렬 {

	static int N;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < N-1; i++) {
			if(arr[i] > arr[i+1]) {
				flag = true;
				if(i-1 >= 0 && i+1 < N && arr[i-1] <= arr[i+1]) {
					count++;
				}
				else if(i-1 >= 0 && i+1 < N && arr[i-1] > arr[i+1]) {
					count = 0;
					break;
				}
				if((i+2 < N && arr[i] <= arr[i+2]) || i+1 == N-1) {
					count++;
				}
				else if(i+2 < N && arr[i] > arr[i+2]) {
					count = 0;
					break;
				}
			}
		}
		
		if(!flag) System.out.println(N);
		else System.out.println(count);
	}

}
