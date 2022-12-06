package w16_220614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2529_부등호 {

	static int K;
	static char[] arr = new char[10];
	static boolean[] visited = new boolean[10];
	static List<String> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
    
		for (int i = 0; i < K; i++) {
			arr[i] = st.nextToken().charAt(0);
    }
    
		dfs("", 0);
		Collections.sort(ans);

		System.out.println(ans.get(ans.size() - 1));// max
		System.out.println(ans.get(0));// min
		br.close();
	}

	private static void dfs(String number, int index) {
		if (index == K + 1) {
			ans.add(number);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visited[i])
				continue;
			if (index == 0 || check(Character.getNumericValue(number.charAt(index - 1)), i, arr[index - 1])) {
				visited[i] = true;
				dfs(number + i, index + 1);
				visited[i] = false;
			}
		}
	}

	private static boolean check(int a, int b, char c) {
		if (c == '<') {
			if (a > b)
				return false;
		} else if (c == '>') {
			if (a < b)
				return false;
		}
		return true;
	}
}
