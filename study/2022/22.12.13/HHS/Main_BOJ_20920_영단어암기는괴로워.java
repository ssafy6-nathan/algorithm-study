import java.io.*;
import java.util.*;

public class Main_BOJ_20920_영단어암기는괴로워 {

	static int N, M;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.length() < M) continue;
			
			map.put(str, map.getOrDefault(str, 0)+1);
			
		}
		
		PriorityQueue<Dict> que = new PriorityQueue<>();
		
		for(String key : map.keySet())
			que.offer(new Dict(key, key.length(), map.get(key)));

		while(!que.isEmpty()) {
			Dict d = que.poll();
			bw.write(d.word + "\n");
		}
		bw.close();
	}

}
class Dict implements Comparable<Dict>{
	String word;
	int len;
	int count;
	
	public Dict(String word, int len, int count) {
		super();
		this.word = word;
		this.len = len;
		this.count = count;
	}

	@Override
	public int compareTo(Dict o) {
		int c = o.count - this.count;
		if(c == 0) {
			int l = o.len - this.len;
			if(l == 0)
				return this.word.compareTo(o.word);
			return l;
		}
		return c;
	}
}