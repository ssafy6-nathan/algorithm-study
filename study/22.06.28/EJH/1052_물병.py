N, K = map(int, input().split())

arr = [N]

count = 0
while True:
    if sum(arr) <= K:
        break
    merge_water = False
    for i in range(len(arr)):
        if arr[i] // 2 > 0:
            merge_water = True
            if i == len(arr) - 1:
                arr += [arr[i] // 2]
                arr[i] = arr[i] % 2
            else:
                arr[i + 1] += arr[i] // 2
                arr[i] = arr[i] % 2

    if not merge_water:
        arr[0] += 1
        count += 1

print(count)