T = int(input())

for t in range(T):
    N = int(input())
    arr = []
    arr.append([0]+list(map(int, input().split())))
    arr.append([0] + list(map(int, input().split())))

    result = [[0 for _ in range(3)] for _ in range(2)]

    result[0][1] = arr[0][1]
    result[1][1] = arr[1][1]

    for i in range(2, N+1):
        result[0][2] = max(result[1][1] + arr[0][i], result[1][0] + arr[0][i])
        result[1][2] = max(result[0][1] + arr[1][i], result[0][0] + arr[1][i])

        for j in range(2):
            result[0][j] = result[0][j + 1]
            result[1][j] = result[1][j + 1]

    print(max(result[0][1], result[1][1]))


