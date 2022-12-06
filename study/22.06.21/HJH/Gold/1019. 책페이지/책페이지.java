package w17_220621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1019_책페이지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[10]; // 0~9 배열
		// 일단 10으로 나눈다.
		int dft = N / 10; // default 값
		// 일의자리수 idx 알아야되니까
		int mod = N % 10;
		for (int i = 0; i < 10; i++) {
			nums[i] = dft;
		}
		for (int m = 0; m <= mod; m++) {
			nums[m]++;
			// nums[m]++;
		}
		// 근데 1부터 시작이니까 0의 cnt 수 나중에 하나 빼지 뭐.
		for (int i = 0; i < 10; i++) {
			if(i == 0) {
				--nums[i];
			}
			System.out.print(nums[i]+" ");
		}
	}
}
