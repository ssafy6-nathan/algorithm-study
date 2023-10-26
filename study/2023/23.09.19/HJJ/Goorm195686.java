package study.nathan_algo_study.week65;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 완벽한 햄버거 만들기
 * 링크 : https://level.goorm.io/exam/195686/%EC%99%84%EB%B2%BD%ED%95%9C-%ED%96%84%EB%B2%84%EA%B1%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0/quiz/1
 */

public class Goorm195686 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = 0;
        int maxIdx = -1;
        for (int i = 0; i < N; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }

            sum += arr[i];
        }

        int prev = arr[maxIdx];
        boolean isDown = true;
        //감소하는 부분
        for (int i = maxIdx - 1; i >= 0; i--) {
            if (prev < arr[i]) {
                isDown = false;
                break;
            }

            prev = arr[i];
        }

        prev = arr[maxIdx];
        boolean isUp = true;
        for (int i = maxIdx + 1; i < N; i++) {
            if (prev < arr[i]) {
                isUp = false;
                break;
            }

            prev = arr[i];
        }

        if (isDown && isUp)
            System.out.println(sum);
        else
            System.out.println(0);
    }
}

/*

*/
