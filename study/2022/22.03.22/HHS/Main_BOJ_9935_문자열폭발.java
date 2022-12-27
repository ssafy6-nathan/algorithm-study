package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_9935_문자열폭발 {

	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String frula_str = br.readLine();
		int len = frula_str.length();
		Stack<Character> frula = new Stack<>();
		
		//문자열 스택에 넣으면서 폭발문자열과 비교
		//폭발 문자열 개수만큼 스택에 쌓이면 바로 비교 시작하기
		//boolean check로 같은 문자 나오면 비교, 끝까지 같으면 pop
		
		for (int i = 0; i < str.length(); i++) {
			frula.push(str.charAt(i));
			
			if(frula.size() >= len) {//비교할 수 있을 만큼 들어왔으니 비교시작
				boolean check = false;
				
				for (int j = 0; j < len; j++) {//뒤집기 귀찮으니 뒤부터 확인
					if(frula.get(frula.size()-1-j) != frula_str.charAt(len-1-j)) {
						//다르면 true로 하고 나가기
						check = true;
						break;
					}
				}
				if(!check) {
					for (int j = 0; j < len; j++) {
						frula.pop();
					}
				}
				
			}
		}
		
		if(frula.size() == 0) System.out.println("FRULA");
		else {
			for (int i = 0; i < frula.size(); i++) {
				sb.append(frula.get(i));
			}System.out.println(sb);
		}
		
	}

}
