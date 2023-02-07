from collections import deque

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

N = int(input())
Map = [list(map(int, input())) for _ in range(N)]


def bfs(Map, N, r, c):
    queue = deque()
    queue.append((r, c))
    Map[r][c] = 0

    count = 1
    while queue:
        r, c = queue.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < N and 0 <= nc < N:
                if Map[nr][nc] == 1:
                    Map[nr][nc] = 0
                    count += 1
                    queue.append((nr, nc))
    return count


cnt = []
for r in range(N):
    for c in range(N):
        if Map[r][c] == 1:
            cnt.append(bfs(Map, N, r, c))

cnt.sort()
print(len(cnt))
for c in cnt:
    print(c)
