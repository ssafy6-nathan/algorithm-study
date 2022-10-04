T = int(input())

for _ in range(T):
    k = int(input())
    n = int(input())

    apt = [[i for i in range(15)]] + [[0 for i in range(15)] for i in range(14)]

    for layer in range(1, k + 1):
        for ho in range(1, n + 1):
            apt[layer][ho] = apt[layer][ho - 1] + apt[layer - 1][ho]

    print(apt[k][n])
