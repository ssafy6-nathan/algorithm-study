def dfs(cnt, lotto, start, end, arr):
    if cnt == 6:
        print(*lotto)
        return

    for i in range(start, end + 1):
        if end - i + cnt < 5:
            break
        lotto[cnt] = arr[i]
        dfs(cnt+1, lotto, i + 1, end, arr)


while True:
    lotto = [0, 0, 0, 0, 0, 0]
    arr = list(map(int, input().split()))

    if arr[0] == 0:
        break

    dfs(0, lotto, 1, arr[0], arr)
    print()

