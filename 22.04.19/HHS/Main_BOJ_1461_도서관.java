package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_1461_도서관 {
		
	static int N, M;
	static ArrayList<Integer> plus;
	static ArrayList<Integer> minus;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		plus = new ArrayList<Integer>();
		minus = new ArrayList<Integer>();
		
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
				
		token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(token.nextToken());
			
			if(num > 0) 
				plus.add(num);
			else 
				minus.add(Math.abs(num));
			
		}
		
		//양수와 음수 따로 관리
		int plusM = 0;
		int minusM = 0;
		
		//둘 중 어느 쪽이 더 0에서 멀리 있는지 비교하고
		//멀리 있는 쪽을 맨 마지막에 다시 돌아오지 않아도 되는 길로 표시
		if(plus.size() > 0) {
			Collections.sort(plus);
			plusM = plus.get(plus.size()-1);
		}
		
		if(minus.size() > 0) {
			Collections.sort(minus);
			minusM = minus.get(minus.size()-1);
		}
		
		int result1, result2 = 0;
		if(plusM >= minusM) {
			result1 = delivery(plus, true);
			result2 = delivery(minus, false);
		}else {
			result1 = delivery(plus, false);
			result2 = delivery(minus, true);
		}

		System.out.println(result1 + result2);
	}

	private static int delivery(ArrayList<Integer> books, Boolean far) {
		
		int sum = 0;
		
		//맨 마지막에 그냥 다시 돌아가지 않아도 된다면 제일 큰 거리 한 번 빼주기
		for(int i = 0; i < books.size()/M; i++) {
			sum += (books.get((books.size()-1) - M*i) * 2);
		}
		if(far)
			sum -= books.get(books.size()-1);
		
		if(books.size()%M != 0) {
			sum += books.get(books.size()%M -1) * 2;
		}
		
		return sum;
	}

}
