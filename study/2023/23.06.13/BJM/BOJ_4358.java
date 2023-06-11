package week57;

import java.io.*;
import java.util.*;

/**
 * 백준 4358번
 * 생태학 (https://www.acmicpc.net/problem/4358)
 * 분류 : 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 **/
public class BOJ_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new TreeMap<>(); // 사전 순서로 자동 정렬하기 위해 트리맵 선언
        int count = 0; // 전체 나무 수
        String tree;

        while ((tree = br.readLine()) != null) { // 입력이 끝날 때 까지 받음
            // 트리맵에 이미 존재할 경우 value 값을 받아오고, 그렇지 않으면 default 반환
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;
        }

        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            double ratio = ((double)entrySet.getValue() / count) * 100; // 종류별 백분율 저장
            String result = String.format("%.4f", ratio); // 소수점 4자리 포맷의 문자열로 저장
            bw.write(entrySet.getKey() + " " + result + "\n");
        }

        bw.close();
    }
}
