import java.io.*;

public class Main_BOJ_1475_방번호 {

	static String room;
	static int [] num;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		room = br.readLine();
		num = new int[10];
		
		for(int i = 0; i < room.length(); i++) {
			int number = room.charAt(i)-'0';
			if(number == 9 || number == 6) {
				num[6]++;
				num[9]++;
			}else
				num[number]++;
		}
		
		num[6] = (int) Math.round((double)num[6]/2);
		num[9] = (int) Math.round((double)num[9]/2);
		
		for(int i = 0; i < 10; i++) {
			answer = Math.max(answer, num[i]);
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
