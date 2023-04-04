package week51;

import java.io.*;
import java.util.TreeMap;

/**
 * 백준 20291번
 * 파일 정리 (https://www.acmicpc.net/problem/20291)
 * 분류 : 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵, 파싱
 **/
public class BOJ_20291 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            // [0] : 파일 이름 [1] : 확장자 이름
            String[] str = br.readLine().split("\\."); // 정규표현식으로 단일 온점 사용 불가
            // 이미 존재하는 확장자일 경우 값 갱신
            if (map.containsKey(str[1]))
                map.replace(str[1], map.get(str[1]) + 1);
            // 그렇지 않을 경우 새로운 확장자를 key값으로 저장
            else
                map.put(str[1], 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet())
            sb.append(s + " " + map.get(s) + "\n");

        System.out.println(sb);
    }
}
