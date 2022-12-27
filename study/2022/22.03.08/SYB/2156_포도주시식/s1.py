import sys
sys.stdin = open('input.txt')

n = int(input())
wines = []

# n개의 포도주 리스트 생성
for _ in range(n):
    wines.append(int(input()))

dp = [wines[0]]

# n이 2 이상일 때 dp[1] 값
if n > 1:
    dp.append(wines[0] + wines[1])

# n이 3 이상일 때, dp[2] 값
if n > 2:
    dp.append(max(wines[0] + wines[2], wines[1] + wines[2], dp[1]))

for i in range(3, n):
    dp.append(max(dp[i-3] + wines[i-1] + wines[i], dp[i-2] + wines[i], dp[i-1]))

print(dp[-1])