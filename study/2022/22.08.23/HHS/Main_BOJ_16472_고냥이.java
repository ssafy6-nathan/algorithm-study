import java.io.*;
import java.util.*;

public class Main_BOJ_16472_고냥이 {

	static int N;
	static char[] words;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		words = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			words[i] = str.charAt(i);
		}
//		for(int i = 0; i < words.length; i++) {
//			HashSet<Character> map = new HashSet<>();
//			for(int j = i; j < words.length; j++) {
//				map.add(words[j]);
//				if(map.size() > N) {
//					answer = Math.max(answer, j-i);
//					break;
//				}
//			}
//		}
		int [] alpha = new int[26];
		
		int answer = 0;
		int start = 0;
		int end = 0;
		int cnt = 1;
		alpha[words[0]-'a']++;
		
		while(start <= end) {
			end++;
			
			if(end == str.length())
				break;
			
			char n = words[end];
			alpha[n-'a']++;
			
			if(alpha[n - 'a'] == 1)
				cnt++;
			
		
			while(cnt > N){
				char p = words[start];
				alpha[p-'a']--;
				
				if(alpha[p-'a'] == 0)
					cnt--;
				start++;
			}
			
			
			
			answer = Math.max(answer, end-start+1);
			
		}
		
		System.out.println(answer);
		
		
	}

}
