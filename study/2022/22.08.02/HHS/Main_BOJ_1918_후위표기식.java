import java.io.*;
import java.util.*;

public class Main_BOJ_1918_후위표기식 {

	static char[] cal;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cal = br.readLine().toCharArray();
		
		// 알파벳이면 걍 바로 출력
		// (면 일단 담고 ) 나오면 ( 나올때까지 계속 빼기
		// 현재 연산자보다 스택에 있는 연산자가 더 우선순위 높으면 걔네 먼저 출력
		// +- -> 1, */ -> 2, () -> 0
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < cal.length; i++) {
			if(cal[i] >= 'A' && cal[i] <= 'Z' ) {
				sb.append(cal[i]);
			}
			else if(cal[i] == '(') {
				stack.push(cal[i]);
			}else if(cal[i] == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}else {
				while(!stack.isEmpty() && rank(stack.peek()) >= rank(cal[i])) {
					sb.append(stack.pop());
				}
				stack.push(cal[i]);
			}
		}
		
		//남은애들 다 뽑기
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}

	private static int rank(Character temp) {
		if(temp == '*' || temp == '/') return 2;
		else if(temp == '+' || temp == '-') return 1;
		return 0;
	}

}
