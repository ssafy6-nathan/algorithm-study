import java.io.*;
import java.util.*;

public class Main_BOJ_1476_날짜계산 {

	static int E,S,M;
	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		//최대로 나올 수 있는 연도 = 7980 
		//1부터 돌면서 각 숫자 조건에 부합하는지 확인
		for(int i = 1; i <= 7980; i++ ) {
			if((E % 15 == i % 15) && (S % 28 == i % 28) && (M % 19 == i % 19)) {
				result = i;
				break;
			}
				
		}
		
		System.out.println(result);
		
	}

}
