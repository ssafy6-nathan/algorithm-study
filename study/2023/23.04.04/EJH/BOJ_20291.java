import java.util.HashMap;
import java.util.Scanner;

public class BOJ_20291 {
    static int N;
    static HashMap<String, Integer> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            String extension = input.split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet().stream().sorted().toArray(String[]::new)){
            sb.append(key+" "+ map.get(key) + "\n");
        }

        System.out.println(sb);

    }
}
