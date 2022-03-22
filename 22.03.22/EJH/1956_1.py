# 플로이드 와샬 풀이

import math

V, E = map(int, input().split())

INF = math.inf

arr = [[INF for _ in range(V)] for _ in range(V)]

for _ in range(E):
    a, b, c = map(int, input().split())
    arr[a-1][b-1] = c

for k in range(V):
    for i in range(V):
        for j in range(V):
            arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])

result = INF
for i in range(V):
    result = min(result, arr[i][i])

if result == INF:
    result = -1
print(result)