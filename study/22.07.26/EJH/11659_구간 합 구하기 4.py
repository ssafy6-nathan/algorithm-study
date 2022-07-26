import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [0] + list(map(int, input().split()))

sum_arr = [0 for _ in range(N + 1)]

for i in range(1, N + 1):
    sum_arr[i] = sum_arr[i - 1] + arr[i]

for _ in range(M):
    start, end = map(int, input().split())
    print(sum_arr[end] - sum_arr[start - 1])