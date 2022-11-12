import math

N = int(input())

arr = [0 for i in range(9)]

while N > 0:
    num = N % 10
    if num == 9:
        num = 6
    arr[num] += 1

    N //= 10

arr[6] = math.ceil(arr[6] / 2.0)

print(max(arr))