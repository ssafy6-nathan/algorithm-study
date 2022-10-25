class Solution {

    public String solution(String m, String[] musicinfos) {

        String answer = "(None)";
        m = changeMelody(m);
        int maxPlayTime = -1;
        StringBuilder sb;

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");

            int playTime = getPlayTime(info[0].split(":"), info[1].split(":"));
            String title = info[2];
            String melody = changeMelody(info[3]);

            int melodyLen = melody.length();

            // 재생 시간 > 음악 길이
            if (playTime > melodyLen) {
                sb = new StringBuilder();

                // 반복된 횟수(몫)만큼 멜로디 추가
                for (int i = 0, len = playTime / melodyLen; i < len; i++) {
                    sb.append(melody);
                }

                // 남은 시간(나머지)만큼 멜로디 추가
                sb.append(melody.substring(0, playTime % melodyLen));

                // 재생된 멜로디
                melody = sb.toString();
            // 재생 시간 <= 음악 길이 일 때는 처음부터 재생 시간만큼만 멜로디 추가
            } else melody = melody.substring(0, playTime);

            // 재생된 멜로디 안에 기억한 멜로디가 포함되었는지 확인
            // 재생 시간이 같을 경우 먼저 나온 음악 제목으로
            if (melody.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }

        return answer;

    }

    // 멜로디 변경
    private static String changeMelody(String melody) {

        return melody.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

    }

    // 음악 재생 시간
    private static int getPlayTime(String[] start, String[] end) {

        return (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));

    }

}
