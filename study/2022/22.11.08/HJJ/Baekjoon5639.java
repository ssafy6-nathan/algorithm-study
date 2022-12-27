package study.nathan_algo_study.week35;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이진 검색 트리
 * 링크 : https://www.acmicpc.net/problem/5639
 */

public class Baekjoon5639 {
    static ArrayList<Integer> tree;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        tree = new ArrayList<>();
        sb = new StringBuilder();
        while ((input = br.readLine()) != null && input.length() != 0)
            tree.add(Integer.parseInt(input));

        dfs(0, tree.size()-1);
        System.out.println(sb.toString());
    }

    //후위 순회
    public static void dfs(int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx)
            return;

        int mid = leftIdx + 1;
        while (mid <= rightIdx && tree.get(mid) < tree.get(leftIdx)) mid++;

        dfs(leftIdx+1, mid - 1);    //왼쪽 서브트리
        dfs(mid, rightIdx);                      //오른쪽 서브트리
        sb.append(tree.get(leftIdx)+"\n");       //루트
    }
}


/*

50 30 24 5 28 45 98 52 60
^                ^


30 24 5 28 45
^          ^

52 60
^  ^
*/
