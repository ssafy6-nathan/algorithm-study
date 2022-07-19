import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 듣보잡
public class Main_1764 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 듣
		int M = Integer.parseInt(st.nextToken());// 보
		Set<String> hash = new HashSet<String>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++)
			hash.add(br.readLine());
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (hash.contains(str))
				list.add(str);
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}