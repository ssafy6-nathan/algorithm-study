package week36;

import java.io.*;

/**
 * 백준 1475번
 * 방 번호 (https://www.acmicpc.net/problem/1475)
 * 분류 : 구현
 **/
public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        float[] cnt = new float[9]; // 9를 6으로 처리하므로 0~8까지의 숫자만 필요
        int answer = 0;

        // 1. 방 번호 숫자 카운트
        String roomNum = br.readLine(); // 방 번호 입력
        for (int i = 0; i < roomNum.length(); i++) {
            int number = Character.getNumericValue(roomNum.charAt(i)); // 한 글자를 받아와서 int 캐스팅
            if(number == 9) cnt[6]++; // 9일 경우 6으로 처리
            else cnt[number]++; // 해당 숫자 카운팅
        }

        // 2. 6 개수 처리
        cnt[6] = Math.round(cnt[6]/2);

        // 3. 가장 많은 번호 탐색
        float max = 0;
        for (float v : cnt)
            if (max < v) max = v;

        // 4. 최대값 출력
        bw.write(String.valueOf((int)max));
        bw.close();
    }
}

// 첫 번째 풀이
// -> 번호를 모두 카운팅해서 최대값을 찾고, 최대값이 6과 9일 경우 후처리
// 반례 : 가장 높은 값으로 6이나 9가 나왔는데, 후처리 이후 최대값인 번호가 바뀔 때.
// ex) 9999444의 경우 최대값 9를 후처리하면 2세트가 나오지만 실질적으로 4 때문에 3세트가 필요함

// 두 번째 풀이
// -> 6과 9를 같은 수로 취급하여 카운팅 후 2로 나눈 수를 반올림함 (홀수의 경우 세트가 한 개 더 필요하므로 반올림)
// -> 이후 최대값을 찾아 출력

