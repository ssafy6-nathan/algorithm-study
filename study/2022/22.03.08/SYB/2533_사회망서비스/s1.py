import sys
sys.stdin = open('input.txt')

N = int(input())

graph = [[0] * (N+1) for _ in range(N+1)]

for _ in range(N-1):
    u, v = map(int, input().split())
    graph[u][v] = 1

### DP 문제라고 한다.