// 1254 팰린드롬 만들기
// https://velog.io/@hailey_/BOJ-1254-%ED%8C%B0%EB%A6%B0%EB%93%9C%EB%A1%AC-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(solution(br.readLine()));
	}
	public static int solution(String s) {
		for(int i=0; i<s.length(); i++) {
        	if(isPalindrome(s, i, s.length()-1))
        		return i+s.length();
        }
        return 1;
    }
	public static boolean isPalindrome(String string, int p, int q) {
		while (p < q) {
	    	if (string.charAt(p++) != string.charAt(q--))
		    	return false;
	    }
    	return true;
	}
}