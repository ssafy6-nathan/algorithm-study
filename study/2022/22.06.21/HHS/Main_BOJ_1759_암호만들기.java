import java.io.*;
import java.util.*;

public class Main_BOJ_1759_암호만들기 {

	static int L, C;
	static char [] word;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		
		word = new char[C];
		
		String words = br.readLine();
		for(int i = 0, a = 0; i < C; i++, a=a+2) {
			word[i] = words.charAt(a);
		}

		Arrays.sort(word);
		
		Comb(0, 0, new char[L]);
		
	}

	private static void Comb(int start, int cnt, char[] nums) {
	
		if(cnt == L) {
			check(nums);
			return;
		}
		for(int i = start; i < C; i++) {
			nums[cnt] = word[i];
			Comb(i+1, cnt+1, nums);
		}
	}

	private static void check(char[] nums) {

		int m = 0;
		int j = 0;
		
		for(int i = 0; i < L; i++) {
			if(nums[i] == 'a' || nums[i] == 'e'|| nums[i] == 'i'
					|| nums[i] == 'o' || nums[i] == 'u')
				m++;
			else
				j++;
		}
		if(m >= 1 && j >= 2){
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]);
			}System.out.println();
		}
	}

}
