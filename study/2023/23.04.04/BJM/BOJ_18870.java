package week51;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 백준 18870번
 * 좌표 압축 (https://www.acmicpc.net/problem/18870)
 * 분류 : 정렬, 값 / 좌표 압축
 **/
public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int[] number = new int[N]; // 순서 기억
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 정렬

        // 1. 배열과 트리맵에 모두 저장하여 순서를 기억함과 동시에 정렬
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            map.put(number[i], 0);
        }

        // 2. 트리맵을 돌면서 오름차순으로 값을 갱신
        int count = 0;
        for (Integer i : map.keySet())
            map.replace(i, count++);
        
        // 3. 배열에 저장된 순서대로 트리맵의 값을 출력
        for (int i : number)
            bw.write(map.get(i) + " ");

        bw.close();
    }
}
