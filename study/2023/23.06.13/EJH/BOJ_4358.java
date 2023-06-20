import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_4358 {
    static HashMap<String, Integer> trees;
    static int allCount;

    public static void main(String[] args) {
        trees = new HashMap();
        allCount = 0;
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        while(true) {
            trees.put(str, trees.getOrDefault(str, 0) + 1);
            allCount++;
            str = sc.nextLine();
            if(str == null || str.length() == 0) {
                break;
            }
        }

        Object[] keys = trees.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for(Object key : keys) {
            String keyStr = (String) key;
            int count = trees.get(keyStr);
            double per = (count * 100.0) / allCount;

            sb.append(keyStr + " " + String.format("%.4f", per) + "\n");
        }

        System.out.println(sb);

    }
}
