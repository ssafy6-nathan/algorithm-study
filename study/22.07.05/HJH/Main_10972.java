import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다음 순열
/*
Next Permutation
1. 뒤쪽부터 탐색하며 교환 위치(i-1) 찾기 (i: 꼭대기)
2. 뒤쪽부터 탐색하며 교환 위치(i-1)와 교환할 큰 값 위치(j: 뒤쪽에서 처음으로 자신보다 커지는 수) 찾기
3. 두 위치 값(i-1, j) 교환
4. 꼭대기 위치(i)부터 맨 뒤까지 오름차순 정렬
* */

public class Main_10972 {
    static int N;
    static int[] nums;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];// N!
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 우선 뽑은 애들 배열에 넣고
        // 앞 번호부터 비교
        nextPerm(0,0);

        br.close();
    }

    private static void nextPerm(int start, int cnt) {
        // 종료 조건
        if (cnt == N){
            return;
        }
    }
}
