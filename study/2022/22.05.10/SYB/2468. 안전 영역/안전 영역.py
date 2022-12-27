from collections import deque


def bfs(x, y, h):

    Q = deque()
    Q.append((x, y))
    visited[x][y] = 1

    while Q:
        x, y = Q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx in range(N) and ny in range(N) and arr[nx][ny] > h and not visited[nx][ny]:
                visited[nx][ny] = 1
                Q.append((nx, ny))


N = int(input())
arr = []

max_h = 0

for _ in range(N):
    tmp = list(map(int, input().split()))
    max_h = max(max_h, max(tmp))
    arr.append(tmp)

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

ans = 0
for i in range(max_h):
    visited = [[0] * N for _ in range(N)]
    cnt = 0

    for j in range(N):
        for k in range(N):
            if arr[j][k] > i and not visited[j][k]:
                bfs(j, k, i)
                cnt += 1

    ans = max(ans, cnt)

print(ans)
