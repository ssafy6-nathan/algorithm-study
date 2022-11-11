package week36;

import java.io.*;
import java.util.*;

/**
 * 백준 21608번
 * 상어 초등학교 (https://www.acmicpc.net/problem/21608)
 * 분류 : 구현
 **/
public class BOJ_21608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}}; // 방향 탐색 (상하좌우 순서로 변동 인덱스값)
        int N = Integer.parseInt(br.readLine()); // 학생 수
        int[][] classroom = new int[N+2][N+2]; // 자리 배치도 (테두리 마진)
        ArrayList<Integer>[] students = new ArrayList[N*N]; // 좋아하는 학생 정보

        // 1. 좋아하는 학생 정보 입력
        // -> 배열 인덱스는 해당 학생의 자리 정하기 순번
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new ArrayList<>();
            students[i].add(Integer.parseInt(st.nextToken())); // 학생 번호 입력 (리스트 인덱스 0)
            for (int j = 0; j < 4; j++)
                students[i].add(Integer.parseInt(st.nextToken())); // 좋아하는 학생 입력 (리스트 인덱스 1~4)
        }

        // 첫 번째 학생의 경우 무조건 배열의 (2,2) 자리에 위치하게 되므로, 배열을 채우는 반복문에서 제외
        classroom[2][2] = students[0].get(0);

        // 2. 학생 수 만큼 반복하여 자리 정하기
        for (int s = 1; s < N * N; s++) {
            ArrayList<PlaceInfo> info = new ArrayList<>(); // 앉을 수 있는 자리 후보들의 정보
            int sMax = 0; // 인접한 좋아하는 학생 수의 배열 내 최대치 (문제조건1의 부합검사)

            // 2-1. 2차원 배열을 순회하여, 인접한 좋아하는 학생 수 최대치를 기준으로 자리배치 후보군 생성
            for (int r = 1; r < classroom.length - 1; r++) {
                for (int c = 1; c < classroom[r].length - 1; c++) {
                    if (classroom[r][c] != 0) continue; // 이미 학생이 정해진 자리는 건너뜀

                    int favorite = 0; // 인접한 좋아하는 학생 수
                    int blank = 0; // 인접 빈칸 수

                    // favorite 값 구하기
                    for (int i = 0; i < direct.length; i++) {
                        int R = r + direct[i][0];
                        int C = c + direct[i][1];
                        // 현 위치가 마진 테두리가 아닌 경우에만 계산해야함
                        if (R != 0 && C != 0 && R != classroom.length-1 && C != classroom.length-1) {
                            if (classroom[R][C] == 0) { // 빈칸일 경우
                                blank++;
                                continue;
                            }
                            if (students[s].contains(classroom[R][C])) { // 좋아하는 학생일 경우
                                favorite++;
                            }
                        }
                    }

                    // favorite 값이 현재 최대치인지 검사
                    if (favorite < sMax) continue; // student 값이 최대값보다 작으면 후보에서 제외하여 저장하지 않음
                    if (favorite > sMax) { // student 값이 갱신되었다면 후보배열 내 정보들을 모두 초기화 후 저장함
                        sMax = favorite;
                        info.clear();
                    }
                    info.add(new PlaceInfo(blank, r, c));
                }
            }

            // 2-2. 후보군을 인접 빈칸 수의 내림차순으로 정렬
            // 2차원 배열을 row와 col값이 점점커지는 방향으로 탐색하므로, 행과 열의 경우 알아서 작은 값 부터 저장됨
            PlaceInfo[] infoArr = info.toArray(new PlaceInfo[info.size()]);
            Arrays.sort(infoArr, PlaceInfo.blanksComparator);
            // 정렬 후 가장 상위에 있는 자리가 조건을 만족하는 자리가 됨
            classroom[infoArr[0].getRow()][infoArr[0].getCol()] = students[s].get(0);
/*
//          ======================= 후보군 테이블 디버깅 ============================
//          System.out.println("======" + s + "번째 학생: " + students[s].get(0));
//          for (int i = 0; i < infoArr.length; i++)
//               System.out.println("info(" + i + ")" + infoArr[i].toString());
*/
        }
/*
//        =================== 자리배치확인 =======================
//        for (int i = 1; i < classroom.length - 1; i++) {
//            for (int j = 1; j < classroom.length - 1; j++) {
//                System.out.print(classroom[i][j] + " ");
//            }
//            System.out.println();
//        }
 */

        // 3. 학생의 만족도 계산
        int satisfaction = 0;
        for (ArrayList<Integer> student : students) {
            int id = student.get(0); // 학생 번호
            int count = 0; // 인접 칸에 앉은 좋아하는 학생 수
            // 3-1. 좋아하는 학생 수 계산
            for (int r = 1; r < classroom.length - 1; r++) {
                for (int c = 1; c < classroom[r].length - 1; c++) {
                    if (classroom[r][c] == id) { // 자리배치도에서 해당 학생을 찾으면 계산
                        // 상하좌우 탐색
                        for (int i = 0; i < direct.length; i++) {
                            int R = r + direct[i][0];
                            int C = c + direct[i][1];
                            // 현 위치가 마진 테두리가 아닌 경우에만 계산
                            if (R != 0 && C != 0 && R != classroom.length - 1 && C != classroom.length - 1) {
                                if (student.contains(classroom[R][C])) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            // 3-2. 만족도 계산
            switch (count) {
                case 1:
                    satisfaction++;
                    break;
                case 2:
                    satisfaction += 10;
                    break;
                case 3:
                    satisfaction += 100;
                    break;
                case 4:
                    satisfaction += 1000;
            }
        }
        // 4. 만족도 출력
        System.out.println(satisfaction);
    }

    static class PlaceInfo {
        private int blanks; // 인접한 빈칸 수
        private int row; // 해당 자리의 행
        private int col; // 해당 자리의 열

        public PlaceInfo (int blanks, int row, int col) {
            this.blanks = blanks;
            this.row = row;
            this.col = col;
        }

        // 인접 빈칸 수를 내림차순으로 정렬한다
        public static Comparator<PlaceInfo> blanksComparator = new Comparator<PlaceInfo>() {
            @Override
            public int compare(PlaceInfo o1, PlaceInfo o2) {
                return o2.blanks - o1.blanks;
            }
        };

        public int getBlanks() {
            return blanks;
        }

        public void setBlanks(int blanks) {
            this.blanks = blanks;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public String toString() {
            return " [blank=" + blanks + ", row=" + row + ", col=" + col + "]";
        }
    }
}
