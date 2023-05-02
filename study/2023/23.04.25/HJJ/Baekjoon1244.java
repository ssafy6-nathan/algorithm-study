package study.nathan_algo_study.week54;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 스위치 켜고 끄기
 * 링크 : https://www.acmicpc.net/problem/1244
 */

public class Baekjoon1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            toggle(arr, gender == 1, number);
        }

        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 20 == 0)
                bw.newLine();

            bw.write(arr[i] + " ");
        }
        bw.close();
    }

    public static void toggle(int[] switchs, boolean isMale, int switchNumber) {
        if (isMale) {   //남자인 경우
            for (int i = switchNumber - 1; i < switchs.length; i += switchNumber)
                switchs[i] = (switchs[i] + 1) % 2;

        } else {    //여자인 경우
            int startIdx = switchNumber - 1;
            int endIdx = switchNumber - 1;
            while (startIdx - 1 >= 0 && endIdx + 1 < switchs.length && switchs[startIdx - 1] == switchs[endIdx + 1]) {
                startIdx--;
                endIdx++;
            }

            for (int i = startIdx; i <= endIdx; i++)
                switchs[i] = (switchs[i] + 1) % 2;

        }
    }
}

/*

 */
