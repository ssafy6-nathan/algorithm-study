import sys
input = sys.stdin.readline

N = int(input())
T = []
P = []
dp = [0] * (N+1)

for i in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

M = 0
for i in range(N):
    M = max(M, dp[i])
    if i + T[i] > N:
        continue
    dp[i + T[i]] = max(M + P[i], dp[i + T[i]])

print(max(dp))
