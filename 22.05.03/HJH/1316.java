// 그룹 단어 체커
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1316 {
	static int[] check;
	static int groups;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		groups = 0;
		
		int ans = 0;
		for (int j = 0; j < N; j++) {
				check = new int[26];
				String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)!=str.charAt(i-1)) {
					if(check[i-'a']==0) {
						check[i-'a']=1;
					} else {
						return;
					}
				}
				groups++;
			}
		}
		System.out.println(groups);
	}
}
