n = int(input())

arr = []

for i in range(n):
    arr.append(list(map(int, input().split())))


for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            max_num = arr[i - 1][j]
        elif j == i:
            max_num = arr[i - 1][j - 1]
        else:
            max_num = max(arr[i - 1][j], arr[i - 1][j - 1])

        arr[i][j] += max_num

print(max(arr[n-1]))




