import java.io.*;
import java.util.*;

public class Main_BOJ_1339_단어수학 {

	static int N;
	static int answer;
	static char [][] map;
	static HashMap<Character, Integer> num;
	static HashSet<Character> alpha;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char [N][8];
		num = new HashMap<>();
		alpha = new HashSet<>();
		
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int i = str.length()-1; i >= 0; i--) {
				map[n][str.length()-1-i] = str.charAt(i);
				alpha.add(str.charAt(i));
			}
		}
		PriorityQueue<int []> que = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int [] o1, int []o2) {
				int num1 = o2[1] - o1[1];
				if(num1 == 0) return o1[0]-o2[0];
				return num1;
			}
		});
		
		for(Character key : alpha) {
			//포문을 큰 값부터 돌면서 각 알파벳에 대한 값들 string으로 넣고 8자리 다 채우면 큐에 넣기
			String total = "";
			for(int i = 7; i >= 0; i--) {
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					if(map[j][i] == key)
						cnt++;
				}
				total += cnt;
			}
			que.offer(new int[] {key-'A', Integer.parseInt(total)});
		}
		
		int number = 9;
		while(!que.isEmpty()) {
			int [] q = que.poll();
			if(num.containsKey((char) (q[0]+'A'))) continue;
			
			num.put((char) (q[0]+'A'), number);
			number--;
			
		}
		
		for(int i = 0; i < N; i++) {
			String cal = "";
			for(int j = 7; j >= 0; j--) {
				if(map[i][j] != 0) {
					cal += String.valueOf(num.get(map[i][j]));
				}
			}
			answer += Integer.parseInt(cal);
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
