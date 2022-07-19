N, M = map(int, input().split())
arr = list(map(int, input().split()))

result = 0

total = arr[0]
start = 0
end = 1

while end <= N and start <= end:
    if total == M:
        result += 1
        total -= arr[start]
        start += 1

    elif total < M:
        if end == N:
            break
        total += arr[end]
        end += 1
    else:
        total -= arr[start]
        start += 1


print(result)