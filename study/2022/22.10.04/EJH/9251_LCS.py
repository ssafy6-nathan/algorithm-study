str1 = input()
str2 = input()

l1, l2 = len(str1), len(str2)
dp = [[0 for _ in range(l2 + 1)] for _ in range(l1 + 1)]

for i in range(1, l1 + 1):
    for j in range(1, l2 + 1):
        if str1[i - 1] == str2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[l1][l2])
