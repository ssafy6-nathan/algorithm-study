import sys
input = sys.stdin.readline

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
bit = [(1 << i) for i in range(N)]
min_dif = float('inf')

for t in range(1, (1 << N) - 1):
    team1_score = 0
    team2_score = 0
    for i in range(N - 1):
        for j in range(i + 1, N):
            if t & bit[i] > 0 and t & bit[j] > 0:
                team1_score += arr[i][j] + arr[j][i]
            elif t & bit[i] == 0 and t & bit[j] == 0:
                team2_score += arr[i][j] + arr[j][i]

    dif = abs(team1_score - team2_score)
    if min_dif > dif:
        min_dif = dif

    if min_dif == 0:
        break


print(min_dif)