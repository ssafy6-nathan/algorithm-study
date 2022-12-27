package week35;

import java.io.*;

/**
 * 백준 5639번
 * 이진 검색 트리 (https://www.acmicpc.net/problem/5639)
 * 분류 : 그래프 이론, 그래프 탐색, 트리, 재귀
 **/

public class BOJ_5639 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine())); // 첫 입력은 루트 노드

        while (true) {
            String node = br.readLine();
            if (node == null) break; // 입력이 없을 때 까지 반복
            root.insert(Integer.parseInt(node)); // 루트노드를 시작으로 값을 비교하며 노드 추가
        }
        postOrder(root);
        bw.close();
    }

    // 후위순회 (Left recur -> Right recur -> Print)
    private static void postOrder (Node node) throws IOException {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            bw.write(node.data+"\n");
        }
    }

    private static class Node {
        int data; // 현 노드 데이터
        Node left; // 왼쪽 자식 노드
        Node right; // 오른쪽 자식 노드

        // 생성자
        Node (int num) {
            this.data = num;
        }

        // 삽입 연산
        void insert (int num) {
            if (num < this.data) { // 현 노드 기준 더 작은 값은 좌측 서브트리로 재귀
                if (this.left == null) this.left = new Node(num);
                else this.left.insert(num);
            }
            else { // 현 노드 기준 더 큰 값은 우측 서브트리로 재귀
                if (this.right == null) this.right = new Node(num);
                else this.right.insert(num);
            }
        }
    }
}
