import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		boolean[] check = new boolean[26];
		for (int i = 0; i < N; i++) {
				String str = br.readLine();
				check[str.charAt(0)-'a'] =true;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)!=str.charAt(j-1)) {
					if(check[str.charAt(j)-'a']) {
						break;
					} else {
						check[str.charAt(j)-'a']=true;
						cnt++;
						break;
					}
				}
				
			}
		}
		System.out.println(cnt);
	}
}
