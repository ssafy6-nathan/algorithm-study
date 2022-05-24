N = int(input())

# 둘다 없은 경우, 1번에 위치한 경우, 2번에 위치한 경우
dp = [[0, 0, 0] for _ in range(N+1)]


dp[1] = [1, 1, 1]


for i in range(2, N+1):
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901

print((dp[N][0] + dp[N][1] + dp[N][2]) % 9901)