package w15_220607;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ9934완전이진트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int[] tree = new int[(int) (Math.pow(2, K) - 1)];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
	}
}
