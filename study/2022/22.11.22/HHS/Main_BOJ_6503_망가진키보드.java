import java.io.*; 
import java.util.*;

public class Main_BOJ_6503_망가진키보드 {

	static int M;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {			
			M = Integer.parseInt(br.readLine());
			if(M == 0) break;
			String str = br.readLine();
			HashMap<Character, Integer> map = new HashMap<>();
			int s = 0;
			int e = 0;
			answer = 0;
			while(e < str.length()) {
				if(map.containsKey(str.charAt(e)))
					map.put(str.charAt(e), map.get(str.charAt(e))+1);
				else
					map.put(str.charAt(e), 1);
				e++;
				
				while(map.size() > M) {
					map.put(str.charAt(s), map.get(str.charAt(s))-1);
					if(map.get(str.charAt(s)) == 0)
						map.remove(str.charAt(s));
					s++;
				}
				answer = Math.max(answer, e-s);
			}
			bw.write(String.valueOf(answer)+"\n");
		}
		bw.close();
		
	}

}