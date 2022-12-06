import java.io.*;
import java.util.*;

public class Main_BOJ_4949_균형잡힌세상 {
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		while(str.charAt(0) != '.') {
			Stack<Character> stack = new Stack<>();
			String answer = "yes";
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				}else if(c == ')' || c == ']') {
					if(stack.isEmpty()) {
						answer = "no";
						break;
					}else {
						if((c == ']' && stack.peek() == '[') || (c == ')'&& stack.peek() == '(')) {
							stack.pop();
						}else {
							answer = "no";
							break;
						}
					}
				}
			}
			if(!stack.isEmpty()) answer = "no";
			bw.write(answer + "\n");
			str = br.readLine();
		}
		bw.flush();
		bw.close();
		
		
	}

}
