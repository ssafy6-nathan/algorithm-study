import sys
from collections import deque

sys.stdin = open('input.txt')


def bfs(a, b, arr):
    q = deque()
    q.append((a, b))

    while q:
        x, y = q.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if (nx in range(N) and ny in range(M)) and arr[nx][ny] == 1:
                arr[nx][ny] = 0
                q.append((nx, ny))


dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

T = int(input())
for tc in range(1, T+1):
    M, N, K = map(int, input().split())

    mat = [[0] * M for _ in range(N)]

    for _ in range(K):
        X, Y = map(int, input().split())
        mat[Y][X] = 1

    ans = 0
    for i in range(N):
        for j in range(M):
            if mat[i][j] == 1:
                bfs(i, j, mat)
                ans += 1

    print(ans)