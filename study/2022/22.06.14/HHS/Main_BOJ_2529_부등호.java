
import java.io.*;
import java.util.*;

public class Main_BOJ_2529_부등호 {

	static int K;
	static char [] comp;
	static boolean [] visited;
	static ArrayList<String> result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		result = new ArrayList<>();
		comp = new char[K];
		visited = new boolean[10];
		String str = br.readLine();
		int a = 0;
		for(int i = 0; i < str.length(); i = i+2) {
			comp[a++] = str.charAt(i);
		}
		
//		System.out.print(Arrays.toString(comp));
		// dfs 돌면서 값 비교할예정
		//comp[i]가 < 이면 그 전 숫자보다 큰 것이 오면 통과
		dfs("", 0);
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
	}

	private static void dfs(String numbers, int count) {
		if(count == K+1) {
			result.add(numbers);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			//처음에는 걍 넣고, 그 이후에는 방문 했던 숫자인지, numbers맨 마지막 숫자와 부등호판별 확인후 dfs 돌리기
			int len = numbers.length()-1;
			if((count == 0) || ( !visited[i] && check(numbers.charAt(len)-'0', comp[len], i) )) {
				visited[i] = true;
				dfs(numbers+i, count+1);
				visited[i] = false;
			}
		}
		
		
	}

	private static boolean check(int num, char compare, int nextNum) {
		if(compare == '<' && num < nextNum) 
			return true;
		else if(compare == '>' && num > nextNum)
			return true;
		return false;
	}

}
