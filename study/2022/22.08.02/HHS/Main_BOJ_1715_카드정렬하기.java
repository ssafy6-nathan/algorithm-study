import java.io.*;
import java.util.*;

public class Main_BOJ_1715_카드정렬하기 {

	static int N;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			que.add(Integer.parseInt(br.readLine()));
		}
		
		int answer = 0;
		//카드 한 뭉치일 경우
		if(que.size() == 1) {
			System.out.println(0);
			return;
		}
		while(!que.isEmpty()) {
			if(que.size()==1) {
				answer= que.poll();
				break;
				
			}else if(que.size()==2) {
				int a = que.poll();
				int b = que.poll();
				answer += a+b;
			}else {
				
				//두개씩 뽑아서 더하기
				int a = que.poll();
				int b = que.poll();
				answer += a+b;
				que.add(a+b);
			}
			
		}
		System.out.println(answer);
	}

}
