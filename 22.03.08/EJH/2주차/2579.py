N = int(input())

stairs = []
dp = [0] * N

for i in range(N):
    stair = int(input())
    stairs.append(stair)

dp[0] = stairs[0]
if N > 1:
    dp[1] = stairs[1] + stairs[0]
if N > 2:
    dp[2] = max(stairs[1] + stairs[2], stairs[0] + stairs[2])
for i in range(3, N):
    dp[i] = max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i]

print(dp[N-1])

