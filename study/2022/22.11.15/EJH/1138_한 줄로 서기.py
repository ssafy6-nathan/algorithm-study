N = int(input())
arr = list(map(int, input().split()))

result = [0 for _ in range(N)]
visited = [False for _ in range(N)]


for i in range(N):
    for j in range(N):
        if visited[j]:
            continue
        cnt = 0
        for c in range(i):
            if result[c] > j:
                cnt += 1
        if arr[j] == cnt:
            visited[j] = True
            result[i] = j + 1
            break

print(*result)