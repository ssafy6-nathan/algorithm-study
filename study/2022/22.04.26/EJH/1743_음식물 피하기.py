from collections import deque

N, M, K = map(int, input().split())

arr = [[False for _ in range(M+2)] for _ in range(N+2)]

trash = deque()

for _ in range(K):
    r, c = map(int,input().split())

    arr[r][c] = True

    trash.append((r, c))
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

count = 0
while trash:
    r, c = trash.popleft()
    n_count = 0
    arr[r][c] = False
    chain_trash = deque()
    chain_trash.append((r, c))

    while chain_trash:
        r, c = chain_trash.popleft()

        n_count += 1

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if arr[nr][nc]:
                arr[nr][nc] = False
                chain_trash.append((nr, nc))

    count = max(count, n_count)

print(count)
