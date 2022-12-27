import java.io.*;
import java.util.*;

public class Main_BOJ_5430_AC {

	static int T;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String str = br.readLine(); //명령어
			int N = Integer.parseInt(br.readLine());//배열 크기
			String answer ="";
			StringBuilder sb = new StringBuilder();
							
			String numArr = br.readLine();
			String[] arr = numArr.substring(1, numArr.length()-1).split(",");
			Deque<Integer> que = new ArrayDeque<>();
			for(int i = 0; i < N; i++) {
				que.offer(Integer.parseInt(arr[i]));
			}
			
			boolean check = true; //true면 앞, false면 뒤
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'R') {
					check = !check;
				}else {
					if(que.size() > 0) {
						if(check) que.poll();
						else que.pollLast();
					}
					else {
						answer = "error";
						break;
					}
				}
			}
			
			if(!answer.equals("error")) {
				sb.append('[');
				if(que.size() > 0) {	
					if(check) {
						sb.append(que.pollFirst());
						while(!que.isEmpty()) 
							sb.append(',').append(que.pollFirst());
					}else {
						sb.append(que.pollLast());
						while(!que.isEmpty())
							sb.append(',').append(que.pollLast());
					}
				}
				sb.append(']');
				answer = sb.toString();
			}
			bw.write(answer+"\n");
			bw.flush();
		}
		bw.close();
		
		
	}

}
