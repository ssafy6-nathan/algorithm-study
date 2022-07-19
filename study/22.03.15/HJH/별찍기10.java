package week3;
import java.util.Scanner;
public class 별찍기10 {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		arr = new char[N][N];
		star(0, 0, N, false);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	public static void star(int r, int c, int N, boolean blank) {
		if(blank) {
			for (int i = r; i < r+N; i++) {
				for (int j = c; j < c+N; j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		if(N==1) {
			arr[r][c]='*';
			return;
		}		
		int size = N/3;
		int count=0;
		for (int i = r; i < r+N; i+=size) {
			for (int j = c; j < c+N; j+=size) {
				count++;
				if(count==5) {
					star(i,j,size,true);
				}
				else {
					star(i,j,size,false);
				}
			}
		}
		
	}
}
