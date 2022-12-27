dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def set_warm(r, c, filed, cabbage):

    n_cabbage = [(r, c)]

    while n_cabbage:
        x, y = n_cabbage.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if filed[ny][nx] == 1:
                    filed[ny][nx] = 0
                    cabbage.remove((nx, ny))
                    n_cabbage.append((nx, ny))


T = int(input())

for t in range(T):
    M, N, K = map(int, input().split())
    filed = [[0 for i in range(M)] for j in range(N)]
    count = 0

    cabbage = []

    for i in range(K):
        x, y = map(int, input().split())
        cabbage.append((x, y))
        filed[y][x] = 1
    while cabbage:
        x, y = cabbage.pop()
        filed[y][x] = 0
        count += 1
        set_warm(x, y, filed, cabbage)

    print(count)
