N, M, K = map(int, input().split())

maps = [[0] * M for _ in range(N)]
visited = [[0] * M for _ in range(N)]

for _ in range(K):
    r, c = map(int, input().split())
    maps[r - 1][c - 1] = 1

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]


def bfs(x, y):
    size = 1
    q = [(x, y)]
    visited[x][y] = 1

    while q:
        x, y = q.pop()

        for i in range(4):
            nx = x + dr[i]
            ny = y + dc[i]

            if nx in range(N) and ny in range(M) and not visited[nx][ny] and maps[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = 1
                size += 1

    return size


ans = 0
for i in range(N):
    for j in range(M):
        if maps[i][j] == 1:
            cnt = bfs(i, j)
            if cnt >= ans:
                ans = cnt

print(ans)
