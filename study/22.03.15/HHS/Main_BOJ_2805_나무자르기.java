package study_Nathan;

//whyrano...

import java.io.*;
import java.util.*;

public class Main_BOJ_2805_나무자르기 {

	static int N, M;
	static int[] tree;
	static int high;
	static int low;
	static int result;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		tree = new int[N];
		
		token = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(token.nextToken());
			high = Math.max(tree[i], high);
			
		}
		
		//나무 중간 잘라서 그어보고
		//합 더해보고 모자르면 자르는 지점 반 더 내리기
		//합 넘으면 최저 올라가면서 자를 수 있는 높이 최댓값 구하기
		
		int cut = 0;
		while(low < high) {
			
			cut = (low + high) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if(tree[i] > cut) sum += tree[i]-cut;
			}
			
			if(sum < M) {//모자르면 최고 높이 반 낮춰서 자르는 곳 낮춰
				high = cut;
			}
			else if(sum > M) {//넘으면 최저 올려서 자르는 곳 높여보기
				low = cut + 1;
			}
			else {
				System.out.println(cut);
				return;
			}
			
		}
		System.out.println(cut);
		
		
	}

}
