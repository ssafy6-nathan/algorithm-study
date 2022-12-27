import java.io.*;
import java.util.*;

public class Main_BOJ_9934_완전이진트리 {

	static int K;
	static int [] arr;
	static StringBuffer[] result;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		arr = new int[(int) (Math.pow(2, K)-1)];
//		System.out.println(arr.length);
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(token.nextToken()); 
		}
		
		//가운데에 있는 애가 루트, 그다음 가운데들이 다음 층 -> 반복
		result = new StringBuffer[K];
		for(int i = 0; i < K; i++) {
			result[i] = new StringBuffer();
		}
		go(0, arr.length-1, 0);
		
		for(int i = 0; i < K; i++) {
			System.out.println(result[i].toString());
		}
	}

	private static void go(int start, int end, int depth) {
		if(depth == K)
			return;
		
		int index = (start + end)/2;
		result[depth].append(arr[index] +" ");
		
		go(start, index-1, depth+1);
		go(index+1, end, depth+1);
	}

}
