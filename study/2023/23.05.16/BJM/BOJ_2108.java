package week56;

import java.io.*;
import java.util.*;

/**
 * 백준 2108번
 * 통계학 (https://www.acmicpc.net/problem/2108)
 * 분류 : 수학, 구현, 정렬
 **/

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        // 1. 산술평균
        double sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        bw.write(Math.round(sum / N)+ "\n");

        // 2. 중앙값
        bw.write(nums[N / 2] + "\n");

        // 3. 최빈값
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        // 숫자가 하나인 경우 최빈값은 무조건 자신
        if (map.size() == 1) {
            bw.write(nums[0] + "\n");
        }
        else {
            // 해시맵을 정렬하여 최빈값 찾기
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (o1, o2) -> {
                // 정렬조건 1: 빈도수 (= value) 내림차순
                if (o1.getValue() == o2.getValue())
                    // 정렬조건 2: 숫자값 (= key) 오름차순
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());
            });

            int cnt = 0;
            int key1 = 0;
            for (Map.Entry<Integer, Integer> entry : list) {
                // 오름차순으로 정렬하여 두번째 값까지 확인
                if (cnt >= 1) {
                    // 최빈값이 같을 경우 두번째로 작은 값 (두번째 값) 출력
                    if (map.get(key1).equals(entry.getValue()))
                        bw.write(entry.getKey() + "\n");
                    // 최빈값이 다를 경우 첫번째 값 출력
                    else
                        bw.write(key1 + "\n");
                    break;
                }
                key1 = entry.getKey();
                cnt++;
            }
        }
        // 4. 범위
        bw.write(nums[N-1] - nums[0] + "");

        bw.close();
    }
}
