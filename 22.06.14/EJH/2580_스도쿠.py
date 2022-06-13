def check_h(r, c, num, arr):  # 가로 검사
    for i in range(9):
        if arr[i][c] == num:
            return False
    return True


def check_v(r, c, num, arr):  # 세로 검사
    for i in range(9):
        if arr[r][i] == num:
            return False
    return True


def check_s(r, c, num, arr):  # 3X3 검사
    nr = (r // 3) * 3
    nc = (c // 3) * 3
    for i in range(3):
        for j in range(3):
            if arr[nr + i][nc + j] == num:
                return False
    return True


def dfs(cnt, empty, arr):
    if cnt == len(empty):
        for a in arr:
            print(*a)
        exit(0)

    r, c = empty[cnt]
    for num in range(1, 10):

        if check_h(r, c, num, arr) and check_v(r, c, num, arr) and check_s(r, c, num, arr):
            arr[r][c] = num
            dfs(cnt + 1, empty, arr)
            arr[r][c] = 0


arr = []
empty = []

for i in range(9):
    ai = list(map(int, input().split()))
    for j in range(9):
        if ai[j] == 0:
            empty.append([i, j])

    arr.append(ai)

dfs(0, empty, arr)
