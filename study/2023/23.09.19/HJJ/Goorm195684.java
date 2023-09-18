package study.nathan_algo_study.week65;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 프로젝트 매니징
 * 링크 : https://level.goorm.io/exam/195684/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%A7%A4%EB%8B%88%EC%A7%95/quiz/1
 */

public class Goorm195684 {
    static final int DAY_TOTAL_MINUTES = 1440;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minutes = T * 60 + M;
        for (int i = 0; i < N; i++)
            minutes += Integer.parseInt(br.readLine());

        minutes %= DAY_TOTAL_MINUTES;
        int resultT = minutes / 60;
        int ressultM = minutes % 60;

        System.out.println(resultT + " " + ressultM);
    }
}

/*

*/
