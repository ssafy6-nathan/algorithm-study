# dp로 푸는법
T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if i == 1:
                dp[i][j] = j
            elif j == i:
                dp[i][j] = 1
            elif j > i:
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]

    print(dp[N][M])
