from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def bfs(arr, a, b, value, visited):
    q = deque()
    q.append((a, b))
    visited[a][b] = 1

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if arr[nx][ny] > value and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append((nx, ny))


N = int(input())


arr = [[0 for _ in range(N+2)]]
max_num = 0
for i in range(N):
    a = [0] + list(map(int, input().split())) +[0]
    arr.append(a)
    for j in range(N):
        if arr[i+1][j+1] > max_num:
            max_num = arr[i+1][j+1]

arr.append([0 for _ in range(N+2)])

answer = 1
for w in range(1, max_num):
    visited = [[False for _ in range(N+2)] for _ in range(N+2)]
    cnt = 0

    for i in range(1, N+2):
        for j in range(1, N+2):
            if arr[i][j] > w and not visited[i][j]:
                bfs(arr, i, j, w, visited)
                cnt += 1

    if answer < cnt:
        answer = cnt

print(answer)