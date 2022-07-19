package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_5014_스타트링크 {

	static int F, S, G, U, D; //건물 높이, 강호위치, 목적지, 각 이동 칸 횟수
	static int [] cnt;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		G = Integer.parseInt(token.nextToken());
		U = Integer.parseInt(token.nextToken());
		D = Integer.parseInt(token.nextToken());
	
		//각 층에 대한 카운트 값을 넣을 예정
		cnt = new int[F+1];
		
		//현재 위치에서 U와 D 한번씩 해서 계속 큐에 넣고 목적지 도착하면 cnt값 나오게 하기
		bfs();
		
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(S);
		cnt[S] = 1;
		
		while(!que.isEmpty()) {
			
			int floor = que.poll();
			
			
			if(floor == G) {
				System.out.println(cnt[floor]-1);
				return;
			}
			
			//Up : 올라가려는 위치가 전체 높이이하여야 이동가능
			//간 적 없어야 갈 수 있음
			if(floor + U <= F && cnt[floor + U] == 0) {
				cnt[floor + U] = cnt[floor] + 1;
				que.add(floor + U);
			}
				
			//Down : 내려가려는 위치가 1층이상이어야 이동가능
			if(floor - D >= 1 && cnt[floor - D] == 0) {
				cnt[floor - D] = cnt[floor] + 1;
				que.add(floor - D);
			}
			
		}
		if(cnt[G] == 0)
		System.out.println("use the stairs");
		
	}

}
