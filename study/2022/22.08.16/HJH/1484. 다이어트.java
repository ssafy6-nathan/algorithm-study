import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());
        int s = 1; int e = 1;
        boolean flag = false;
        while (e < g) {
            if(e * e - s * s == g) {
                bw.write(e + "\n");
                flag = true;
            }
            if(e * e - s * s < g) e++;
            else s++;
        }
        if(!flag) bw.write("-1" + "\n");

        br.close();
        bw.flush();

    }
}
