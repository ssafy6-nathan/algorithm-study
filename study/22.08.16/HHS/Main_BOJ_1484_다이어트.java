import java.io.*;

public class Main_BOJ_1484_다이어트 {

	static int G;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		
		int real = 1;
		int memory = 1;
		int answer = 0;
		
		while(true) {
			//제곱 빼고 서로 차이가 1나는데도 G 보다 크면 더이상 숫자 올라갈 필요 없음
			int minus = (int) ( Math.pow(real , 2) - Math.pow(memory, 2));
			
			if(real - memory == 1 && minus > G )
				break;
			
			if(minus < G)
				real++;
			else
				memory++;
			
			if(minus == G) {
				answer ++;
				System.out.println(real);
				real++;
				memory = 1;
			}
		}
		
		if(answer == 0)
			System.out.println(-1);
	}

}
