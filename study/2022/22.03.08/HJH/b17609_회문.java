import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// stack이나 hash로는 못 푸나?
public class b17609_회문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (checkPalindrome(str)) {
				ans = 0;
			} else if (checkPseudo(str)) {
				ans = 1;
			} else {
				ans = 2;
			}
			System.out.println(ans);
		}
	}

	private static boolean checkPseudo(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				return checkPalindrome(str.substring(start, end)) || checkPalindrome(str.substring(start + 1, end + 1));
			}
			start++;
			end--;
		}
		return true;
	}

	private static boolean checkPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start <= end) {
			if (str.charAt(start++) != str.charAt(end--))
				return false;
		}
		return true;
	}
}
