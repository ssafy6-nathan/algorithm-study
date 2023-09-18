package study.nathan_algo_study.week65;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 운동 중복 플레이어
 * 링크 : https://level.goorm.io/exam/195683/%EC%9A%B4%EB%8F%99-%EC%A4%91%EB%8F%85-%ED%94%8C%EB%A0%88%EC%9D%B4%EC%96%B4/quiz/1
 */

public class Goorm195683 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        double R = Integer.parseInt(st.nextToken());
        R = R / 30 + 1;

        long result = (long)(W * R);

        System.out.println(result);
    }
}

/*

*/
