import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    book = [0] + list(map(int, sys.stdin.readline().split()))

    d = [[0 for _ in range(N+1)] for _ in range(N+1)]

    for i in range(2, N+1):
        for j in range(1, N + 2 - i):
            d[j][j+i-1] = min([d[j][j+k] + d[j+k+1][j+i-1] for k in range(i-1)]) + sum(book[j:j+i])

    print(d[1][N])
