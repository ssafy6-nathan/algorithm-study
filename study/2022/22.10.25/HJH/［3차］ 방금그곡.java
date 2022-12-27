class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

        for (String str : musicinfos) {
            String[] info = str.split(",");
            // 음악 재생 시간
            int playTime = getPlayTime(info[0], info[1]);
            String title = info[2];
            String melody = info[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

            // 재생 시간 > 멜로디
            if (playTime > melody.length()) {
                StringBuilder sb = new StringBuilder();
                // 몫만큼 멜로디 반복
                int q = playTime / melody.length();
                for (int i = 0; i < q; i++) {
                    sb.append(melody);
                }
                // 나머지만큼 멜로디 추가
                int r = playTime % melody.length();
                sb.append(melody.substring(0, r));
                melody = sb.toString();
            } else {
                // 재생 시간 < 멜로디 : 재생 시간만큼만 멜로디 추가
                melody = melody.substring(0, playTime);
            }

            // 조건 일치하는 음악이 여러개일 경우 : 멜로디 비교(위에서 함) + 재생 시간 비교
            // 도 같다면 먼저 나온 음악 출력
            if (melody.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }
       return answer;
    }

    public static int getPlayTime(String s, String e) {
        String[] S = s.split(":");
        String[] E = e.split(":");
        int hour = (Integer.parseInt(E[0]) - Integer.parseInt(S[0])) * 60;
        int min = Integer.parseInt(E[1]) - Integer.parseInt(S[1]);
        return hour + min;
    }
}
