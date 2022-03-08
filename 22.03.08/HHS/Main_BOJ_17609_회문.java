package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_17609_회문 {

	static int T;
	static char[] palindrome;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			palindrome = br.readLine().toCharArray();
			
			//앞과 뒤를 비교하면서 같으면 앞은 하나씩 뒤로 넘어가고 뒤는 앞으로 하나씩 인덱스 이동
			//만약 다르면 인덱스 움직여보고 카운트 올리기
			//앞부터 움직이는 방법, 뒤부터 움직이는 방법 두개 돌려서 카운트 작은걸로 가져가기
			// 카운트가 0이면 회문, 1이면 유사회문, 2이상이면 일반 문자열
			//카운트 올리는 도중에 2가 되면 그냥 break하고 2 출력
			
			int front = 0;
			int back = palindrome.length-1;
			int count = 0;
			
			System.out.println(isDiff(front, back, 0));
			
			
			
		}
		
	}

	private static int isDiff(int front, int back, int count) {
		
		if(count == 2) { 
			return count;
		}
		
		while(front < back) {
			
			if(palindrome[front] != palindrome[back]) { //조회하다가 다른 부분이 나오면
				count++;
					
				int frontCount = isDiff(front+1, back, count); //앞 인덱스 움직
				int backCount = isDiff(front, back-1, count); //뒤 인덱스 움직
					
				count = Math.min(frontCount, backCount); //두 방법 비교해서 작은걸로 가져가기
					
				break;
			}
			
			front ++;
			back --;
			
		}
		return count;
	}
	
	
}
