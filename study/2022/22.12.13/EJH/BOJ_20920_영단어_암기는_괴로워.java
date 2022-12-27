import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920_영단어_암기는_괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N, M;
        Map<String, Integer> words = new HashMap<String, Integer>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
           String word = br.readLine();

           if(word.length() < M) continue;

           int count = words.getOrDefault(word, 0);
           words.put(word, count + 1);
        }

        List<String> keys = new ArrayList<>(words.keySet());

        keys.sort((w1, w2) -> {
            int c1 = words.get(w1);
            int c2 = words.get(w2);

            if(c1 == c2){
                if(w2.length() == w1.length()){
                    return w1.compareTo(w2);
                }
                return w2.length() - w1.length();
            }

            return c2 - c1;
        });


        for (String key : keys) {
            sb.append(key + "\n");
        }
        System.out.println(sb);

    }
}
