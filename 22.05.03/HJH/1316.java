import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] check;
		int groups = 0;

		for (int i = 0; i < N; i++) {
				check = new boolean[26];
				String str = br.readLine();
			for (int j = 1; j < str.length(); j++) {
				if(str.charAt(j)!=str.charAt(j-1)) {
					if(check[j-'a']) {
						break;
//						check[j-'a']=1;
					} else {
						check[j-'a']=true;
						groups++;
					}
				}
				
			}
		}
		System.out.println(groups);
	}
}
