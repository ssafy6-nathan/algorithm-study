import sys

input = sys.stdin.readline


N, H = map(int, input().split())

arr = [int(input()) for _ in range(N)]

broken_up = [0 for _ in range(H + 1)]
broken_down = [0 for _ in range(H + 1)]


for n in range(N // 2):
    broken_down[arr[2 * n]] += 1
    broken_up[arr[2 * n + 1]] += 1


for h in range(H - 1, 0, -1):
    broken_down[h] += broken_down[h + 1]
    broken_up[h] += broken_up[h + 1]

height = broken_down[1] + broken_up[-1]
count = 1
for h in range(1, H):
    if broken_down[h] + broken_up[H - h + 1] < height:
        height = broken_down[h] + broken_up[H - h + 1]
        count = 1
    elif broken_down[h] + broken_up[H - h + 1] == height:
        count += 1

print(height, count)

