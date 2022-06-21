def dfs(L, C, arr, password, cnt, start, vow, con):
    if cnt == L:
        if vow >= 1 and con >= 2:
            print("".join(password))
        return

    for i in range(start, C):
        password[cnt] = arr[i]
        if check_vow(arr[i]):   # 모음 이면 vow + 1
            dfs(L, C, arr, password, cnt + 1, i + 1, vow + 1, con)
        else:                   # 자음 이면 con + 1
            dfs(L, C, arr, password, cnt + 1, i + 1, vow, con + 1)


def check_vow(c):   # 모음 판별
    if c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u':
        return True
    else:
        return False

L, C = map(int, input().split())
arr = list(input().split())
arr.sort()
password = [0 for _ in range(L)]
dfs(L, C, arr, password, 0, 0, 0, 0)

