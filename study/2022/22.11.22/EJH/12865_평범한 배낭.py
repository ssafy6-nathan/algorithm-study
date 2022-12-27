N, K = map(int, input().split())

things = []

for i in range(N):
    W, V = map(int, input().split())
    things.append((W, V))

dp = [0 for _ in range(K + 1)]

for thing in things:
    for i in range(K, thing[0] - 1, -1):
        dp[i] = max(dp[i], dp[i - thing[0]] + thing[1])

print(dp[K])