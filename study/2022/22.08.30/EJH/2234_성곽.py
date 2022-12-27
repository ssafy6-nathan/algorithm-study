from collections import deque
import sys

input = sys.stdin.readline

dr = [0, -1, 0, 1]
dc = [-1, 0, 1, 0]


def bfs(arr, visited, r, c, N, M):
    q = deque()
    q.append((r, c))
    visited[r][c] = True
    count = 1

    while q:
        r, c = q.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < M and 0 <= nc < N and not visited[nr][nc]:
                if d == 0:
                    if 1 & arr[r][c]:
                        continue
                elif d == 1:
                    if 2 & arr[r][c]:
                        continue
                elif d == 2:
                    if 4 & arr[r][c]:
                        continue
                elif d == 3:
                    if 8 & arr[r][c]:
                        continue

                visited[nr][nc] = True
                q.append((nr, nc))
                count += 1
    return count


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]
visited = [[False for _ in range(N)] for _ in range(M)]

island = 0
island_max_size = 0
island_sum_size = 0
for r in range(M):
    for c in range(N):
        if not visited[r][c]:
            island += 1
            island_max_size = max(island_max_size, bfs(arr, visited, r, c, N, M))

for r in range(M):
    for c in range(N):
        wall = 1
        while wall <= 8:
            if wall & arr[r][c]:
                visited = [[False for _ in range(N)] for _ in range(M)]
                arr[r][c] -= wall
                island_sum_size = max(island_sum_size, bfs(arr, visited, r, c, N, M))
                arr[r][c] += wall

            wall *= 2


print(island)
print(island_max_size)
print(island_sum_size)
