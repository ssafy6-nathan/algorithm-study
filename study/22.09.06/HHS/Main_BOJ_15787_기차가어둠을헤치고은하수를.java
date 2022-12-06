import java.io.*;
import java.util.*;

public class Main_BOJ_15787_기차가어둠을헤치고은하수를 {

	static int [] arr;
	static int M;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		arr = new int [Integer.parseInt(str[0])+1];
		M = Integer.parseInt(str[1]);
		
		for(int i = 0; i < M; i++) {
			
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int train = Integer.parseInt(s[1]);
			
			if(n == 1) {
				int x = Integer.parseInt(s[2])-1;
				arr[train] |= (1 << x);
			}else if(n == 2) {
				int x = Integer.parseInt(s[2])-1;
				arr[train] &= ~(1 << x);
			}else if(n == 3) {
				arr[train] = arr[train] << 1;
				arr[train] &= (1 << 20) -1;
			}else 
				arr[train] = arr[train] >> 1;
			
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i < arr.length; i++) {
			set.add(arr[i]);
			System.out.println(arr[i]);
		}
		System.out.println(set.size());
	}

}
