N, M = map(int, input().split())

arr = [[False for _ in range(M + 1)] for _ in range(N + 1)]
count = 0


def dfs(cnt):
    global count
    if cnt == N*M:
        count += 1
        return

    r = cnt // M + 1
    c = cnt % M + 1

    arr[r][c] = True
    if not (arr[r - 1][c] and arr[r][c - 1] and arr[r - 1][c - 1]):
        dfs(cnt + 1)
    arr[r][c] = False
    dfs(cnt + 1)


dfs(0)
print(count)