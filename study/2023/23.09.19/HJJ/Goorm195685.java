package study.nathan_algo_study.week65;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 합 계산기
 * 링크 : https://level.goorm.io/exam/195685/%ED%95%A9-%EA%B3%84%EC%82%B0%EA%B8%B0/quiz/1
 */

public class Goorm195685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            char op = st.nextToken().charAt(0);
            int n2 = Integer.parseInt(st.nextToken());
            switch (op) {
                case '+':
                    result += n1 + n2;
                    break;
                case '-':
                    result += n1 - n2;
                    break;
                case '*':
                    result += n1 * n2;
                    break;
                case '/':
                    result += n1 / n2;
                    break;
            }
        }

        System.out.println(result);
    }
}

/*

*/
