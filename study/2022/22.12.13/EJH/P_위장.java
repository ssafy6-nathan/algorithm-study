import java.util.HashMap;
import java.util.Map;

public class P_위장 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> spy = new HashMap<String, Integer>();

        for (String[] c : clothes){
            int count = spy.getOrDefault(c[1], 0);
            spy.put(c[1], count + 1);
        }

        for(String s : spy.keySet()){
            answer *= (spy.get(s) + 1);
        }
        answer -= 1;

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(
                solution(new String[][]{{"yellow_hat", "headgear"},
                        {"blue_sunglasses", "eyewear"},
                        {"green_turban", "headgear"}})
        );
    }
}