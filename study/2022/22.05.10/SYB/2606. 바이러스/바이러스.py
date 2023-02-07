computers = int(input())
pairs = int(input())

arr = [[0] * (computers+1) for _ in range(computers+1)]

for _ in range(pairs):
    a, b = map(int, input().split())
    arr[a][b] = 1
    arr[b][a] = 1

visited = [0] * (computers+1)

ans = 0

q = [(1)]
visited[1] = 1

while q:
    x = q.pop(0)

    for i in range(1, computers+1):
        if arr[x][i] and not visited[i]:
            ans += 1
            visited[i] = 1
            q.append(i)

print(ans)
