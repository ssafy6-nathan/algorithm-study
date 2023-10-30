package study.nathan_algo_study.week66;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 통증 (2)
 * 링크 : https://level.goorm.io/exam/195693/%ED%86%B5%EC%A6%9D-2/quiz/1
 */

public class Goorm195693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++) {
            if (i - A >= 0 && dp[i - A] != Integer.MAX_VALUE)
                dp[i] = Math.min(dp[i], dp[i - A] + 1);

            if (i - B >= 0 && dp[i - B] != Integer.MAX_VALUE)
                dp[i] = Math.min(dp[i], dp[i - B] + 1);
        }

        System.out.println(dp[N] != Integer.MAX_VALUE ? dp[N] : -1);
    }
}

/*

*/
