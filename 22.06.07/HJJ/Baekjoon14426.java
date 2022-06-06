package study.nathan_algo_study.week15;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제이름 : 접두사 찾기
 * 링크 : https://www.acmicpc.net/problem/14426
 */

public class Baekjoon14426 {
    static int N, M;
    static String[] S;
    static Trie trie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trie = new Trie();
        S = new String[N];
        for (int i = 0; i < N; i++)
            trie.insert(br.readLine());

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (trie.search(br.readLine()))
                cnt++;
        }
        System.out.println(cnt);
    }

}

class Node {
    Map<Character, Node> child;
    boolean isEndOfWord;

    public Node() {
        child = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = this.root;

        //curr가 word의 각 문자를 key로 하는 자식 노드가 존재하지 않을 경우에만 자식 노드 생성
        for (int i = 0; i < word.length(); i++) {
            curr = curr.child.computeIfAbsent(word.charAt(i), c -> new Node());
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            curr = curr.child.getOrDefault(word.charAt(i), null);
            if (curr == null)
                return false;
        }

        return true;
    }

}

/*

*/
