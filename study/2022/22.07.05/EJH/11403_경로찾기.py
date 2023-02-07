N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        if k == i:
            continue
        for j in range(N):
            if k == j:
                continue
            if arr[i][k] == 1 and arr[k][j] == 1:
                arr[i][j] = 1

for a in arr:
    print(*a)