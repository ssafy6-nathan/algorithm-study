/*
 * 문제 : 통증
 * 링크 : https://level.goorm.io/exam/195690/%ED%86%B5%EC%A6%9D/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_195690 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = N / 14;
        N %= 14;

        cnt += N / 7;
        N %= 7;

        cnt += N;

        System.out.println(cnt);

    }

}
