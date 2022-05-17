N, K = map(int, input().split())
arr = list(map(int, input().split()))

result = -100*K

total = 0
for j in range(K):
    total += arr[j]

if total > result:
    result = total


for i in range(0, N-K):
    total -= arr[i]
    total += arr[i+K]

    if total > result:
        result = total

print(result)