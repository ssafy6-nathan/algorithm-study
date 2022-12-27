package week36;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 1138번
 * 한 줄로 서기 (https://www.acmicpc.net/problem/1475)
 * 분류 : 구현
 **/
public class BOJ_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(br.readLine()); // 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 사람들의 기억 정보

        // 1. 입력된 기억 정보를 배열에 저장
        int[] lineUp = new int[N];
        for (int i = 0; i < N-1; i++)
            lineUp[i] = Integer.parseInt(st.nextToken());

        // 2. 배열을 역순으로 순회하며 리스트에 순서 저장
        for (int i = lineUp.length - 1; i >= 0; i--)
            list.add(lineUp[i], i + 1);

        // 3. 리스트 순서대로 출력
        for (int answer : list)
            bw.write(answer + " ");
        bw.close();
    }
}

// 앞에 자신보다 큰 사람이 몇 명인지의 정보만 주어지므로 자신보다 작은 사람이 앞에 있는지 없는지는 알 수 없다.
// (= 가장 작은 사람 1부터 세우기 시작하면, 1보다 큰 다음 사람 2는 1의 앞에 섰는지 뒤에 섰는지 알 수 없음)
// 따라서 가장 큰 사람 9부터 세우기 시작하면, 9보다 작은 다음 사람 8은 9의 기억 정보를 이용할 수 있다.
// (= 8이 9의 앞에 섰는지 뒤에 섰는지 판별이 가능함)
