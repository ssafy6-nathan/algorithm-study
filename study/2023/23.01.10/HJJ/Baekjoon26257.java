package study.nathan_algo_study.week44;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : std::shared_ptr
 * 링크 : https://www.acmicpc.net/problem/26257
 */

public class Baekjoon26257 {
    static int N, M, Q;
    static int[] p;
    static int[] objCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        objCnt = new int[N+1];
        p = new int[M+1];
        for (int i = 1; i <= M; i++) {
            p[i] = Integer.parseInt(br.readLine());
            objCnt[p[i]]++;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to;
            switch (cmd) {
                case "assign":
                    to = Integer.parseInt(st.nextToken());
                    objCnt[p[from]]--;
                    objCnt[p[to]]++;
                    p[from] = p[to];
                    break;
                case "swap":
                    to = Integer.parseInt(st.nextToken());
                    int tempObj = p[from];
                    p[from] = p[to];
                    p[to] = tempObj;
                    break;
                case "reset":
                    objCnt[p[from]]--;
                    p[from] = 0;
                    break;
            }
        }
        int liveObjCnt = 0;
        for (int i = 1; i <= N; i++) {
            if (objCnt[i] > 0)
                liveObjCnt++;
        }

        bw.write(liveObjCnt+"\n");
        for (int i = 1; i <= N; i++) {
            if (objCnt[i] > 0)
                bw.write(i+"\n");
        }

        bw.close();
    }
}

/*

 */
