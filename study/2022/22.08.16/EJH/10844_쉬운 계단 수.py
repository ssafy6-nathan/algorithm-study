N = int(input())
MOD = 1000000000
arr = [0] + [1 for _ in range(9)]

n = 1

while n < N:
    next_arr = [0 for _ in range(10)]
    for i in range(10):
        if i - 1 >= 0:
            next_arr[i] += arr[i - 1]
        if i + 1 < 10:
            next_arr[i] += arr[i + 1]
    n += 1
    arr = next_arr

print(sum(arr) % MOD)