import java.io.*;

public class Main_BOJ_1010_다리놓기 {

	static int T;
	static int [][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new int[31][31];
		
		for(int j = 1; j <= 30; j++) {
			map[1][j] = j;
		}
		
		for(int i = 2; i <= 30; i++) {
			for(int j = i; j <= 30; j++) {
				if(i == j) map[i][j] = 1;
				else map[i][j] = map[i-1][j-1]+map[i][j-1];
			}
		}
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String [] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			bw.write(String.valueOf(map[n][m]) + "\n");
			bw.flush();
		}
		bw.close();
	}

}
