import java.util.Scanner;

public class 나무자르기 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		int[] tree = new int[N];
		int min = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = in.nextInt();
			max = Math.max(max, tree[i]);
		}
		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			for (int treeHeight : tree) {
				if (treeHeight - mid > 0) {
					sum += (treeHeight - mid);
				}
			}
			if (sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}
