def polling(arr, N):
    if len(arr) == 1:
        return arr[0][0]
    n_arr = []
    for i in range(N // 2):
        nr_arr = []
        for j in range(N // 2):
            nc_arr = [arr[i * 2][j * 2], arr[i * 2 + 1][j * 2], arr[i * 2][j * 2 + 1], arr[i * 2 + 1][j * 2 + 1]]

            nc_arr.sort()

            nr_arr.append(nc_arr[2])
        n_arr.append(nr_arr)
    return polling(n_arr, N // 2)


N = int(input())
arr = []

for _ in range(N):
    arr.append(list(map(int, input().split())))

print(polling(arr, N))
