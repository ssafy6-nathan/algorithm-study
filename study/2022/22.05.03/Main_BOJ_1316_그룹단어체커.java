
import java.util.*;
import java.io.*;

public class Main_BOJ_1316_그룹단어체커 {

	static int N;
	static ArrayList<Character> alpha;
	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			alpha = new ArrayList<Character>();
			boolean check = false;
			//alpha에 각각 받아서 넣을 때마다 배열에 있는지 확인
			//alpha에 없는 알파벳이면 넣어주기
			//alpha에 있는 알파벳이면 가장 마지막에 있는 인덱스인지 확인
			//가장 마지막 인덱스값과 현재 들어온 값이 다르면 break하고 다음 단어로 넘어가기
			for(int j = 0; j < word.length(); j++) {
				if(check) break;
				for (int array = 0; array < alpha.size(); array++) {
					if(word.charAt(j) == alpha.get(array) && word.charAt(j) != alpha.get(alpha.size()-1)) {
						check = true;
						break;
					}
				}
				if(!check)alpha.add(word.charAt(j));
			}
			if(!check) result++;
			
		}
		System.out.println(result);
	}

}
