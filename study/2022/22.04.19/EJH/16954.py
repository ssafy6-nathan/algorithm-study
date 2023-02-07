from collections import deque

dr = [0, 0, 1, -1, 1, -1, 1, -1, 0]
dc = [1, -1, 0, 0, 1, 1, -1, -1, 0]

n = 8
MAP = [list(input().strip()) for _ in range(n)]
visited = [[False for _ in range(8)] for _ in range(n)]

q = deque()
q.append((7, 0))
visited[7][0] = True

answer = 0
while q:
    r, c = q.popleft()
    if MAP[r][c] == '#':
        continue
    for d in range(9):
        nr = r + dr[d]
        nc = c + dc[d]

        if nr < 0 or nr >= n or nc < 0 or nc >= n or MAP[nr][nc] == '#':
            continue
        if nr == 0:
            answer = 1
        if not visited[nr-1][nc]:
            visited[nr - 1][nc] = True
            q.append((nr - 1, nc))

print(answer)