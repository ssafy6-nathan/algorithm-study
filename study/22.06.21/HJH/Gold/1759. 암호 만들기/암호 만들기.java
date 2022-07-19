package w17_220621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기 {
	static int C, L;
	static char[] list, code;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken()); // 4
		L = Integer.parseInt(st.nextToken()); // 6
		// 정렬
		list = new char[L];
		code = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(list);
		// 암호 생성
		generate(0, 0);
	}

	// generate code by Combination
	private static void generate(int start, int cnt) {
		// 종료 조건
		if (cnt == C) {
			if (isValid()) {
				System.out.println(code);
			}
			return;
		}
		for (int i = start; i < L; i++) {
			code[cnt] = list[i];
			generate(i + 1, cnt + 1);
		}
	}

	private static boolean isValid() {
		int m = 0; // 모음
		int j = 0; // 자음
		for (char i : code) {
			if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
				m++;
			} else
				j++;
		}
		if (m >= 1 && j >= 2) {
			return true;
		}
		return false;
	}
}
