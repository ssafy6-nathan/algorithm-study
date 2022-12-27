import sys
from collections import deque

sys.stdin = open('input.txt')


def bfs():
    global dx, dy, visited

    # 좌표 [0,0] 에서 벽을 아직 뚫지 않음 0 으로 초기화
    q = deque([(0, 0, 0)])
    visited[0][0][0] = 1

    while q:
        x, y, wall = q.popleft()

        if x == N-1 and y == M-1:
            return visited[x][y][wall]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (0 <= nx < N) and (0 <= ny < M) and (visited[nx][ny][wall] == 0):
                # 아직 벽을 부수지 않았고, 다음 이동할 곳이 벽일 경우
                if wall == 0 and arr[nx][ny] == 1:
                    visited[nx][ny][1] = visited[x][y][0] + 1
                    q.append((nx, ny, 1))

                # 다음 이동할 곳이 벽이 아닌 경우
                if arr[nx][ny] == 0:
                    visited[nx][ny][wall] = visited[x][y][wall] + 1
                    q.append((nx, ny, wall))

    return -1


N, M = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]

# 4방향 - 우 하 좌 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# 3차원 리스트 생성
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]

ans = bfs()
print(ans)
