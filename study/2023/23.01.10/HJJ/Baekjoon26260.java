package study.nathan_algo_study.week44;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 이가 빠진 이진 트리
 * 링크 : https://www.acmicpc.net/problem/26260
 */

public class Baekjoon26260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value == -1)
                continue;

            tree.insert(value);
        }
        int x = Integer.parseInt(br.readLine());
        tree.insert(x);

        StringBuilder sb = new StringBuilder();
        tree.postOrder(tree.root, sb);
        System.out.println(sb);

    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}

class Tree {
    Node root = null;

    public void insert(int val) {
        if (root == null)
            root = new Node(val);
        else {
            Node head = root;
            Node curr;

            while (true) {
                curr = head;
                if (head.value > val) {
                    head = head.left;

                    if (head == null) {
                        curr.left = new Node(val);
                        break;
                    }
                } else {
                    head = head.right;

                    if (head == null) {
                        curr.right = new Node(val);
                        break;
                    }
                }
            }

        }

    }

    public void postOrder(Node node, StringBuilder sb) {
        if (node == null)
            return;

        if (node.left != null)
            postOrder(node.left, sb);

        if (node.right != null)
            postOrder(node.right, sb);

        sb.append(node.value+" ");
    }
}

/*

*/
