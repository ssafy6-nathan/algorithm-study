import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {

        int root;
        Node left;
        Node right;

        Node(int n) {
            this.root = n;
        }

        void insert(int n) {

            if (n < this.root) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node R = new Node(Integer.parseInt(br.readLine()));
        String input;

        while ((input = br.readLine()) != null && input.length() != 0) {
            R.insert(Integer.parseInt(input));
        }

        postOrder(R);

        System.out.println(sb);

    }

    private static void postOrder(Node node) {

        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);

        sb.append(node.root).append("\n");

    }

}
