package study.nathan_algo_study.week43;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 터렛
 * 링크 : https://www.acmicpc.net/problem/1002
 */

public class Baekjoon1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            bw.write(solution(x1,y1,r1,x2,y2,r2)+"\n");
        }
        bw.close();
    }

    public static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dis = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if(x1 == x2 && y1 == y2 && r1 == r2)  //중점이 같으면서 반지름도 같을 경우
            return -1;
        else if(dis > Math.pow(r1 + r2, 2))  //두 원의 반지름 합보다 중점간 거리가 더 길 때
            return 0;
        else if(dis < Math.pow(r2 - r1, 2))  //원 안에 원이 있으나 내접하지 않을 때
            return 0;
        else if(dis == Math.pow(r2 - r1, 2))  //내접할 때
            return 1;
        else if(dis == Math.pow(r1 + r2, 2))  //외접할 때
            return 1;
        else    //그 이외엔 두 점에서 만남
            return 2;

    }
}

/*

*/
