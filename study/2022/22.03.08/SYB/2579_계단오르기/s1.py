import sys
sys.stdin = open('input.txt')

N = int(input())
stairs = []

for _ in range(N):
    stairs.append(int(input()))

dp = [stairs[0]]

if N > 1:
    dp.append(max(dp[0] + stairs[1], stairs[1]))

if N > 2:
    dp.append(max(dp[0] + stairs[2], stairs[1] + stairs[2]))

for i in range(3, N):
    dp.append(max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]))

print(dp[-1])