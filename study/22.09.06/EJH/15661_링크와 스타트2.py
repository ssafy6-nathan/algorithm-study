import sys
from itertools import combinations

input = sys.stdin.readline

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

row = [sum(i) for i in arr]
col = [sum(i) for i in zip(*arr)]
new_arr = [i + j for i, j in zip(row, col)]
total_sum = sum(new_arr) // 2

min_dif = float('inf')

for t in range(1, N // 2 + 1):
    for combi in combinations(new_arr, t):
        dif = abs(total_sum-sum(combi))
        if min_dif > dif:
            min_dif = dif
        if min_dif == 0:
            break
    if min_dif == 0:
        break

print(min_dif)