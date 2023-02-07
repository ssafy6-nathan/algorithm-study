import heapq
import sys

#input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())

student = [[] for _ in range(N + 1)]
degree = [0 for _ in range(N + 1)]
queue = deque()
answer = []


for _ in range(M):
    s1, s2 = map(int, input().split())
    student[s1].append(s2)

    degree[s2] += 1

for i in range(1, N+1):
    if degree[i] == 0:
        queue.append(i)

while queue:
    s = queue.popleft()
    answer.append(s)

    for ns in student[s]:
        degree[ns] -= 1
        if degree[ns] == 0:
            queue.append(ns)

print(*answer)

