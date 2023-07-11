package study.nathan_algo_study.week60;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 접두사
 * 링크 : https://www.acmicpc.net/problem/1141
 */

public class Baekjoon1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            input.add(br.readLine());

        input.sort(Comparator.comparingInt(String::length).reversed());

        Trie trie = new Trie();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (trie.isPrefix(input.get(i)))
                continue;

            trie.insert(input.get(i));
            cnt++;
        }

        System.out.println(cnt);
    }
}

class Node {
    public Map<Character, Node> childs = new HashMap<>();
    public boolean endOfWord = false;
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public boolean isPrefix(String word) {
        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!curr.childs.containsKey(word.charAt(i)))
                return false;

            curr = curr.childs.get(word.charAt(i));
        }

        return true;
    }

    public void insert(String word) {
        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            curr = curr.childs.computeIfAbsent(word.charAt(i), c -> new Node());
        }
    }
}

/*

*/
