import sys
from collections import deque

sys.stdin = open('input.txt')


# bfs 함수 작성
def bfs():
    global ans

    while q:
        x, y = q.popleft()
        # 8방향 탐색
        for d in range(8):
            nx = x + dx[d]
            ny = y + dy[d]
            # nx, ny 좌표가 범위 내에 있으면
            if 0 <= nx < N and 0 <= ny < M:
                if mat[nx][ny] == 0:
                    q.append((nx, ny))
                    mat[nx][ny] = mat[x][y] + 1
                    ans = max(ans, mat[nx][ny])


N, M = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(N)]

q = deque()

# 아기 상어 좌표 찾기
for i in range(N):
    for j in range(M):
        if mat[i][j] == 1:
            q.append((i, j))

# → 부터 시계방향
dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [1, 1, 0, -1, -1, -1, 0, 1]

ans = 0
bfs()

print(ans - 1)