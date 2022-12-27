package w16_220614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken()); // 15
		int S = Integer.parseInt(st.nextToken()); // 28
		int M = Integer.parseInt(st.nextToken()); // 19
		int e = 0, s = 0, m = 0, year = 0;

		while (true) {
			year++;
			e++; s++; m++;
			if (e == 16)
				e = 1;
			if (s == 29)
				s = 1;
			if (m == 20)
				m = 1;
			if (e == E && m == M && S == s) {
				break;
			}
		}
		System.out.print(year);
	}
}
