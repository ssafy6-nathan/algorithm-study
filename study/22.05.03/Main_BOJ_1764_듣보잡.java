import java.io.*;
import java.util.*;

public class Main_BOJ_1764_듣보잡 {

	static int N, M; 
//	static String[] person;
	
	public static void main(String[] args) throws IOException {

		//첫번째 숫자로 배열 만들어서 듣도 못한 사람 넣어놓고
		//만들어진 배열을 순회하며 보도 못한 사람과 중복되면 다른 배열에 넣고 알파벳 순으로 정렬
		//-> 시간 초과
		
		//배열 대신 해시셋에 넣어서 비교하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		ArrayList<String> result = new ArrayList<String>();
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
	
		
		HashSet<String> person = new HashSet<String>();
//		person = new String[N];
		for (int i = 0; i < N; i++) {
			person.add(br.readLine());
//			person[i] = br.readLine();
		}//듣도 못한 사람 입력 완료

		for (int j = 0; j < M; j++) {
			String see = br.readLine();
			if(person.contains(see))
				result.add(see);
		}

		bw.write(result.size() + "\n");
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) {
			bw.write(result.get(i) + "\n");
		}
		bw.flush();
		bw.close();
		
	}

}
