import sys
N = int(sys.stdin.readline())

arr = [[*map(int, sys.stdin.readline().split())] for _ in range(N)]

arr.sort(key=lambda x: (x[1], x[0]))

count = 1

last_t = arr[0][1]

for i in range(1, N):
    if arr[i][0] >= last_t:
        last_t = arr[i][1]
        count += 1

print(count)
