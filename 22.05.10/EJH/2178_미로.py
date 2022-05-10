from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

N, M = map(int, input().split())

arr = [[0 for _ in range(M+2)] for _ in range(N+2)]

for i in range(N):
    a = input()
    for j in range(M):
        arr[i + 1][j + 1] = a[j]


visited = [[False for _ in range(M+2)] for _ in range(N+2)]

qu = deque()
qu.append((1, 1, 1))
visited[1][1] = True
answer = 0
while qu:
    x, y, l = qu.popleft()
    if x == N and y == M:
        answer = l
        break

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if (arr[nx][ny] == '1') and (not visited[nx][ny]):
            visited[nx][ny] = True
            qu.append((nx, ny, l + 1))

print(answer)




