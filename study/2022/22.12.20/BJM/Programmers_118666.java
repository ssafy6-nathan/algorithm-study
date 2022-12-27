package week41;

/**
 * 프로그래머스 118666번
 * 성격 유형 검사하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/118666)
 **/
public class Programmers_118666 {
    public static void main(String[] args) {
        String[][] survey = {{"AN", "CF", "MJ", "RT", "NA"}, {"TR", "RT", "TR"}};
        int[][] choices = {{5, 3, 2, 7, 5}, {7, 1, 3}};
        for (int i = 0; i < survey.length; i++) {
            System.out.println(solution(survey[i], choices[i]));
        }
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder(); // 정답(성격 유형) 저장
        int[] score = new int[8]; // 유형별 점수 저장 (R T C F J M A N)

        for (int i = 0; i < survey.length; i++) {
            // 1. 문항의 검사 유형 확인
            String str = survey[i];
            int idx1 = toIndex(str.charAt(0));
            int idx2 = toIndex(str.charAt(1));

            // 2. 질문의 선택지 확인
            int choice = choices[i];
            if (choice <= 3) { // 비동의에 해당하는 경우
                score[idx1] += 4 - choice;
            }
            else if (choice >= 5) { // 동의에 해당하는 경우
                score[idx2] += choice - 4;
            }
        }

        // 3. 점수를 확인하여 성격 유형 저장
        int idx = 0; // 포인터
        while (idx <= 6) {
            if (score[idx] == score[idx+1]) { // 점수가 같은 경우 사전 순서 상 앞자리인 유형
                sb.append(toAnswer(idx));
            }
            else if (score[idx] > score[idx+1]) {
                sb.append(toAnswer(idx));
            }
            else {
                sb.append(toAnswer(idx+1));
            }
            idx += 2;
        }

        return sb.toString();
    }

    private static int toIndex (char c) {
        switch (c) {
            case 'R':
                return 0;
            case 'T':
                return 1;
            case 'C':
                return 2;
            case 'F':
                return 3;
            case 'J':
                return 4;
            case 'M':
                return 5;
            case 'A':
                return 6;
            case 'N':
                return 7;
            default:
                return -1;
        }
    }

    private static String toAnswer (int idx) {
        switch (idx) {
            case 0:
                return "R";
            case 1:
                return "T";
            case 2:
                return "C";
            case 3:
                return "F";
            case 4:
                return "J";
            case 5:
                return "M";
            case 6:
                return "A";
            case 7:
                return "N";
            default:
                return "-1";
        }
    }
}
