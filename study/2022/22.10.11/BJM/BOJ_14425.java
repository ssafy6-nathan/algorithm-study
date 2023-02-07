package week31;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 백준 14425번
 * 문자열 집합 (https://www.acmicpc.net/problem/14425)
 * 분류 : 자료구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 **/

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        int count = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) // N개 문장 저장
            set.add(br.readLine());

        for (int i = 0; i < M; i++) // M개 문장 비교
            if (set.contains(br.readLine())) count++;

        System.out.println(count);
    }
}
    
