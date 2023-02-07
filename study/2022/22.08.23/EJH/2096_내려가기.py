N = int(input())
min_arr = [0, 0, 0]
max_arr = [0, 0, 0]


max_temp = [0, 0, 0]
min_temp = [0, 0, 0]

for i in range(N):

    arr = list(map(int, input().split()))

    max_temp[0] = max(max_arr[0], max_arr[1]) + arr[0]
    max_temp[1] = max(max_arr[0], max_arr[1], max_arr[2]) + arr[1]
    max_temp[2] = max(max_arr[1], max_arr[2]) + arr[2]

    min_temp[0] = min(min_arr[0], min_arr[1]) + arr[0]
    min_temp[1] = min(min_arr[0], min_arr[1], min_arr[2]) + arr[1]
    min_temp[2] = min(min_arr[1], min_arr[2]) + arr[2]

    for j in range(3):
        max_arr[j] = max_temp[j]
        min_arr[j] = min_temp[j]


print(max(max_arr), min(min_arr))

