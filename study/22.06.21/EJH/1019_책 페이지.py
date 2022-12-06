N = int(input())
arr = [0 for _ in range(10)]

point = 1

while N > 0:
    if N < 10:
        for i in range(1, N + 1):
            arr[i] += point
        break
    while N % 10 != 9:
        for s in str(N):
            arr[int(s)] += point
        N -= 1

    for i in range(10):
        arr[i] += (N // 10 + 1) * point
    arr[0] -= point
    point *= 10
    N //= 10

print(*arr)