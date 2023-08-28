package study.nathan_algo_study.week64;

import java.io.*;

/**
 * 문제이름 : 통증
 * 링크 : https://level.goorm.io/exam/195690/%ED%86%B5%EC%A6%9D/quiz/1
 */

public class Goorm195690 {
    static int[] items = {14, 7, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pain = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += pain / items[i];
            pain %= items[i];

            if (pain == 0)
                break;
        }

        System.out.println(cnt);
    }
}

/*

 */
