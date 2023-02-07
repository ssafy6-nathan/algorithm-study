import sys
sys.stdin = open('input.txt')


def dfs(x, y):
    global arr, cnt, dx, dy

    arr[x][y] = 0
    cnt += 1

    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]

        if 0 <= nx < N and 0 <= ny < N and arr[nx][ny]:
            dfs(nx, ny)


N = int(input())
arr = []

for _ in range(N):
    arr.append(list(map(int, input())))


# 우 하 좌 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

blocks = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            cnt = 0
            dfs(i, j)
            blocks.append(cnt)

blocks.sort()
print(len(blocks))
for block in blocks:
    print(block)