N = int(input())
arr = [0]
for i in range(N):
    arr.append(int(input()))

dp = [0 for i in range(len(arr))]

for i in range(1, len(arr)):
    for j in range(0, i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(N - max(dp))