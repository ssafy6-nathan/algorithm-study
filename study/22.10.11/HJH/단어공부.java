import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase(); // 대소문자 구분 X
        int[] alp = new int[26];
        for(int i=0; i < str.length(); i++) {
            ++alp[str.charAt(i) -'A'];
        }
        int max = 0;
		char result = '?';
		for(int i=0; i < alp.length; i++) {
			if(max < alp[i]) {
				max = alp[i];
				result = (char) (i+'A');
			} else if(max == alp[i]) {
				result = '?';
			}
		}
		br.close();
		System.out.printf("%s", result);
    }
}
