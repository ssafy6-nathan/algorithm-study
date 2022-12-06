package w17_220621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9020_골드바흐의추측 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		// 이 문제에선 입력이 무조건 골드바흐 수
		// 4 ≤ n ≤ 10,000
		// 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
		// 즉, 10000보다 작은 모든 짝수는 골드바흐 수이며,
		// 2보다 큰 모든 짝수는 2개의 소수의 합으로 표현할 수 있다.

		// 소수 판별
		boolean[] primes = new boolean[10001];
		for (int i = 2; i <= 10000; i++) {
			if (isPrime(i)) {
				primes[i] = true;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			// primes[n] 절반에서부터 탐색해나갈 것이다.
			// n = ( n/2 + a ) + ( n/2 - a )
			int lg = n / 2;
			int sm = n / 2;
			while (true) {
				// 뭔가 잘못되고 있는 것 같긴 한데..
				// 큰 수, 작은 수 모두 소수일 때 출력
				if (primes[lg] && primes[sm]) {
					bw.write(sm + " " + lg + "\n");
//					System.out.println(sm + " " + lg);
					break;
				}
				lg++;
				sm--;
			}
		}
		bw.flush();
		bw.close();

	}

	private static boolean isPrime(int num) {
		// num은 2부터니까 1 안나옴
		for (int i = 2; i <= Math.sqrt(num); i++) {
			// 어떤 수의 제곱근인 수 필터링
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
