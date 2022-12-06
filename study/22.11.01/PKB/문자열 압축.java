lass Solution {

    public int solution(String s) {

        int len = s.length();
        // 원래 문자열 길이가 최대
        int answer = len;
        StringBuilder sb;

        // 문자열을 자르는 단위는 1개 부터 문자열 길이의 절반 까지
        for (int i = 1, l = len / 2; i <= l; i++) {
            sb = new StringBuilder();

            // 제일 앞부터 단위만큼 자르기
            String sub1 = s.substring(0, i);
            int cnt = 1;

            // sub1 로 한 묶음이 나왔기 때문에 인덱스 i 에서부터 비교 시작
            for (int j = i; j <= len; j += i) {
                // 다음 문자열 자르기
                // 문자열이 단위대로 딱 떨어지지 않는다면 인덱스의 최댓값은 문자열의 길이
                String sub2 = s.substring(j, Math.min(j + i, len));

                // 같다면 개수 증가
                if (sub1.equals(sub2)) cnt++;
                // 다르다면
                else {
                    // 같은 개수가 2개 이상이면 개수 적어주기
                    if (cnt > 1) sb.append(cnt);

                    // 문자 붙이고
                    sb.append(sub1);
                    // 뒤에 남는 문자가 있을 수 있기 때문에 저장
                    sub1 = sub2;
                    // 개수는 다시 1개로
                    cnt = 1;
                }
            }

            // 안 들어간 숫자 있으면 붙이고
            if (cnt > 1) sb.append(cnt);
            // 마지막 남은 문자 붙이기
            sb.append(sub1);

            // 문자열 길이 최솟값 저장
            answer = Math.min(answer, sb.length());
        }

        return answer;

    }

}
