package w15_220607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14426접두사찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] S = new String[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.equals(S[j].substring(0, str.length()))) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
