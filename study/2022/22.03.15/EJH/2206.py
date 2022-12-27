from collections import deque

import sys
N, M = map(int, sys.stdin.readline().split())
Map = [list(map(int, input())) for _ in range(N)]
visited = [[[True, True] for _ in range(M)] for _ in range(N)]

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

min_distance = -1
queue = deque()
queue.append((0, 0, 1, 0)) # r, c, distance, crush(벽 부쉈는지 체크)

visited[0][0][0] = False

while queue:
    r, c, distance, crush = queue.popleft()
    if r == N - 1 and c == M - 1:
        min_distance = distance
        break

    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]

        if 0 <= nr < N and 0 <= nc < M:
            if Map[nr][nc] == 0 and visited[nr][nc][crush]:
                queue.append((nr, nc, distance+1, crush))
                visited[nr][nc][crush] = False
            if Map[nr][nc] == 1 and crush == 0:
                queue.append((nr, nc, distance + 1, crush + 1))
                visited[nr][nc][crush+1] = False


print(min_distance)

