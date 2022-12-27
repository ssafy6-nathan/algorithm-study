package week36;

import java.io.*;
import java.util.*;

/**
 * 백준 18111번
 * 마인크래프트 (https://www.acmicpc.net/problem/18111)
 * 분류 : 구현, 브루트포스 알고리즘
 **/
public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> groundInfo = new HashMap<>(); // key: 땅 높이, value: 블록 수
        int N = Integer.parseInt(st.nextToken()); // row
        int M = Integer.parseInt(st.nextToken()); // col
        int B = Integer.parseInt(st.nextToken()); // 인벤토리에 존재하는 블록 개수

        // 1. 입력정보 저장
        int max = 0;
        int min = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                // 1-1. 정보 입력과 함께 최소 높이와 최대 높이도 구함
                if (height > max) max = height;
                if (height < min) min = height;
                // 1-2. if 새로운 높이 값일 경우 추가, else 이미 있는 정보일 경우 value(개수) 갱신
                if (!groundInfo.containsKey(height)) {
                    groundInfo.put(height, 1);
                } else {
                    groundInfo.put(height, groundInfo.get(height) + 1);
                }
            }
        }
        // 2. 최소 높이 ~ 최대 높이 만큼 반복
        int place, remove, inventory; // 설치, 삭제, 현재 인벤토리 블록개수
        int answer = 0; // 최저 시간일 경우 블록 높이
        int time = 999999999; // 최저 시간
        for (int i = max; i >= min; i--) {
            place = 0;
            remove = 0;
            inventory = B;
            // 2-1. 현재 기준 높이에 맞추기 위해 설치 및 삭제 여부 판단
            for (Map.Entry<Integer, Integer> ground : groundInfo.entrySet()) {
                int difference = i - ground.getKey(); // 블록 개수의 차 = (현재 기준 높이 - 블록의 높이)
                if (difference < 0) { // 높이 차가 음수라면, 기준보다 높으므로 삭제 연산
                    remove += (ground.getValue() * Math.abs(difference));
                    inventory += (ground.getValue() * Math.abs(difference)); // 삭제하여 인벤토리에 넣을 수 있음
                } else if (difference > 0) { // 높이 차가 양수라면, 기준보다 낮으므로 설치 연산
                    place += ground.getValue() * difference;
                }
            }
            // 2-2. 현재 높이로 만드는 태스크가 최저 시간인지 판단
            if (place <= inventory) { // 설치 카운트가 B의 값만큼은 있어야 기준 높이로 만들 수 있음
                if (place + (remove * 2) < time) { // 시간이 같은 경우는 무시 가능 (같을 경우 더 높은 블록을 출력해야하므로)
                    time = place + (remove * 2); // 계산 결과가 최저 시간일 경우 갱신
                    answer = i; // 최저 시간의 블록 높이 저장
                }
            }
        }
        // 3. 최저 시간과 땅의 높이 출력
        bw.write(time + " " + answer);
        bw.close();
    }
}

/*
[풀이]
1. <K: 땅의 높이 V: 차지하고 있는 땅의 개수> 정보가 담긴 해시맵에 정보를 저장하고 이용
  (2차원 배열에 저장하고 탐색하는 방법이 일반적일것 같았지만, 중복된 땅 높이를 한번에 처리해주는게 더 낫지 않을까 싶었음
  근데 코드도 알아보기 힘들고, 애초에 테케들이 중복된 땅이 많을거란 보장이 없으니까 성능도 거기서 거기일 것 같음...)
2. 땅의 최대높이부터 최소높이까지 반복하면서, 현재 기준 높이에서 블록의 설치와 삭제연산이 얼마나 이루어지는지 계산
3. 반복문 한 번 마다 인벤토리 안의 블록개수와 설치 연산 수를 비교하여 가능성 판단 후, 최저 시간 갱신

[반례 해결]
1. for문 반복변수 설정오류 (max 에서 min 으로 내려와야 더 높은 블록일 경우의 시간이 저장됨)
2. 삭제연산시 인벤토리에 블록이 하나 추가되어야 함
3. 삭제된 연산만큼 인벤토리에 블록이 추가되어야 하고, 비교할때 지정개수 B가 아닌 유동개수 inventory 와 비교해야함

--반례1--
1 3 68
0 0 1
기대값 : 2 1

--반례2--
3 4 11
29 51 54 44
22 44 32 62
25 38 16 2
기대값 : 250 35

--반례3--
4 4 36
15 43 61 21
19 33 31 55
48 63 1 30
31 28 3 8
기대값 : 355 32

--반례5--
7 7 6000
30 21 48 55 1 1 4
0 0 0 0 0 0 0
15 4 4 4 4 4 8
20 40 60 10 20 30 2
1 1 1 1 1 1 9
24 12 33 7 14 25 3
3 3 3 3 3 3 32
기대값 : 879 10

--반례6--
2 2 35
20 10
190 40
기대값 : 350 40

--반례7--
2 2 68
120 90
250 170
기대값 : 290 170

--반례4--
2 2 0
256 256
0 0
기대값 : 768 128
 */