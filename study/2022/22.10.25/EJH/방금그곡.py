import math


def solution(m, musicinfos):
    answer = "(None)"
    duration = 0
    m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")

    for mu in musicinfos:
        musicinfo = list(mu.split(","))
        h1, m1 = map(int, musicinfo[0].split(":"))
        h2, m2 = map(int, musicinfo[1].split(":"))
        time = (h2 - h1) * 60 + m2 - m1

        melody = musicinfo[3]
        melody = melody.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")

        melody *= math.ceil(time / len(melody))
        melody = melody[:time]

        if m in melody and duration < time:
            answer = musicinfo[2]
            duration = time

    return answer



print(solution("ABCDEFG",	["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
print(solution("CC#BCC#BCC#BCC#B",	["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
print(solution("ABC",	["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))