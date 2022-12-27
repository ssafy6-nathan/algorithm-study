N = int(input())

wines = []
dp = [0] * N

for i in range(N):
    wines.append(int(input()))

dp[0] = wines[0]
if N > 1:
    dp[1] = wines[1] + wines[0]
if N > 2:
    dp[2] = max(dp[1], max(wines[1] + wines[2], wines[0] + wines[2]))
for i in range(3, N):
    dp[i] = max(dp[i - 1], max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i])

print(dp[N-1])

