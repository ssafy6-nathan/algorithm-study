import java.io.*;
import java.util.*;

public class Main_BOJ_16139_인간컴퓨터상호작용 {
	
	static int [][] alpha;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int strSize = str.length();
		
		alpha = new int[26][strSize+1];
		
		for(int i = 0; i < strSize; i++) {
			int num = str.charAt(i) - 'a';
			for(int j = 0; j < 26; j++) {
				if(j == num)
					alpha[num][i+1] = alpha[num][i]+1;
				else
					alpha[j][i+1] = alpha[j][i];
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < q; t++) {
			token = new StringTokenizer(br.readLine());
			int target = token.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			sb.append(alpha[target][end+1] - alpha[target][start]);
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}

}
