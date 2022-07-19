import java.io.*;
import java.util.*;

//테스트케이스와 여러 반례들 통과했으나 시간초과

public class Main_BOJ_1254_팰린드롬만들기 {

	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] palindrome = br.readLine().toCharArray();

		int last = palindrome.length;
		
		int palin_start = -1;
		int i = 0;
		int j = last-1;
		boolean check = false;
				
		while(true) {
			if(i >= j) break;
			if(palindrome[i] != palindrome[j]) {
				check = false;
				j = last-1;
				if(palin_start != -1) {
					i = palin_start +1;
				}
				else {
					i++;
				}
			}
			else{
				if(!check) {		
					check = true;
					palin_start = i;
				}
				i++;
				j--;
			}
		}

		if(check) result = last+palin_start;
		else result = last*2-1;
		
		if(result == -1) result = 0;
		System.out.println(result);
		
	}

}
