import java.io.*;

public class Main_BOJ_1003_피보나치함수 {

	static int T;
	static int [] dpZero;
	static int [] dpOne;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dpZero = new int[41];
		dpOne = new int[41];
		dpZero[0] = 1;
		dpOne[1] = 1;
		for(int i = 2; i <= 40; i++) {
			dpZero[i] = dpZero[i-2]+dpZero[i-1];
			dpOne[i] = dpOne[i-2]+dpOne[i-1];
		}
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(dpZero[N]+" "+dpOne[N]+"\n");
			bw.flush();
		}
		bw.close();
		
	}

}
