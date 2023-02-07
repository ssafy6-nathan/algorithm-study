N = int(input())
damage = list(map(int, input().split()))
happy = list(map(int, input().split()))

dp = [0 for _ in range(101)]

for p in range(N):
    for i in range(100, damage[p], -1):
        dp[i] = max(dp[i], dp[i - damage[p]] + happy[p])


print(dp[100])