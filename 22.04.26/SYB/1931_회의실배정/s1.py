N = int(input())

meeting = list()

for _ in range(N):
    start, end = map(int, input().split())
    meeting.append([start, end])

# 1. 끝나는 시간 오름차순 2. 시작시간 오름차순 정렬
meeting.sort(key=lambda x: (x[1], x[0]))

ans = 0
end_time = 0

for s, e in meeting:
    if s >= end_time:
        ans += 1
        end_time = e

print(ans)
