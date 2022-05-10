from collections import deque
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

maze = [list(map(int, ' '.join(input()).split())) for _ in range(N)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def bfs(x, y):

    q = deque()
    q.append((x, y))

    while q:

        x, y = q.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if nx in range(N) and ny in range(M):
                if maze[nx][ny] == 1:
                    maze[nx][ny] = maze[x][y] + 1
                    q.append((nx, ny))


bfs(0, 0)

print(maze[N - 1][M - 1])