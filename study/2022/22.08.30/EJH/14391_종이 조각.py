N, M = map(int, input().split())
arr = [list(map(int, input().strip())) for _ in range(N)]


result = 0
for n in range(1 << N*M):
    total = 0
    for r in range(N):
        num = 0
        for c in range(M):
            i = r * M + c
            if n & (1 << i) == 0:
                num = num * 10 + arr[r][c]
            else:
                total += num
                num = 0
        total += num

    for c in range(M):
        num = 0
        for r in range(N):
            i = r * M + c
            if n & (1 << i) != 0:
                num = num * 10 + arr[r][c]
            else:
                total += num
                num = 0
        total += num

    if result < total:
        result = total

print(result)
